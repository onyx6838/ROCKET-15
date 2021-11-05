import React from "react";
import styled from 'styled-components'
import useClock from "./hooks/useClock";

function Clock1() {
    //Gọi custom hook để sử dụng
    const [time, ampm] = useClock();

    const Time = styled.div`
        width: 100px;
        background-color: black;
        color: white;
        margin: 2;
        padding: 20px;
        margin-left:10px
    `;

    return (
        <Time>
            <span>{time}</span>
            <span>{ampm}</span>
        </Time>
    );
}

export default Clock1;