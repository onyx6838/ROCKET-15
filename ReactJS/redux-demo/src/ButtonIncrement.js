import { connect, useDispatch } from "react-redux";

const ButtonIncrement = (props) => {
    console.log(props);
    const dispatch = useDispatch();

    //return <button onClick={props.increment}>Cong</button>;
    return <button onClick={() => dispatch({ type: "couter/incremented" })}>Cong</button>;
};

// const mapDispatchToProps = (dispatch) => {
//   return {
//     increment: () => dispatch({ type: "couter/incremented" })
//   };
// };

//export default connect(null, mapDispatchToProps)(ButtonIncrement);
export default ButtonIncrement