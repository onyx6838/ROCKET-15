import storage from '../storage/storage';
import Api from './Api';

const url = "/groups";

const getAll = (page = 1, size = 3, sortField, sortType, search = '', minTotalMember, maxTotalMember) => {

    // default parameters
    if (sortField === null || sortField === undefined || sortType === null || sortType === undefined) {
        sortField = "id";
        sortType = "desc";
    }

    const parameters = {
        page,
        size,
        sort: `${sortField},${sortType}`,
        search,
        minTotalMember,
        maxTotalMember
    }

    if (minTotalMember) {
        parameters.minTotalMember = minTotalMember;
    }

    if (maxTotalMember) {
        parameters.maxTotalMember = maxTotalMember;
    }

    return Api.get(`${url}`, { params: parameters });
};

const existsByName = (name) => {
    return Api.get(`${url}/name/${name}/exists`);
};

const create = (name) => {
    const body = {
        name,
        creatorId: Number.parseInt(storage.getUserInfo().id)
    };

    return Api.post(url, body);
};

const getByID = (id) => {
    return Api.get(`${url}/${id}`);
};

const update = (id, name, totalMember, createDate) => {
    const body = {
        name,
        member: totalMember,
        createDate
    }
    return Api.put(`${url}/${id}`, body);
};

// export
const api = { getAll, existsByName, create, getByID, update }
export default api;