function cadastrar() {

    var emailVar = email_cadastro.value;
    var cnpjVar = cnpj_cadastro.value;
    var empresaVar = empresa_cadastro.value;
    var senhaVar = senha_cadastro.value;
    var confirmacaoSenhaVar = confirmacao_senha_cadastro.value;

    if (cnpjVar == ""|| empresaVar == "" || emailVar == "" || senhaVar == "" || confirmacaoSenhaVar == "") {

        window.alert("Preencha todos os campos para prosseguir!");
        if (cnpjVar == "") {
            console.log('CNPJ está em branco')
        }
        if (empresaVar == "") {
            console.log('empresa está em branco')
        }
        if (emailVar == "") {
            console.log('email está em branco')
        }
        if (senhaVar == "") {
            console.log('senha está em branco')
        }
        if (confirmacaoSenhaVar == "") {
            console.log('confirmacaoSenha está em branco')
        }
        return false;
    }

    if (emailVar.indexOf("@") == -1 || emailVar.indexOf(".com") == -1) {
        window.alert("Ops, e-mail inválido! Verifique e tente novamente.");
        return false;
    }

    if (senhaVar != confirmacaoSenhaVar) {
        window.alert("As senhas inseridas devem ser iguais para prosseguir!");
        return false;
    }

    fetch("/users/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            emailServer: emailVar,
            empresaServer: empresaVar,
            cnpjServer: cnpjVar,
            senhaServer: senhaVar,
        })
    }).then(function (resposta) {

        console.log("resposta: ", resposta);

        if (resposta.ok) {
            window.alert("Cadastro realizado com sucesso!");
            console.log(resposta.json);
        } else {
            throw ("Houve um erro ao tentar realizar o cadastro!");
        }
    }).catch(function (resposta) {
        console.log(`#ERRO: ${resposta}`);
    });

    return false;
}