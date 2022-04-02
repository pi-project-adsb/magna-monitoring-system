/* para workbench - local - desenvolvimento */
create DATABASE omega;
USE omega;

CREATE TABLE filme (
    idFilme INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(80),
    genero VARCHAR(30),
    lancamento date
);

create TABLE usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    email VARCHAR(50),
    senha VARCHAR(50),
    genero CHAR(1),
    desde datetime,
    fkFilme INT,
		FOREIGN KEY (fkFilme)
			REFERENCES filme (idfilme)
);

insert into filme (titulo, genero)
values
("A Guerra do Amanhã", "aventura"),
("Esquadrão Suicida", "acao"),
("Eternos", "acao"),
("Liga da Justiça: SnyderCut", "acao"),
("Alerta Vermelho", "acao"),
("Deadpool 2", "acao"),
("Shazam", "geek"),
("Nobody", "suspense"),
("Lucca", "animacao"),
("Mulher Maravilha", "acao"),
("Madagascar", "animacao"),
("Hulk", "acao"),
("Vingadores", "acao"),
("Esquadrão 6", "acao"),
("Space Jam", "ficcao"),
("Viuva Negra", "acao"),
("Shang Chi: A Lenda dos Dez Anéis", "acao"),
("Raya", "animacao");

insert into usuario (nome, email, senha, fkFilme)
values
("Lucas", "lucas@bandtec.com", "lucas123", 9),
("Pedro", "pedro@bandtec.com", "pedro123", 8),
("Joao", "joao@bandtec.com", "joao", 5),
("Alex", "alex@bandtec.com", "alex", 3),
("Cleber", "cleber@bandtec.com", "cleber", 9),
("Cristina", "cristina@bandtec.com", "cristina", 4),
("Julia", "julia@bandtec.com", "julia", 2),
("Natalia", "natalia@bandtec.com", "natalia", 1),
("Bianca", "bianca@bandtec.com", "bianca", 7),
("Roger", "roger@bandtec.com", "roger", 5),
("Rodrigo", "rodrigo@bandtec.com", "rodrigo", 6),
("Helio", "helio@bandtec.com", "helio", 4),
("Jessica", "jessica@bandtec.com", "jessica", 9),
("Luiza", "luiza@bandtec.com", "luiza", 9),
("Renata", "renata@bandtec.com", "renata", 1),
("Leticia", "leticia@bandtec.com", "leticia", 9),
("Karina", "karina@bandtec.com", "karina", 1),
("Matheus", "matheus@bandtec.com", "matheus", 9),
("Cristian", "cristian@bandtec.com", "cristian", 1),
("Enzo", "enzo@bandtec.com", "enzo", 9),
("Jorge", "jorge@bandtec.com", "jorge", 2),
("Ana", "ana@bandtec.com", "ana", 3),
("Marina", "marina@bandtec.com", "marina", 3);

select * from usuario;

SELECT COUNT(fkFilme) AS TotalFilme, fi.titulo FROM usuario us
													JOIN filme fi ON us.fkFilme = fi.idFilme 
														GROUP BY titulo ORDER BY TotalFilme DESC;
																	
                                                                        
select * from usuario;
select * from filme;

select us.idUsuario, fi.titulo from usuario us 
					join filme fi on us.fkFilme = fi.idFilme;

UPDATE usuario SET senha = 'lucas123' WHERE email = 'lucas.lacerda@bandtec.com';

UPDATE usuario SET senha = md5('${senha}') WHERE email = '${email}';

SET SQL_SAFE_UPDATES = 0;