import views from '../views/nuevaInfoEstadistica.html';


export default () => {

    const divElement = document.createElement("div");
    divElement.innerHTML = views;
    divElement.classList = "text-white";

    return divElement;
}