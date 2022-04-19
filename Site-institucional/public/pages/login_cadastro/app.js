function checkPass(x) {
    var eyeSlash = document.getElementById('checkPass');
    var eye = document.getElementById('checkPass2')
    var inpt = document.getElementById('senha_login');

    if(x == 1){
        eyeSlash.style.display = 'none';
        eye.style.display = 'block';
        inpt.type = 'text';
    }else{
        eye.style.display = 'none';
        eyeSlash.style.display = 'block';
        inpt.type = 'password';
    }
}