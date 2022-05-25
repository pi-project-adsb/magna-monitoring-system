let nextUp;
var id_totem = sessionStorage.ID_TOTEM;

window.onload = getData(1);

function getData(data_type) {

    fetch(`/dados/${data_type}/${id_totem}`, {
            cache: 'no-store'
        })
        .then(function (response) {
            if (response.ok) {
                response.json().then(function (res) {
                    res.reverse();

                    plotGraph(res, id_totem);
                    getProcess();
                    totem();
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
        datasets: [{
            yAxisID: 'y-cpu',
            label: 'CPU',
            borderColor: '#32B9CD',
            backgroundColor: '#32b9cd8f',
            fill: true,
            data: []
        }]
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
            animation: {
                duration: 500
            },
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

function totem() {

    fetch(`/users/totem/${id_totem}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (response) {
        if (response.ok) {
            response.json().then(json => {
                for (var i = 0; i < json.length; i++) {
                    document.getElementById('sistema_op').innerHTML = `${(json[i].sistema_op)}`;
                    document.getElementById('hostname').innerHTML = `${(json[i].hostname)}`;
                    document.getElementById('mac_adress').innerHTML = `${(json[i].endereco_mac)}`;
                    document.getElementById('localization').innerHTML = `${(json[i].localizacao)}`;
                    document.getElementById('modelo_cpu').innerHTML = `${(json[i].modelo_cpu)}`;
                    document.getElementById('frequencia_cpu').innerHTML = `${(json[i].frequencia_cpu)}`;
                    document.getElementById('threads_cpu').innerHTML = `${(json[i].threads_cpu)}`;
                    document.getElementById('total_disco').innerHTML = `${(json[i].total_disco)} GB`;
                }
            });
        } else {
            console.log("Erro ao localizar o totem");
        }

    }).catch(function (erro) {
        console.log(erro);
    })

    return false;
}

function getProcess() {

    fetch(`/dados/processos/${id_totem}`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (response) {
        if (response.ok) {
            response.json().then(json => {
                for (var i = 0; i < json.lenght; i++) {
                    var table = document.getElementById('table_process');
                    var tr = document.createElement('tr');
                    var td_name = document.createElement('td');
                    var td_pid = document.createElement('td');
                    var td_cpu = document.createElement('td');
                    var td_ram = document.createElement('td');

                    // CLASSES
                    tr.className = 'table-row-desc';
                    td_name.className = 'table-desc process';
                    td_pid.className = 'table-desc process';
                    td_cpu.className = 'table-desc process';
                    td_ram.className = 'table-desc process';

                    // APPENDCHIELDS
                    table.appendChild(tr);
                    tr.appendChild(td_name);
                    tr.appendChild(td_pid);
                    tr.appendChild(td_cpu);
                    tr.appendChild(td_ram);

                    // IDs
                    td_name.id = "process_name";
                    td_pid.id = "process_pid";
                    td_cpu.id = "process_cpu";
                    td_ram.id = "process_ram";

                    // CONTEÚDO
                    td_name.innerHTML = `${(json[i].nome)}`;
                    td_pid.innerHTML = `${(json[i].pid)}`;
                    td_cpu.innerHTML = `${(json[i].consumo_cpu)}`;
                    td_ram.innerHTML = `${(json[i].consumo_ram)}`;
                }
            });
        }
    })

    return false;
}