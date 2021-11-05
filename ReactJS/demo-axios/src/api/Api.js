import axios from "axios"

const api = axios.create({
    baseURL: "https://617fe4a3055276001774fd93.mockapi.io/api/"
})

export default api