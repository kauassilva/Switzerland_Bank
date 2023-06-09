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
const button_fecharTransferir = document.getElementById('EditCancelar')


transferir.onclick = function (){
    modal_transferir.showModal()
}
button_fecharTransferir.onclick = function (){
    modal_transferir.close()
}


// const chaves = document.getElementById('btn-chave')
// const modal_chaves = document.getElementById('modal-chaves')
// const button_fecharChaves = document.getElementById('fechar-chaves')


// chaves.onclick = function(){
//     modal_chaves.showModal()
// }
// button_fecharChaves.onclick = function (){
//     modal_chaves.close()
// }


// Função para validar os valores decimais no campo de valor monetário
function validarValor(input) {
    // Remove todos os caracteres, exceto números e o ponto decimal
    input.value = input.value.replace(/[^0-9.]/g, '');

    // Verifica se há mais de um ponto decimal e remove o excesso
    var pontos = input.value.split('.');
    if (pontos.length > 2) {
        input.value = pontos[0] + '.' + pontos.slice(1).join('');
    }

    // Garante que o valor seja um número válido
    if (isNaN(input.value)) {
        input.value = '';
    }
}