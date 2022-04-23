function entrar() {
    // aguardar();

    var emailVar = email_login.value;
    var senhaVar = senha_login.value;

    console.log("FORM LOGIN: ", emailVar);
    console.log("FORM SENHA: ", senhaVar);

    // TODO: VERIFICAR AS VALIDAÇÕES QUE ELES ESTÃO APRENDENDO EM ALGORITMOS 
    if (emailVar == "" || senhaVar == "") {
        window.alert("Preencha todos os campos para prosseguir!");
        return false;
    }

    if (emailVar.indexOf("@") == -1 || emailVar.indexOf(".com") == -1) {
        window.alert("Ops, e-mail inválido! Verifique e tente novamente.");
        return false;
    }

    fetch("/users/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            emailServer: emailVar,
            senhaServer: senhaVar
        })
    }).then(function (resposta) {
        console.log("ESTOU NO THEN DO entrar()!")

        if (resposta.ok) {
            console.log(resposta);

            resposta.json().then(json => {
                console.log(json);
                console.log(JSON.stringify(json));

                // sessionStorage.EMAIL_USUARIO = json.email;
                // sessionStorage.NOME_USUARIO = json.nome;
                // sessionStorage.ID_USUARIO = json.id;
                // sessionStorage.CPF_USUARIO = json.cpf_cnpj;

                setTimeout(function () {
                    window.location = "public/index.html";
                }, 1000); // apenas para exibir o loading

            });

        } else {

            console.log("Houve um erro ao tentar realizar o login!");

        }

    }).catch(function (erro) {
        console.log(erro);
    })

    return false;
}