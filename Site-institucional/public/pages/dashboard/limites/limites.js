var id_totem = sessionStorage.ID_TOTEM;

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


function updateParams(data_type){
    if(data_type == 1){
        var tempo = document.getElementById('slct_time_ram').value;
        var limite = document.getElementById('limite_ram').value;
        var id = id_totem;

        fetch(`/dados/${data_type}/limites`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                tempoServer: tempo,
                limiteServer: limite,
                id_totemServer: id
            })
        }).then(function(response){
            if(response.ok){
                window.alert("Limites de memória RAM atualizados com sucesso!");
            }else{
                console.log("Houve um erro ao tentar fazer o update!");
            }
        }).catch(function(err){
            console.log(err);
        })

        return false;
    }else if(data_type == 2){
        var tempo = document.getElementById('slct_time_cpu').value;
        var limite = document.getElementById('limite_cpu').value;
        var id = id_totem;

        fetch(`/dados/${data_type}/limites`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                tempoServer: tempo,
                limiteServer: limite,
                id_totemServer: id
            })
        }).then(function(response){
            if(response.ok){
                window.alert("Limites de CPU atualizados com sucesso!");
            }else{
                console.log("Houve um erro ao tentar fazer o update!");
            }
        }).catch(function(err){
            console.log(err);
        })

        return false;
    }else if(data_type == 3){
        var tempo = document.getElementById('slct_time_disk').value;
        var limite = document.getElementById('limite_disk').value;
        var id = id_totem;

        fetch(`/dados/${data_type}/limites`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                tempoServer: tempo,
                limiteServer: limite,
                id_totemServer: id
            })
        }).then(function(response){
            if(response.ok){
                window.alert("Limites de disco atualizados com sucesso!");
            }else{
                console.log("Houve um erro ao tentar fazer o update!");
            }
        }).catch(function(err){
            console.log(err);
        })

        return false;
    }else if(data_type == 4){
        var limite = document.getElementById('limite_proc').value;
        var id = id_totem;

        fetch(`/dados/${data_type}/limites`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                qtd_procServer: limite,
                id_totemServer: id
            })
        }).then(function(response){
            if(response.ok){
                window.alert("Limites de processos atualizados com sucesso!");
            }else{
                console.log("Houve um erro ao tentar fazer o update!");
            }
        }).catch(function(err){
            console.log(err);
        })

        return false;
    }
}
