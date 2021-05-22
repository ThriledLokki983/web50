/**
 * functions for alerts
 */

/**
 * Hide alert if any
 */
export const hideAlert = () => {
  const el = document.querySelector('.alert');
  if (el) el.parentElement.removeChild(el);
};

/**
 * Creates a markup for the alert
 * @param {*} type | 'success' or 'error'
 * @param {*} message | Message to be displayed to the user
 */
export const showAlert = (type, message) => {
  hideAlert();

  const markup = `<div class="alert alert--${type}">${message}</div>`;
  document.querySelector('body').insertAdjacentHTML('afterbegin', markup);

  window.setTimeout(hideAlert, 5000);
};
