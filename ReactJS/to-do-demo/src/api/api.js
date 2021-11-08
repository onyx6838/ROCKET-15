const TODO_LIST = [
    {
        id: 1,
        text: "mot"
    },
    {
        id: 2,
        text: "hai"
    }
]

const getTodos = () => {
    return new Promise((rs, rj) => {
        setTimeout(() => {
            rs()
        }, 2000);
    })
}

export default getTodos