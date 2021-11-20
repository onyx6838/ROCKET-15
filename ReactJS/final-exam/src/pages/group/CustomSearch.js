import React from "react";
import { useState } from "react";
import { Button, Input, InputGroup, InputGroupAddon } from "reactstrap";

const CustomSearch = (props) => {

    const [value, setValue] = useState("");

    const handleSearchEvent = () => {
        props.onSearch(value);
    };

    const handleEnterKeyEvent = (e) => {
        if (e.key === 'Enter') {
            handleSearchEvent();
        }
    }
    return (
        <InputGroup className="mb-3">
            <Input
                placeholder="Search for..."
                onChange={(e) => setValue(e.target.value)}
                onKeyDown={handleEnterKeyEvent}
            />

            <InputGroupAddon addonType="append" color="primary" onClick={handleSearchEvent}>
                <Button>Search!</Button>
            </InputGroupAddon>
        </InputGroup>
    );
};

export default CustomSearch;