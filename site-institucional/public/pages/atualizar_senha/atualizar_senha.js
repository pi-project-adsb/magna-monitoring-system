function atualizarSenha() {

    var emailVar = sessionStorage.EMAIL_USUARIO;
    var senhaVar = senha_trocar.value;
    var confirmacaoSenhaVar = confirmar_senha_trocar.value;

    if (senhaVar == "" || confirmacaoSenhaVar == "") {

        window.alert("Preencha todos os campos para prosseguir!");
        if (senhaVar == "") {
            console.log('senha está em branco')
        }
        if (confirmacaoSenhaVar == "") {
            console.log('confirmacaoSenha está em branco')
        }
        return false;
    }

    if (senhaVar != confirmacaoSenhaVar) {
        window.alert("As senhas inseridas devem ser iguais para prosseguir!");
        return false;
    }

    fetch("/usuarios/atualizarSenha", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            emailServer: emailVar,
            senhaServer: senhaVar
        })
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Senha alterada com sucesso!");
            window.location = "#abrirLogin";
            limparFormulario();
        } else {
            throw ("Houve um erro ao tentar alterar a senha!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
    });

    return false;
}