document.getElementById('name_user').innerHTML = sessionStorage.NOME_EMPRESA;

let menuToggle = document.querySelector('.toggle');
let navigation = document.querySelector('.navigation');
menuToggle.onclick = function(){
menuToggle.classList.toggle('active')
navigation.classList.toggle('active');
}
            
// Adicionar classe ativa
let list = document.querySelectorAll('.list');
for(let i = 0; i<list.length; i++){
list[i].onclick = function(){
let j = 0;
while(j < list.length){
list[j++].className = 'list';
        }
list[i].className = 'list active'
    }
}

function modal(x){
    var modal = document.getElementById(`myModal_${x}`);
    var span = document.getElementById(`close_${x}`);
    modal.style.display = 'block';

    span.onclick = () => {
      modal.style.display = 'none';
    }

    window.onclick = event => {
      if (event.target == modal) {
        modal.style.display = 'none';
      }
    }
}