//constantes Deletar
const buttonDeletar = document.getElementById('deletar');
const modalDeletar = document.getElementById('modalDeletar');
const cancelButton = document.getElementById('cancelar');
const confirmButton = document.getElementById('confirmar');

//Modal Deletar
buttonDeletar.onclick = function () {
  modalDeletar.showModal();
}

cancelButton.onclick = function () {
  modalDeletar.close();
}

//constantes Editar
const buttonEditar = document.getElementById ('editar');
const modalEditar = document.getElementById('modalEditar');
const cancelEditButton = document.getElementById('EditCancelar');
const saveButton = document.getElementById('salvar');

//Modal Editar

buttonEditar.onclick = function () {
  modalEditar.showModal();
}

cancelEditButton.onclick = function () {
  modalEditar.close();
}


//função ver senha: constantes 
const senha = document.querySelector(".password");
const olhoMostrar = document.querySelector(".fa-eye");
const olhoOcultar = document.querySelector(".fa-eye-slash");

//condição função ver senha 
olhoMostrar.onclick = () => {
  if (senha.type === "password") {
    senha.type = "text";
  } else {
    senha.type = "password";
  }
};

