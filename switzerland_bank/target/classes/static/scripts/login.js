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


//Constantes Esqueci a senha
const linkEsqueciSenha = document.getElementById('esqueci-senha');
const modalEsqueciSenha = document.getElementById('modalEsqueciSenha');
const cancelButton = document.getElementById('EditCancelar');
const confirmButton = document.getElementById('confirmar');

//Modal Esqueci a senha
linkEsqueciSenha.onclick = function () {
  modalEsqueciSenha.showModal();
}

cancelButton.onclick = function () {
  modalEsqueciSenha.close();
}