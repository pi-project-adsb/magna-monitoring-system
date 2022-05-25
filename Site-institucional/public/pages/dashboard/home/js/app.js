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