var numbers = [];

function fakeData(){
    setInterval(() => {
        for(let i = 0; i < 100; i++){
            numbers.push(Math.random() * (2 - 1.5) + 1.5);
        }
    }, 2000);
}   

const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'June'],
        datasets: [{
            label: 'My First dataset',
            data: numbers,
            fill: false,
            borderColor: '#02d8f0',
            tension: 0.1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

const ctx2 = document.getElementById('myChart2').getContext('2d');
const myChart2 = new Chart(ctx2, {
    type: 'line',
    data: {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'June'],
        datasets: [{
            label: 'My First dataset',
            data: numbers,
            fill: false,
            borderColor: '#02d8f0',
            tension: 0.1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

const ctx3 = document.getElementById('myChart3').getContext('2d');
const myChart3 = new Chart(ctx3, {
    type: 'line',
    data: {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'June'],
        datasets: [{
            label: 'My First dataset',
            data: numbers,
            fill: false,
            borderColor: '#02d8f0',
            tension: 0.1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

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