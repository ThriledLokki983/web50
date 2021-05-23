const axios = 'axios';

/**
 * The Stripe() is exposed by the script included in the tour template
 */
const stripe = Stripe(
  'pk_test_51IuFjlIJ45JCpPmPxpdrDaoo6dqMB3COUMDYYPmW47EaxognmQUPu5N9pzzUUrn26CnB2c76X1fbVXfgEWOa3Jp200MVoKmnZ8'
);

/**
 * Get the checkout session from endpoint from our API
 * Use stripe to auto create the checkout form and charge the card
 * @param {*} tourId
 */
export const bookTour = async (tourId) => {
  const session = await axios(
    `http://127.0.0.1:4000/api/v1/bookings/checkout-session/${tourId}`
  );
  console.log(session);
};
