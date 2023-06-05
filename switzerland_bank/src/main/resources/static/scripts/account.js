const buttonDeletar = document.getElementById('deletar');
const modalDeletar = document.getElementById('modalDeletar');
const cancelButton = document.getElementById('cancelar');
const confirmButton = document.getElementById('confirmar');

buttonDeletar.onclick = function () {
  modalDeletar.showModal();
}

cancelButton.onclick = function () {
  modalDeletar.close();
}

// function exibirAviso() {
//   var aviso = document.getElementById("modalDeletar");
//   aviso.classList.remove("escondido");
// }

// function fecharAviso() {
//   var aviso = document.getElementById("modalDeletar");
//   aviso.classList.add("escondido");
// }