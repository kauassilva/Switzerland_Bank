const cartaoVerifier = document.getElementById('cartaoNumero')

function cartaoVerificar() {
    if ("${client.cartao}" != null) {
        cartaoVerificar.style.display = 'none';        
    }else{
    cartaoVerificar.display = 'block';
    }
}