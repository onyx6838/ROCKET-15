import { useState } from "react";

function useClock() {
    const [time, setTime] = useState("");
    const [ampm, setampm] = useState("");

    const updateTime = () => {
        let dateInfo = new Date();
        let hour = 0;

        if (dateInfo.getHours() === 0) hour = 12;
        else if (dateInfo.getHours() > 12) hour = dateInfo.getHours() - 12;
        else hour = dateInfo.getHours();

        let minutes = dateInfo.getMinutes() < 10 ? parseInt("0" + dateInfo.getMinutes()) : dateInfo.getMinutes();

        let seconds = dateInfo.getSeconds() < 10 ? "0" + dateInfo.getSeconds() : dateInfo.getSeconds();

        let ampm = dateInfo.getHours() >= 12 ? "PM" : "AM";

        setampm(ampm);
        setTime(`${hour}:${minutes}:${seconds}`);
    };

    setInterval(() => {
        updateTime()
    }, 1000);

    return [time, ampm];
}

export default useClock;