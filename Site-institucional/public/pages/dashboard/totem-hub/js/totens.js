document.getElementById("name_user_spn").innerHTML = sessionStorage.NOME_EMPRESA;
var id = sessionStorage.ID_EMPRESA;
var numberID = [];

function totens() {

    fetch(`/users/totem/${id}`, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (response) {
        if (response.ok) {
            response.json().then(json => {  

                for (var i = 0; i < json.length; i++) {

                    let section = document.getElementById('section_one');
                    let totem_img = document.createElement('div');
                    let totem_box = document.createElement('div');
                    let i_icon = document.createElement('i');
                    let totem_desc = document.createElement('div');
                    let totem_name = document.createElement('div');
                    let span_name_totem = document.createElement('span');
                    let a = document.createElement('a');
                    let i_icon_href = document.createElement('i');

                    // CLASSES 
                    totem_box.className = 'totem-box';
                    totem_img.className = 'totem-img';
                    i_icon.className = 'fa-solid fa-display';
                    totem_desc.className = 'totem-description';
                    totem_name.className = 'totem-name';
                    i_icon_href.className = 'fa-solid fa-circle-right';
                    i_icon_href.id = `${json[i].id_totem}`;
                    

                    // APPEND CHIELDS
                    section.appendChild(totem_box);
                    totem_box.appendChild(totem_img);
                    totem_box.appendChild(totem_desc);
                    totem_img.appendChild(i_icon);
                    totem_desc.appendChild(totem_name);
                    totem_name.appendChild(span_name_totem);
                    span_name_totem.innerHTML = `${json[i].name_totem} #${i + 1}`;
                    totem_desc.appendChild(a);
                    a.appendChild(i_icon_href);
                }

                let btn = document.querySelectorAll(".fa-solid.fa-circle-right");
                btn.forEach(i => {
                    i.addEventListener("click", () => {
                        sessionStorage.clear;
                        sessionStorage.ID_TOTEM = i.id;
                    })
                });

            });
        } else {
            console.log("Erro ao localizar o totem");
        }

    }).catch(function (erro) {
        console.log(erro);
    })

    return false;
}



// fazer rota para retorno de dados do totem para a dashboard após o clique do usuário em determinado totem.
// colocar hostname no totem-box para identificação do mesmo