function page(x){

    var ram = document.getElementById('ram');
    var cpu = document.getElementById('cpu');
    var disk = document.getElementById('disk');
    var process = document.getElementById('process');

    if(x == 1){
        ram.style.display = 'block';
        cpu.style.display = 'none';
        disk.style.display = 'none';
        process.style.display = 'none';
    }
    else if(x == 2){
        ram.style.display = 'none';
        cpu.style.display = 'block';
        disk.style.display = 'none';
        process.style.display = 'none';
    }else if(x == 3){
        ram.style.display = 'none';
        cpu.style.display = 'none';
        disk.style.display = 'block';
        process.style.display = 'none';
    }else if(x == 4){
        ram.style.display = 'none';
        cpu.style.display = 'none';
        disk.style.display = 'none';
        process.style.display = 'block';
    }
}