const senha = document.querySelector(".password");
const olhoMostrar = document.querySelector(".fa-eye");
const olhoOcultar = document.querySelector(".fa-eye-slash");

//função mostrar senha
olhoMostrar.onclick = () => {
  if (senha.type === "password") {
    senha.type = "text";
  } else {
    senha.type = "password";
  }
};
