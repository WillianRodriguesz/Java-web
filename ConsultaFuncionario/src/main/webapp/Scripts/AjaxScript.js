function buscarFuncionarios() {
    var nome = document.getElementById("nome").value;

    // Verifica se o nome possui pelo menos 3 caracteres antes de fazer a consulta
    if (nome.length >= 3) {
        // Cria um objeto XMLHttpRequest
        var xhr = new XMLHttpRequest();

        // Configura a função de callback para ser chamada quando a resposta estiver pronta
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // Atualiza a div de resultado com a resposta recebida do servidor
                document.getElementById("resultado").innerHTML = xhr.responseText;
            }
        };

        // Monta a URL da requisição, incluindo o nome do funcionário
        var url = "funcionarioservlet?nome=" + encodeURIComponent(nome);

        // Abre a requisição GET assíncrona para o servlet
        xhr.open("GET", url, true);

        // Envia a requisição
        xhr.send();
    } else {
        // Se o nome tiver menos de 3 caracteres, limpa a div de resultado
        document.getElementById("resultado").innerHTML = "";
    }
}