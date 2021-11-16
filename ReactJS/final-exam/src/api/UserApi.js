import Api from './Api';

const url = "/accounts";

const existsByEmail = (email) => {
    return Api.get(`${url}/email/${email}`);
};

const existsByUsername = (username) => {
    return Api.get(`${url}/userName/${username}`);
};

const create = (username, email, password, firstname, lastname) => {
    const body = {
        userName: username,
        email: email,
        password: password,
        firstName: firstname,
        lastName: lastname,
        role: "User"
    }
    return Api.post(url, body);
};

const resendEmailToActiveAccount = (email) => {
    const requestParams = {
        email: email
    }

    return Api.get(`${url}/userRegistrationConfirmRequest`, { params: requestParams });
};

// export
const api = { existsByEmail, existsByUsername, create, resendEmailToActiveAccount }
export default api;