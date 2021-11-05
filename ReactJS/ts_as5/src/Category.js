import React, { Component } from 'react'
import { Link, Route } from 'react-router-dom'
import CategoryItem from './CategoryItem'

class Category extends Component {
    render() {
        return (
            <div>
                <h2>Category Page</h2>
                <ul>
                    <li><Link to="/category/cat-1">Category 1</Link></li>
                    <li><Link to="/category/cat-2">Category 2</Link></li>
                </ul>

                <Route path="/category/:slug" component={CategoryItem} />
            </div>
        )
    }
}

export default Category