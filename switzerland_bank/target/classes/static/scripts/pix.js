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

let btn_aleatorio = document.getElementById("chave_Aleatorio");
let btn_cpf = document.getElementById("chave_Cpf");
let btn_telefone = document.getElementById("chave_Telefone");

let resultado = document.getElementById("chave_Escolhida");
btn_aleatorio.addEventListener("click",function(){
    resultado.innerHTML = btn_aleatorio.innerHTML
})

btn_cpf.addEventListener("click",function(){
    resultado.innerHTML = btn_cpf.innerHTML
})

btn_telefone.addEventListener("click",function(){
    resultado.innerHTML = btn_telefone.innerHTML
})