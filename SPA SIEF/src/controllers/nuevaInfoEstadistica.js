import views from '../views/nuevaInfoEstadistica.html';


export default () => {

    const divElement = document.createElement("div");
    divElement.innerHTML = views;
    divElement.classList = "text-white";

    const data = {
        codigoPrograma: "",
        nombreDelPrograma: "",
        periodo : "",
        inscritos : "",
        admitidos : "",
        matriculados : "",
        graduados : ""
    };

    

    const codigoPrograma = divElement.querySelector("#codigo");
    const nombreDelPrograma = divElement.querySelector("#nombrePrograma");
    const periodo = divElement.querySelector("#periodo");
    const inscritos = divElement.querySelector("#inscritos");
    const admitidos = divElement.querySelector("#admitidos");
    const matriculados = divElement.querySelector("#matriculados");
    const graduados = divElement.querySelector("#graduados");

    const btn = divElement.querySelector("#btnRegistroPrograma")

    btn.addEventListener("click", () =>{

        const token = localStorage.getItem("token");
        console.log(token);

        const url = "http://localhost:8080/api/auth/guardarPrograma";

        data.codigoPrograma = codigoPrograma.value;
        data.nombreDelPrograma = nombreDelPrograma.value;
        data.periodo = periodo.value;
        data.inscritos = inscritos.value;
        data.admitidos = admitidos.value;
        data.matriculados = matriculados.value;
        data.graduados = graduados.value;

        console.log("Codigo programa", data.codigoPrograma);
        console.log("Nombre programa", data.nombreDelPrograma);
        console.log("Periodo", data.periodo);
        console.log("Inscritos", data.inscritos);
        console.log("Admitidos", data.admitidos);
        console.log("Matriculados", data.matriculados);
        console.log("Graduados", data.graduados);

        fetch(url, {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
              "Access-Control-Allow-Origin": "*",
              "Access-Control-Allow-Methods": "*",
              "Authorization": "Bearer " + token
            },
            body: JSON.stringify(data),
          })
            .then((response) => response.json())
            .then((data) => {
              console.log("Respuesta:", data);
      
              swal({
                title: "Registro con éxito",
                text: "Se haa guardado correctamente la caracterizacion de ese programa",
                icon: "info",
                textColor: "#ff0000",
              });
      
              //Esto me va a servir para poder dar inicio de sesion dentro de la app
              // window.location.href = "#/post";
            })
            .catch((error) => {
              console.error("Error:", error);
            });
        

        

          
    })
    


    return divElement;
}