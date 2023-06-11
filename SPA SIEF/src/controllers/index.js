import Home from './home.controller.js';
import Post from './post.controller.js';
import Inicio from './inicio.controller.js'
import notFound from './404.controller.js';
import NuevaInfoEstadistica from './nuevaInfoEstadistica.js';


const pages = {
    home : Home,
    post : Post,
    isNotFound : notFound,
    inicio: Inicio,
    infoEstadistica: NuevaInfoEstadistica

}

export {pages}