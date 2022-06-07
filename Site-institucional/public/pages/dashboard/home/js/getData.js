let nextUp;
var id_totem = sessionStorage.ID_TOTEM;

window.onload = getData(1), getProcess(), getNextAgend(), totem(), getAgendCheck(), lastAgend();

function getData(data_type) {


    if (nextUp != undefined) {
        clearTimeout(nextUp);
    }

    fetch(`/dados/${data_type}/${id_totem}`, {
            cache: 'no-store'
        })
        .then(function (response) {
            if (response.ok) {
                response.json().then(function (res) {
                    res.reverse();

                    plotGraph(res, data_type);
                });

                var btnInfo = document.getElementById('modal_in_component');
                var cpu_btn = document.getElementById('cpu_btn');
                var ram_btn = document.getElementById('ram_btn');
                var disk_btn = document.getElementById('disk_btn');

                btnInfo.addEventListener('click', function () {
                    if (data_type == 1) {
                        modal(2);
                    } else if (data_type == 2) {
                        modal(3);
                    } else if (data_type == 3) {
                        modal(4);
                    }
                })

                if (data_type == 1) {
                    cpu_btn.classList.add('active');
                    ram_btn.classList.remove('active');
                    disk_btn.classList.remove('active');
                    document.getElementById('component_name_title').innerHTML = "CPU";
                } else if (data_type == 2) {
                    ram_btn.classList.add('active');
                    disk_btn.classList.remove('active');
                    cpu_btn.classList.remove('active');
                    document.getElementById('component_name_title').innerHTML = "Memória RAM";
                } else if (data_type == 3) {
                    disk_btn.classList.add('active');
                    cpu_btn.classList.remove('active');
                    ram_btn.classList.remove('active');
                    document.getElementById('component_name_title').innerHTML = "Disco";
                }

            } else {
                console.log("Nenhum dado encontrado!");
            }
        }).catch(function (err) {
            console.log(`Erro na obtenção dos dados p/ gráfico: ${err.message}`);
        })
}

function lastAgend() {

    fetch(`/dados/agendamentos/lastAgend/${id_totem}`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (response) {
        if (response.ok) {
            response.json().then(json => {
                for (var i = 0; i < json.length; i++) {
                    document.getElementById('last_manun').innerHTML = `${(json[i].data_agen)}`;
                }
            })
        } else {
            console.log("ERRO NA RESPONSE");
        }
    }).catch(function (err) {
        console.log(err);
    })

    return false;
}


