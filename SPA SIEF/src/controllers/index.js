import Home from './home.controller.js';
import Post from './post.controller.js';
import notFound from './404.controller.js';


const pages = {
    home : Home,
    post : Post,
    isNotFound : notFound
}

export {pages}