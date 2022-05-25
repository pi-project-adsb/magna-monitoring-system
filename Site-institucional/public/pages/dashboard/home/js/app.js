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


function page(x){

    var cpu = document.getElementById('cpu_container');
    var ram = document.getElementById('ram_container');
    var disk = document.getElementById('disk_container');

    if(x == 1){
        cpu.style.display = 'block';
        ram.style.display = 'none';
        disk.style.display = 'none';
    }
    else if(x == 2){
        cpu.style.display = 'none';
        ram.style.display = 'block';
        disk.style.display = 'none';
    }
    else if(x == 3){
        cpu.style.display = 'none';
        ram.style.display = 'none';
        disk.style.display = 'block';
    }
}