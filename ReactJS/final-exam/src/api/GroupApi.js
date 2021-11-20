import storage from '../storage/storage';
import Api from './Api';

const url = "/groups";

const getAll = (page = 1, size = 3, sortField = "id", sortType = "desc", search = '', minTotalMember, maxTotalMember) => {
    const parameters = {
        page, size, sort: `${sortField},${sortType}`
    }

    if (search) {
        parameters.search = search
    }

    if (minTotalMember !== null && minTotalMember !== undefined) {
        parameters.minTotalMember =  minTotalMember;
    }

    if (maxTotalMember !== null && maxTotalMember !== undefined) {
        parameters.maxTotalMember =  maxTotalMember;
    }

    return Api.get(`${url}`, { params: parameters });
};

const existsByName = (name) => {
    return Api.get(`${url}/name/${name}/exists`);
};

const create = (name) => {
    const body = {
        name,
        creatorId: storage.getUserInfo()
    };

    return Api.post(url, body);
};

// export
const api = { getAll, existsByName, create }
export default api;