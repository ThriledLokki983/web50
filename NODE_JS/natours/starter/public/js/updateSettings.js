import axios from 'axios';
import { showAlert } from './alert';
/**
 * Entry point to update user data including the password
 */

/**
 *
 * @param {*} data
 * @param {*} type | Either 'password' or 'data'
 */
export const updateSettings = async (data, type) => {
  try {
    const url =
      type === 'password'
        ? 'http://127.0.0.1:4000/api/v1/users/updateMypassword'
        : 'http://127.0.0.1:4000/api/v1/users/updateMe';

    const res = await axios({
      method: 'PATCH',
      url,
      data,
    });

    if (res.data.status === 'success') {
      showAlert('success', `${type.toUpperCase()} Updated Successfully!`);
    }
  } catch (e) {
    showAlert('error', e.response.data.message);
  }
};
