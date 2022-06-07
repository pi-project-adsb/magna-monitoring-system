var id_totem = sessionStorage.ID_TOTEM;

window.onload = getAllAgends();

function getAllAgends(){
    fetch(`/dados/agendamentos/notCheck/${id_totem}`, {
        method: 'GET',
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(response){
        if(response.ok){
            response.json().then(json => {
                for(var i = 0; i < json.length; i++){

                    // DADOS
                    let id = json[i].id;
                    var motivo = json[i].motivo;
                    let desc = json[i].descricao;
                    let dateAgend = json[i].data_agen;

                    var date = document.getElementById(`${dateAgend}`);
                    var divButton = document.getElementById('div_button');
                    var icon = document.createElement('i');
                    var button = document.createElement('button');

                    // CLASSE AND ID
                    icon.className = 'fa-solid fa-circle-exclamation';
                    icon.id = `${dateAgend}`;
                    button.id = `${id}`;

                    // APPEND CHIELD
                    date.appendChild(icon);
                    divButton.appendChild(button);

                    // CONTENT
                    button.innerHTML = "Manutenção realizada";

                    // EVENT LISTENER
                    icon.addEventListener("click", () => {
                        modal(1);
                        document.getElementById('id_agend_spn').innerHTML = `${id}`;
                        document.getElementById('motivo_manun').innerHTML = `${motivo}`;
                        document.getElementById('data_agend_spn').innerHTML = `${dateAgend}`;
                        document.getElementById('desc_agend_spn').innerHTML = `${desc}`;
                    });

                    button.addEventListener("click", () => {
                        updateAgend(id);
                    })
                }
            })
        }else{
            console.log("ERRO NA RESPONSE");
        }
    }).catch(function(err){
        console.log(err);
    })

    return false;
}


function updateAgend(idAgend){
    var idAgendamento = idAgend;

    fetch(`/dados/agendamentos/update`, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            idAgendServer: idAgendamento,
            id_totemServer: id_totem
        })
    }).then(function(response){
        if(response.ok){
            window.alert("Status de manutenção atualizado com sucesso!");
        }else{
            console.log("Houve um erro ao tentar fazer o update!")
        }
    }).catch(function(err){
        console.log(err);
    })

    return false;
}