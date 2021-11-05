import React, { useContext, useEffect, useState } from 'react';
import ExampleContext from '../context';

const Counting = ({ timer }) => {
    const [time, setTime] = useState(timer);

    const context = useContext(ExampleContext);

    console.log(context.test);

    useEffect(() => {
        document.title = "Count " + time;
        return () => {
            console.log("unmount");
        }
    }, [time])  // khi time thay doi thi` render lai => useEffect (neu [] thi chi useEffect 1 lan`)

    return (
        <div>
            <p>Clicked {time} times</p>
            <button onClick={() => setTime(time + 1)}>Plus</button>
            <button onClick={() => setTime(time - 1)}>Minus</button>
            <button onClick={() => setTime(timer)}>Reset</button>
        </div>
    );
};

export default Counting;