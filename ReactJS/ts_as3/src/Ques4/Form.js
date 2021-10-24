import React from "react";

class Form extends React.Component {
    render() {
        return (
            <div>
                <h2>Form</h2>
                <input type="text" name="" id="" placeholder="Email or Username" />
                <br />
                <input type="text" name="" id="" placeholder="Password" />
                <br />
                <input type="submit" value="Login" />
            </div>
        )
    }
}
export default Form;