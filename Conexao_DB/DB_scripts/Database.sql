create database atividade_conexao_db;
use atividade_conexao_db;

create table funcionarios (
	id int(5) auto_increment not null primary key,
    primeiro_nome varchar(20) not null,
    ultimo_nome varchar(20) not null,
    cpf varchar(11) not null,
    telefone varchar(11) not null,
    email varchar(50) not null
);

insert into funcionarios(primeiro_nome, ultimo_nome, cpf, telefone, email) values
("Emanoel", "Silva", "12341228911", "11970409041", "emanoel@gmail.com");

select * from funcionarios;

select * from funcionarios where id = 2 or primeiro_nome like "José";

update funcionarios set primeiro_nome = "Marcos" where id = 1;

delete from funcionarios where id = 1;

drop table funcionarios;