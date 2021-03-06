const crypto = require('crypto');
const mongoose = require('mongoose');
const validator = require('validator');
const bcrypt = require('bcryptjs');

/**
 * Userschema which exports a user model
 */
const userSchema = new mongoose.Schema({
  name: {
    type: String,
    required: [true, 'Please provide a name'],
  },
  email: {
    type: String,
    required: [true, 'Please provide an email'],
    unique: [true, 'Email should be unique'],
    lowercase: true,
    validate: [validator.isEmail, 'Please provide a valid email'],
  },
  photo: {
    type: String,
    default: 'default.jpg',
  },
  role: {
    type: String,
    enum: ['user', 'guide', 'lead-guide', 'admin'],
    default: 'user',
  },
  password: {
    type: String,
    required: [true, 'Please provide a password'],
    minlength: 8,
    select: false,
  },
  passwordConfirm: {
    type: String,
    required: [true, 'Passwords are not the same'],
    validate: {
      // This only works on save() or on create()
      validator: function (el) {
        return el === this.password; // return either true or false
      },
      message: 'Password do not match',
    },
  },
  passwordChangedAt: Date,
  passwordResetToken: String,
  passwordResetExpires: Date,
  active: {
    type: Boolean,
    default: true,
    select: false,
  },
});

/**
 * Only run this if password is modified
 * Hash the password with cost/salt of 13
 * Delete passwordConfirm Field
 */
userSchema.pre('save', async function (next) {
  if (!this.isModified('password')) return next();

  this.password = await bcrypt.hash(this.password, 12);

  this.passwordConfirm = undefined;
  next();
});

/**
 * Run this middleware right before the save() method
 * Put passwordChangedAt in the past by taking away 1sec
 */
userSchema.pre('save', function (next) {
  if (!this.isModified('password') || this.isNew) return next();

  this.passwordChangedAt = Date.now() - 1000;

  next();
});

/**
 * A function to check/compare password during login (Instance Method)
 * @param {String|bcrypt hashed password} candidatePassword
 * @param {String} userPassword
 * @returns {Boolean} True if candidatePassword === userPassword
 */
userSchema.methods.correctPassword = async function (candidatePassword, userPassword) {
  return await bcrypt.compare(candidatePassword, userPassword);
};

/**
 *
 * @param {*} JWTTimestamp
 * @returns {Boolean} False if passwordChangedAt remains unchanged
 */
userSchema.methods.changePasswordAfter = function (JWTTimestamp) {
  if (this.passwordChangedAt) {
    const changedTimestamp = parseInt(this.passwordChangedAt.getTime() / 1000, 10);

    return JWTTimestamp < changedTimestamp;
  }

  return false;
};

/**
 * Create a less complicated hashed password which is then sent to the user to be used to reset the password
 * The password saved in the db is then the encrypted version of the generated token
 * @returns {String} the token created
 */
userSchema.methods.createPasswordResetToken = function () {
  const resetToken = crypto.randomBytes(32).toString('hex');

  this.passwordResetToken = crypto.createHash('sha256').update(resetToken).digest('hex');
  this.passwordResetExpires = Date.now() + 10 * 600 * 1000;
  console.log({ resetToken }, this.passwordResetToken);

  return resetToken;
};

/**
 * A Query middleware to help filter out anything we don't want users to see
 * THIS points to the current document
 */
userSchema.pre(/^find/, function (next) {
  this.find({ active: { $ne: false } });
  next();
});

const User = mongoose.model('User', userSchema);

module.exports = User;
