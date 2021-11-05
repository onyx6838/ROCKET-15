export default function reducer(state = { value: 0 }, action) {
    switch (action.type) {
        case 'counter/incremented':
            return {
                ...state,
                value: state.value + 1
            };

        case 'counter/decremented':
            return {
                ...state,
                value: state.value - 1
            };
        default:
            return state
    }
}