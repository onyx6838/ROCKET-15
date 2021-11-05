import React, { useState } from 'react';

const LessText = ({ text, maxLength }) => {
    const [hidden, setHidden] = useState(true);

    if (text <= maxLength) return <span>{text}</span>

    return (
        <span>
            {hidden ? `${text.substr(0, maxLength).trim()} ...` : text}
            {hidden ? (<button onClick={() => setHidden(false)}>Read More</button>) :
                (<button onClick={() => setHidden(true)}>Read Less</button>)}
        </span>
    );
};

export default LessText;