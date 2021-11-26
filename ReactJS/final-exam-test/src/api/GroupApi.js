import Api from './Api';

const url = "/groups";

const getAll = (page, size) => {
    const requestParams = {
        page,
        size
    }
    return Api.get(url, { params: requestParams });
};

// export
const api = { getAll }
export default api;