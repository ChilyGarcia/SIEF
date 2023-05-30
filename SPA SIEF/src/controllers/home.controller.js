import views from "../views/home.html";

export default () => {
  const divElement = document.createElement("div");
  divElement.innerHTML = views;
  divElement.classList = "text-white";

  /*    Esto es para obtener el click de un boton y darle evento
  const btnClick = divElement.querySelector("#btnClick");
  btnClick.addEventListener("click", () => {
    alert("a");
  });

  */

  // INICIO DE SESIÓN
  const data = {
    usernameOrEmail: "",
    password: "",
  };

  const usernameOrEmail = divElement.querySelector("#correo");
  const password = divElement.querySelector("#password");
  const btnClick = divElement.querySelector("#btnIngresar");

  btnClick.addEventListener("click", () => {
    data.usernameOrEmail = usernameOrEmail.value;
    data.password = password.value;

    console.log(data.usernameOrEmail);
    console.log(data.password);

    const url = "http://localhost:8080/api/auth/iniciarSesion";

    fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Respuesta:", data);
        localStorage.setItem("token", data.tokenDeAcceso);
        console.log(
          "Se ha almacenado en el localStorage el token:",
          data.tokenDeAcceso
        );

        //Esto me va a servir para poder dar inicio de sesion dentro de la app
        // window.location.href = "#/post";
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  });

  // REGISTRARSE

  const dataRegister = {
    nombre: "",
    username: "",
    email: "",
    password: "",
  };

  const nombreRegistro = divElement.querySelector("#nombreRegistro");
  const usernameRegistro = divElement.querySelector("#usernameRegistro");
  const emailRegistro = divElement.querySelector("#emailRegistro");
  const passwordRegistro = divElement.querySelector("#passwordRegistro");
  const btnRegistro = divElement.querySelector("#btnRegistro");

  btnRegistro.addEventListener("click", () => {
    dataRegister.nombre = nombreRegistro.value;
    dataRegister.username = usernameRegistro.value;
    dataRegister.emailRegistro = emailRegistro.value;
    dataRegister.passwordRegistro = passwordRegistro.value;

    console.log(dataRegister.nombre);
    console.log(dataRegister.username);
    console.log(dataRegister.emailRegistro);
    console.log(dataRegister.passwordRegistro);

    const url = "http://localhost:8080/api/registro";

    fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(dataRegister)
    })
      .then(response => response.json())
      .then(data => {
        console.log('Persona registrada:', data);
        // Realizar acciones adicionales después de registrar la persona
      })
      .catch(error => {
        console.error('Error al registrar la persona:', error);
        // Manejar el error de alguna manera
      });
  });

  return divElement;
};
