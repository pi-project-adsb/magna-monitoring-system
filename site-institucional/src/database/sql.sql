/* para workbench - local - desenvolvimento */
create DATABASE if not exists magna;
USE magna;

create TABLE if not exists usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
	empresa VARCHAR(50),
    email VARCHAR(50),
    senha VARCHAR(50),
    desde datetime
);

insert into usuario (nome, email, senha)
values
("Lucas", "lucas@bandtec.com", "lucas123"),
("Pedro", "pedro@bandtec.com", "pedro123"),
("Joao", "joao@bandtec.com", "joao"),
("Alex", "alex@bandtec.com", "alex"),
("Cleber", "cleber@bandtec.com", "cleber"),
("Cristina", "cristina@bandtec.com", "cristina"),
("Julia", "julia@bandtec.com", "julia"),
("Natalia", "natalia@bandtec.com", "natalia"),
("Bianca", "bianca@bandtec.com", "bianca"),
("Roger", "roger@bandtec.com", "roger"),
("Rodrigo", "rodrigo@bandtec.com", "rodrigo"),
("Helio", "helio@bandtec.com", "helio"),
("Jessica", "jessica@bandtec.com", "jessica"),
("Luiza", "luiza@bandtec.com", "luiza"),
("Renata", "renata@bandtec.com", "renata"),
("Leticia", "leticia@bandtec.com", "leticia"),
("Karina", "karina@bandtec.com", "karina"),
("Matheus", "matheus@bandtec.com", "matheus"),
("Cristian", "cristian@bandtec.com", "cristian"),
("Enzo", "enzo@bandtec.com", "enzo"),
("Jorge", "jorge@bandtec.com", "jorge"),
("Ana", "ana@bandtec.com", "ana"),
("Marina", "marina@bandtec.com", "marina");

select * from usuario;							

UPDATE usuario SET senha = md5('${senha}') WHERE email = '${email}';

SET SQL_SAFE_UPDATES = 0;