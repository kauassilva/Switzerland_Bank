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