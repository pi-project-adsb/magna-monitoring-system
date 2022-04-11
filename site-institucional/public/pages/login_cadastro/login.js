function entrar() {
    // aguardar();

    var emailVar = email_login.value;
    var senhaVar = senha_login.value;

    console.log("FORM LOGIN: ", emailVar);
    console.log("FORM SENHA: ", senhaVar);

    if (emailVar == "" || senhaVar == "") {
        window.alert("Preencha todos os campos para prosseguir!");
        return false;
    }

    if (emailVar.indexOf("@") == -1 || emailVar.indexOf(".com") == -1) {
        window.alert("Ops, e-mail inválido! Verifique e tente novamente.");
        return false;
    }

    fetch("/usuarios/autenticar", {
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

                sessionStorage.EMAIL_USUARIO = json.email;
                sessionStorage.NOME_USUARIO = json.nome;
                sessionStorage.ID_USUARIO = json.id;

                window.location = "../../index.html";

            });

        } else {

            console.log("Houve um erro ao tentar realizar o login!");

            resposta.text().then(texto => {
                console.error(texto);
            });
        }

    }).catch(function (erro) {
        console.log(erro);
    })

    return false;
}