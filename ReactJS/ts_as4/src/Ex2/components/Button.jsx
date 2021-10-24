import React from 'react'

export default function Button(props) {
    return (
        <button
            style={props.style}
            className={
                props.type === "primary" ? "btn btn-primary" : "btn btn-secondary"
            }
            onClick={props.action}
        >
            {props.title}
        </button>
    );
}
