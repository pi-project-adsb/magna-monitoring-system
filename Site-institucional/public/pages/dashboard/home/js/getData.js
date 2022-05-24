let nextUp;
var id_totem = sessionStorage.ID_TOTEM;

window.onload = getData(1);

function getData(data_type) {

    fetch(`/dados/${data_type}/${id_totem}`, { cache: 'no-store' })
        .then(function (response) {
            if (response.ok) {
                response.json().then(function (res) {
                    res.reverse();

                    plotGraph(res, id_totem);
                });
            } else {
                console.log("Nenhum dado encontrado!");
            }
        }).catch(function (err) {
            console.log(`Erro na obtenção dos dados p/ gráfico: ${err.message}`);
        })
}

function plotGraph(res, id_totem) {

    var dados = {
        labels: [],
        datasets: [
            {
                yAxisID: 'y-cpu',
                label: 'CPU',
                borderColor: '#32B9CD',
                backgroundColor: '#32b9cd8f',
                fill: true,
                data: []
            }
        ]
    };

    for (var i = 0; i < res.length; i++) {
        var register = res[i];
        dados.labels.push(register.dh_registro);
        dados.datasets[0].data.push(register.uso_cpu);
    }

    const ctx = myChart.getContext('2d');
    window.grafico_linha = new Chart(ctx, {
        type: 'line',
        data: dados,
        options: {
            responsive: true,
            animation: { duration: 500 },
            hoverMode: 'index',
            stacked: false,
            title: {
                display: true,
                // text: 'Dados de CPU'
            },
            scales: {
                yAxes: [{
                    type: 'linear',
                    display: true,
                    position: 'left',
                    id: 'y-cpu',
                    ticks: {
                        beginAtZero: true,
                        max: 100,
                        min: 0
                    }
                }]
            }
        }
    });
}
