import "bootstrap/dist/css/bootstrap.min.css";
import "./main.scss";

import {router} from './routes/index.routes.js';

router(window.location.hash);
window.addEventListener('hashchange', () =>{
    router(window.location.hash);
})

console.log("Hola mundo con el sief");
