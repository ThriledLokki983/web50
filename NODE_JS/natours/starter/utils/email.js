const nodemailer = require('nodemailer');

/**
 * Create a transporter (a service to handle sending the mail) - Activate in service: gmail "less secure app" option
 * Define email options and then finally send the email with nodemailer
 * @param {*} options
 */
const sendEmail = async (options) => {
  const transporter = nodemailer.createTransport({
    host: process.env.EMAIL_HOST,
    port: process.env.EMAIL_PORT,
    auth: {
      user: process.env.EMAIL_USERNAME,
      pass: process.env.EMAIL_PASSWORD,
    },
  });

  const mailOptions = {
    from: 'Gideon Nimoh <hello@gideon.com>',
    to: options.email,
    subject: options.subject,
    text: options.message,
  };

  await transporter.sendMail(mailOptions);
};

module.exports = sendEmail;
