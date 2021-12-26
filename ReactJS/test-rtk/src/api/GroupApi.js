import Api from './Api';

const url = "/groups";

const getAll = (page, size, sortField = 'id', sortOrder = 'desc', search = '') => {
    const requestParams = {
        page,
        size,
        sort: `${sortField},${sortOrder}`,
        search
    }
    return Api.get(`${url}`, { params: requestParams });
};

// export
const api = { getAll }
export default api;