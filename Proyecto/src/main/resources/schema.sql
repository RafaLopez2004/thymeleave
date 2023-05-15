drop table if exists Juego;
drop table if exists Plataforma;
drop table if exists Genero;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 100 increment by 1;


create table Genero (
	id bigint not null auto_increment,
	nombre varchar(512), 
    descripcion blob,
	primary key (id)
);

create table Plataforma (
	id bigint not null auto_increment, 
	nombre_Plataforma varchar(20),
    descripcion blob,
	primary key (id)
);

create table Juego (
	id bigint not null auto_increment, 
	nombre varchar(512), 
	genero_id bigint,
	descripcion blob, 
	pvp float not null, 
	descuento float not null, 
	imagen varchar(512), 
    plataforma_id bigint,
	primary key (id),
    constraint fk_juego_genero foreign key (genero_id) references Genero(id) ON DELETE CASCADE ON UPDATE CASCADE,
    constraint fk_juego_plataforma foreign key (plataforma_id) references Plataforma(id) ON DELETE CASCADE ON UPDATE CASCADE
);