const nodemailer = require('nodemailer');
const pug = require('pug');
const htmlToText = require('html-to-text');

/**
 * Creating a email template
 * IN PROD--
 * Use SendGrid to manage Sending Emails
 * IN DEV--
 * Create a transporter (a service to handle sending the mail) - Activate in service: gmail "less secure app" option
 * Define email options and then finally send the email with nodemailer
 * @param {*} options
 * SEND()--
 * Render the HTML based on a pug template
 * Define the email options
 * Create a Transport and send Email
 * Manage sending emails | end the actual email
 */
module.exports = class Email {
  constructor(user, url) {
    this.to = user.email;
    this.firstName = user.name.split(' ')[0];
    this.url = url;
    this.from = `Gideon Nimoh <${process.env.EMAIL_FROM}>`;
  }

  /**
   * In PRODUCTION - use SendGrid to manage sending Emails
   */
  newTransport() {
    if (process.env.NODE_ENV === 'production') {
      return 1;
    }
    return nodemailer.createTransport({
      host: process.env.EMAIL_HOST,
      port: process.env.EMAIL_PORT,
      auth: {
        user: process.env.EMAIL_USERNAME,
        pass: process.env.EMAIL_PASSWORD,
      },
    });
  }

  async send(template, subject) {
    const html = pug.renderFile(`${__dirname}/../../views/emails/${template}.pug`, {
      firstName: this.firstName,
      url: this.url,
      subject,
    });

    // Define Email options
    const mailOptions = {
      from: this.from,
      to: this.to,
      subject,
      html,
      text: htmlToText(html, {
        wordwrap: 80,
      }),
    };

    // Create Transport
    await this.newTransport().sendMail(mailOptions);
  }

  async sendWelcome() {
    await this.send('welcome', 'Welcome to the Natours Family');
  }
};
