var data = {
    datasets: [{
        data: [
            5,3,2,2
        ],
        backgroundColor: [
            "#000000",
            "#3B5998",
            "#a6b1b7",
            "#1da1f2",
            "#bd081c"
        ],
        label: 'My dataset', // for legend
    }],
    labels: [
        "Manutenção",
        "Outros",
        "Avaliação",
        "Troca de equipamento"
    ],
};
var ctx5 = document.getElementById('myChart5').getContext('2d');
new Chart(ctx5, {
    data: data,
    type: 'polarArea',
    options: {
      legend: {
        display: false,
      },
      scale: {
        display: false
      }
    }
});