/**
 * Get the form filled in by the user using HTTP request
 */

import axios from 'axios';
import { showAlert } from './alert';

export const login = async (email, password) => {
  try {
    const res = await axios({
      method: 'POST',
      url: 'http://127.0.0.1:4000/api/v1/users/login',
      data: {
        email,
        password,
      },
    });

    if (res.data.status === 'success') {
      showAlert('success', 'Logged in successfully');

      window.setTimeout(() => {
        location.assign('/');
      }, 1500);
    }
  } catch (e) {
    showAlert('error', e.response.data.message);
  }
};

export const logout = async () => {
  try {
    const res = await axios({
      method: 'GET',
      url: 'http://127.0.0.1:4000/api/v1/users/logout',
    });

    if (res.data.status === 'success')
      location.reload({
        forcedReload: true,
      });
  } catch (err) {
    showAlert('error', 'Error logging out, please try again');
  }
};