function plotGraph(res, data_type) {

    var dados = {
        labels: [],
        datasets: [{
            yAxisID: 'y-cpu',
            label: 'DADOS',
            borderColor: '#32B9CD',
            backgroundColor: '#32b9cd8f',
            fill: true,
            data: []
        }]
    };

    for (var i = 0; i < res.length; i++) {
        var register = res[i];
        dados.labels.push(register.dh_registro);
        if (data_type == 1) {
            dados.datasets[0].data.push(register.uso_cpu);
        } else if (data_type == 2) {
            dados.datasets[0].data.push(register.uso_ram);
        } else if (data_type == 3) {
            dados.datasets[0].data.push(register.uso_disco);
        }
    }

    let cpu = 0;
    let ram = 0;
    let disk = 0;

    fetch(`/dados/limites/${id_totem}`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (response) {
        if (response.ok) {
            response.json().then(json => {
                for (var i = 0; i < json.length; i++) {

                    cpu = `${json[i].uso_cpu}`;
                    ram = `${json[i].uso_ram}`;
                    disk = `${json[i].uso_disco}`;
                    tempo = `${json[i].tempo_cpu}`;

                    document.getElementById('limite_ram_param').innerHTML = `${(json[i].uso_ram).toFixed(1)}MB`;
                    document.getElementById('limite_cpu_param').innerHTML = `${(json[i].uso_cpu).toFixed(2)}%`;
                    document.getElementById('limite_disco_param').innerHTML = `${(json[i].uso_disco).toFixed(2)}%`;
                    document.getElementById('limite_proc_param').innerHTML = `${(json[i].qtd_proc)}(MAX)`;
                }
            })
        } else {
            console.log("Erro ao puxar os parâmetros");
        }
    }).catch(function (err) {
        console.log(err);
    })

    setInterval(() => {
        fetch(`/dados/real-time/${id_totem}`, {
            cache: "no-store"
        }).then(function (response) {
            if (response.ok) {
                response.json().then(function (newRegister) {


                    document.getElementById('cpu_usage_user').innerHTML = `${newRegister[0].uso_cpu}`;
                    document.getElementById('ram_usage_user').innerHTML = `${newRegister[0].uso_ram}`;
                    document.getElementById('disk_usage_user').innerHTML = `${newRegister[0].uso_disco}`;

                    var newCpu = document.getElementById('percent-usage-cpu').innerHTML = `${newRegister[0].uso_cpu}`;
                    var newRam = document.getElementById('percent-usage-ram').innerHTML = `${newRegister[0].uso_ram}`;
                    var newDisk = document.getElementById('percent-usage-disk').innerHTML = `${newRegister[0].uso_disco}`;

                    if(newCpu > cpu){
                        document.getElementById('usage-cpu-spn').style.backgroundColor = 'tomato';
                    }
                    if(newCpu < cpu){
                        document.getElementById('usage-cpu-spn').style.backgroundColor = '#a0d11b';
                    }
                    if(newRam > ram){
                        document.getElementById('usage-ram-spn').style.backgroundColor = 'tomato';
                    }
                    if(newRam < ram){
                        document.getElementById('usage-ram-spn').style.backgroundColor = '#a0d11b';
                    }
                    if(newDisk > disk){
                        document.getElementById('usage-disk-spn').style.backgroundColor = 'tomato';
                    }
                    if(newDisk < disk){
                        document.getElementById('usage-disk-spn').style.backgroundColor = '#a0d11b';
                    }

                    dados.labels.shift();
                    dados.labels.push(newRegister[0].dh_registro);
                    dados.datasets[0].data.shift();
                    if(data_type == 1){
                        dados.datasets[0].data.push(newRegister[0].uso_cpu);
                    }else if(data_type == 2){
                        dados.datasets[0].data.push(newRegister[0].uso_ram);
                    }else if(data_type == 3){
                        dados.datasets[0].data.push(newRegister[0].uso_disco);
                    }

                    window.grafico_linha.update();
                })
            } else {
                console.log("Nenhum dado encontrado!");
            }
        }).catch(function (err) {
            console.log(err);
        })
    }, 2000);


    let chartStatus = Chart.getChart("myChart");
    if (chartStatus != undefined) {
        chartStatus.destroy();
    }

    var ctx = myChart.getContext('2d');

    window.grafico_linha = new Chart(ctx, {
        type: 'line',
        data: dados,
        options: {
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


function alertLog(typeLog){

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
                    if (json[i].sistema_op == "Linux") {
                        document.getElementById('sistem_op_icon').className = "fa-brands fa-linux";
                        document.getElementById('sistema_op').innerHTML = `${(json[i].sistema_op)}`;
                    } else {
                        document.getElementById('sistem_op_icon').className = "fa-brands fa-windows";
                        document.getElementById('sistema_op').innerHTML = `${(json[i].sistema_op)}`;
                    }
                    document.getElementById('hostname').innerHTML = `${(json[i].hostname)}`;
                    document.getElementById('totem_hostname').innerHTML = `${(json[i].hostname)}`;
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

function getNextAgend() {
    fetch(`/dados/agendamentos/${id_totem}`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (response) {
        if (response.ok) {
            response.json().then(json => {
                for (var i = 0; i < json.length; i++) {
                    document.getElementById('nextManun_date').innerHTML = `${json[i].data_agen}`;
                }
            })
        } else {
            console.log("Erro ao localizar o próximo agendamento");
        }
    }).catch(function (err) {
        console.log(err);
    })

    return false
}


function refreshGraph(id_totem, dados) {


    fetch(`/dados/${data_number}/real-time/${id_totem}`, {
        cache: 'no-store'
    }).then(function (response) {
        if (response.ok) {
            response.json().then(function (newRegister) {
                dados.labels.shift();
                dados.labels.push(newRegister[0].dh_registro);
                dados.datasets[0].data.shift();
                dados.datasets[0].data.push(newRegister[0].uso_cpu);

                window.grafico_linha.update();

                nextUp = setTimeout(() => refreshGraph(id_totem, dados), 2000);
            })
        } else {
            console.error("Nenhum dado encontrado!");
            nextUp = setTimeout(() => refreshGraph(id_totem, dados), 2000);
        }
    }).catch(function (err) {
        console.error(`Erro na obtenção dos dados p/ gráfico: ${err.message}`);
    })

}


function getAgendCheck() {
    fetch(`/dados/agendamentos/check/${id_totem}`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (response) {
        if (response.ok) {
            response.json().then(json => {
                for (var i = 0; i < json.length; i++) {

                    var contentModal = document.getElementById('box_content-modal-alerts');
                    var divPlottAgend = document.createElement('div');
                    var div2 = document.createElement('div');
                    var divHeader = document.createElement('div');
                    var motivoAgen = document.createElement('span');
                    var spanIcon = document.createElement('span');
                    var spanDate = document.createElement('span');
                    var icon = document.createElement('i');
                    var spanDesc = document.createElement('span');

                    // CLASSES E IDs
                    div2.className = 'alert';
                    divHeader.className = 'alert-header';
                    motivoAgen.className = 'title_alert';
                    motivoAgen.innerHTML = `${(json[i].motivo)}`;
                    // spanIcon
                    spanDate.innerHTML = `${(json[i].data_agen)}`;
                    icon.className = 'fa-solid fa-check';
                    icon.style.color = 'green';
                    spanDesc.innerHTML = `${(json[i].descricao)}`;


                    // APPENDCHIELDS
                    contentModal.appendChild(divPlottAgend);
                    divPlottAgend.appendChild(div2);
                    div2.appendChild(divHeader);
                    div2.appendChild(spanDesc);
                    divHeader.appendChild(motivoAgen);
                    divHeader.appendChild(spanIcon);
                    spanIcon.appendChild(spanDate);
                    spanIcon.appendChild(icon);
                }

            })
        } else {
            console.log("ERRO NA RESPONSE");
        }
    }).catch(function (err) {
        console.log(err);
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
                for (var i = 0; i < json.length; i++) {
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
                    td_cpu.innerHTML = `${(json[i].consumo_cpu)}%`;
                    td_ram.innerHTML = `${(json[i].consumo_ram)}%`;
                }
            })
        } else {
            console.log("Erro ao puxar os processos!");
        }
    }).catch(function (err) {
        console.log(err);
    })

    return false
}