create database projetoScenario;

use projetoScenario;
create table Projeto (id integer  not null primary key,nome varchar(45) NOT NULL);

insert into projeto(id,nome) values(1,"ambev");
insert into projeto(id,nome, descricao) values(2,"ambev","Projeto teste");
insert into projeto(descricao) values("Projeto de automacao Total");

insert into projeto(id,nome, descricao) values(3,"Nestle","Projeto 3");


alter table projeto add descricao varchar (80);

select * from projeto;
select * from Ambiente;

create table Ambiente(codItem integer not null, itens varchar (80)); 
insert into Ambiente(codItem, itens) values(1, "Controlador TV"); 
insert into Ambiente(codItem, itens) values(2, "Controlador Iluminacao Sala"); 
insert into Ambiente(codItem, itens) values(3, "Controlador Cortina escritorio");

