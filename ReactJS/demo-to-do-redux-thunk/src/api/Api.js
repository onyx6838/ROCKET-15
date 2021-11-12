import axios from 'axios';

const axiosClient = axios.create({
    baseURL: `https://5f47b29395646700168d9bd1.mockapi.io/api/v1`,
    timeout: 5000, // default is `0` (no timeout)
    responseType: 'json'
});

axiosClient.interceptors.request.use(async (config) => {
    // Handle token here ...
    return config;
});

axiosClient.interceptors.response.use((response) => {
    if (response && response.data) {
        // only get data
        return response.data;
    }

    return response;
}, (error) => {
    // Handle errors
    throw error;
});

export default axiosClient;

