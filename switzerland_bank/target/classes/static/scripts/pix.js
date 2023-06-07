// Modal de Chave Pix
// var btnCriar = document.getElementById('btn_criar');
// var inputChave = document.querySelector('#conteudo-criar-chave');

// btnCriar.addEventListener('click', function() {
// inputChave.style.display = 'block';
// InputEditar.style.display= 'none';
// InputDeletar.style.display= 'none';
// });

// var btnEditar = document.getElementById('btn_editar');
// var InputEditar = document.querySelector('#conteudo-editar-chave');

// btnEditar.addEventListener('click', function() {
// InputEditar.style.display = 'block';
// inputChave.style.display = 'none';
// InputDeletar.style.display= 'none';
// })

// var btnDeletar = document.getElementById('btn_deletar');
// var InputDeletar = document.querySelector('#conteudo-deletar-chave');

// btnDeletar.addEventListener('click', function() {
// InputDeletar.style.display = 'block';
// InputEditar.style.display = 'none';
// inputChave.style.display = 'none';
// })

// Modal de Transferir
const transferir = document.getElementById('coin-transferir')
const modal_transferir = document.getElementById('modal-transferir')
const button_fecharTransferir = document.getElementById('fechar-transferir')


transferir.onclick = function (){
    modal_transferir.showModal()
}
button_fecharTransferir.onclick = function (){
    modal_transferir.close()
}

const receber = document.getElementById('coin-receber')
const modal_receber = document.getElementById('modal-receber')
const button_fecharReceber = document.getElementById('fechar-receber')


receber.onclick = function(){
    modal_receber.showModal()
}
button_fecharReceber.onclick = function(){
    modal_receber.close()
}

const cobrar = document.getElementById('coin-cobrar')
const modal_cobrar = document.getElementById('modal-cobrar')
const button_fecharCobrar = document.getElementById('fechar-cobrar')


cobrar.onclick = function(){
    modal_cobrar.showModal()
}
button_fecharCobrar.onclick = function (){
    modal_cobrar.close()
}

const chaves = document.getElementById('btn-chave')
const modal_chaves = document.getElementById('modal-chaves')
const button_fecharChaves = document.getElementById('fechar-chaves')


chaves.onclick = function(){
    modal_chaves.showModal()
}
button_fecharChaves.onclick = function (){
    modal_chaves.close()
}
