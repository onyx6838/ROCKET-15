import { connect } from "react-redux";

const Counter = (props) => {
    const { value } = props;
    return <div className="value">{value}</div>
}

const mapGlobalStateToProps = (state) => {
    return {
        value: state.value
    }
}

export default connect(mapGlobalStateToProps)(Counter);
// () dau tien lien quan dung` state set vao prop , () thu hai la component can set