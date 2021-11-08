import { connect, useSelector } from "react-redux";

const Counter = (props) => {
    const value = useSelector(state => state.value);
    //const { value } = props;
    return <div className="value">{value}</div>
}

// const mapGlobalStateToProps = (state) => {
//     return {
//         value: state.value
//     }
// }

//export default connect(mapGlobalStateToProps)(Counter);
// () dau tien lien quan dung` state set vao prop , () thu hai la component can set

export default Counter;