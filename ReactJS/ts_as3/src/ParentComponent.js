import React from 'react';
import ChildComponent from './ChildComponent';

class ParentComponent extends React.Component{
    render(){
        const dad = 'a';
        return (
            <div>
                <ChildComponent dad={dad} mom="Momasdasd" >
                    <div>
                        ChildComponent 'child'
                    </div>
                </ChildComponent>
            </div>
        )
    }
}

export default ParentComponent