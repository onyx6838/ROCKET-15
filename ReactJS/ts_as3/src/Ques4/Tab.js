import React from "react";

class Tab extends React.Component {
    style = {
        div: {
            width: "300px"
        },
        img: {
            width: "300px"
        },
        button: {
            float: "right"
        }
    }
    render() {
        return (
            <div style={this.style.div}>
                <h2>Hoc lap trinh web don gian khong</h2>
                <img style={this.style.img} src="https://d25tv1xepz39hi.cloudfront.net/2016-01-31/files/1045.jpg" alt="" />
                <h3>Day la tieu de cua bai viet</h3>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                </p>
                <button style={this.style.button}>OK</button>
            </div>
        )
    }
}

export default Tab