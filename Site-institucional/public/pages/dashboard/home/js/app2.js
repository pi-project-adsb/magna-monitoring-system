const ctx4 = document.getElementById('myChart4').getContext('2d');
const myChart4 = new Chart(ctx4, {
    type: 'bar',
    data: {
        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'June'],
        datasets: [{
            label: 'Manutenções',
            data: [10, 12, 6, 7, 9, 4],
            borderColor: 'rgb(221, 63, 63)',
            backgroundColor: 'rgb(199, 105, 105)',
            borderWidth: 1
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
