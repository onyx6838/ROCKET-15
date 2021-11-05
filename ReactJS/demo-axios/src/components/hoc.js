import React from "react";

function withLoading(WrappedComponent) {
    class HOC extends React.Component {
        render() {
            const { isLoading } = this.props;
            if (isLoading) return <div>....Loading</div>

            return <WrappedComponent {...this.props} />
        }
    }
    return HOC;
}

export default withLoading;