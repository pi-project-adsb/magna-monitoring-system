// ANIMAÇÃO DE TROCA DE FORMULÁRIO
function teste(a) {
    var login = document.getElementById('login-box');
    var signUp = document.getElementById('signUp-box');
    if (a == 1) {
        if(login.classList == ''){
            login.classList.add('form-hide');
        }else{
            login.classList.replace(`${login.classList}`,'form-hide');
        }
        setTimeout(() => {
            login.style.display = 'none';
            if(signUp.classList == ''){
                signUp.classList.add('form-ap');
            }else{
                signUp.classList.replace(`${signUp.classList}`, 'form-ap');
            }
            signUp.style.display = 'block';
        }, 500);
    }else{
        signUp.classList.replace('form-ap', 'form-hide');
        setTimeout(() => {
            signUp.style.display = 'none';
            login.classList.replace('form-hide', 'form-ap');
            login.style.display = 'block';
        }, 500);
    }
}