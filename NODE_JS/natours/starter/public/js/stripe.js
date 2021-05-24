import axios from 'axios';
import { showAlert } from './alert';

const stripe = Stripe(
  'pk_test_51IuFjlIJ45JCpPmPxpdrDaoo6dqMB3COUMDYYPmW47EaxognmQUPu5N9pzzUUrn26CnB2c76X1fbVXfgEWOa3Jp200MVoKmnZ8'
);

export const bookTour = async (tourId) => {
  try {
    const session = await axios(
      `http://127.0.0.1:4000/api/v1/bookings/checkout-session/${tourId}`
    );

    console.log(session);

    await stripe.redirectToCheckout({
      sessionId: session.data.session.id,
    });
  } catch (e) {
    showAlert('error', e);
  }
};
