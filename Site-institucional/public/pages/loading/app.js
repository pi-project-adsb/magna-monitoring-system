function loading() {
    var welcome_loading = document.getElementById('welcome_user_spn_id');
    setTimeout(() => {
        welcome_loading.style.animation = 'fadeIn 2s';
        setTimeout(() => {
            welcome_loading.style.display = 'block';
            setTimeout(() => {
                window.location= "public/pages/dashboard/home/home.html";
            }, 3000);
        }, 1200);
    }, 5000);
}
