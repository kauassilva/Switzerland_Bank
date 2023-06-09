/**
 * Código referente a exibição do valor monetário
 */
// Obtém todos os elementos com a classe "data-type"
const dataTypeElements = document.querySelectorAll('.data-type');

// Percorre cada elemento da classe "data-type"
dataTypeElements.forEach((element) => {
    const dataTypeValue = element.textContent;
    const dataAmountElement = element.nextElementSibling.nextElementSibling;

    const originalText = dataAmountElement.textContent.trim();
    const originalNumber = parseFloat(originalText);
    const formattedText = originalNumber.toLocaleString('pt-BR', {
        style: 'currency',
        currency: 'BRL'
      });

    // Verifica se o valor do elemento da classe "data-type" e adiciona a nova classe ao elemento da classe "data-amount"
    if (dataTypeValue === 'Pix recebido') {
        dataAmountElement.classList.add('deposit');
        dataAmountElement.textContent = '+' + formattedText;
    } else if (dataTypeValue === 'Pix enviado') {
        dataAmountElement.classList.add('transference');
        dataAmountElement.textContent = '-' + formattedText;
    }
});

/**
 * Código referente a exibição da data e hora
 */
const dateTimeElements = document.querySelectorAll('.data-date-time');

dateTimeElements.forEach((element) => {
    const originalDateTime = element.textContent.trim();
    const date = new Date(originalDateTime);

    const options = {
        day: '2-digit',
        month: '2-digit',
        year: 'numeric',
        hour: 'numeric',
        minute: 'numeric',
        hour12: false
    };

    const formattedDateTime = new Intl.DateTimeFormat('pt-BR',options).format(date);

    element.textContent = formattedDateTime;
});