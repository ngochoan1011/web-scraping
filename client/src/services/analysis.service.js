import axios from 'axios';
import { END_POINT } from '../settings/settings';

/**
 * Call API_ENDPOINT to get result
 *
 * @param  {string} url
 */
export const getAnalysisData = async (url) => {
  const { data } = await axios.get(END_POINT + '/urls/analysis?url=' + url)
  return data
};
