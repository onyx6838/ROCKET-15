import React, { Component } from 'react'

class CategoryItem extends Component {
    state = {
        colections: null
    }

    fetchApi = (data) => {
        return data;
    }

    componentDidMount() {
        const collectionSlug = this.fetchApi(this.props.match.params.slug);

        this.setState({ collections: collectionSlug })
    }


    render() {
        return (
            <div>
                Category Item  {this.props.match.params.slug}
            </div>
        )
    }
}

export default CategoryItem