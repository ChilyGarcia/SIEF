import "bootstrap/dist/css/bootstrap.min.css";
import "./main.scss";

import { router } from "./routes/index.routes.js";

router(window.location.hash);
window.addEventListener("hashchange", () => {
  router(window.location.hash);
});

const validacionToken = localStorage.getItem("token");

const divElement = document.createElement("div");

console.log(validacionToken);

persona = {
  comprobacion: true
}



const btnCerrarSesion = document.getElementById("cerrarSesion");

btnCerrarSesion.addEventListener('click', () => {
  localStorage.removeItem('token');
})



/*
function mostrarElemento() {
  var elemento = document.getElementById("elemento");

  elemento.style.display = "block";
}

*/
