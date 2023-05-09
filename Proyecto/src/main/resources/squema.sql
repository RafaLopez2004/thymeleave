drop table if exists Plataforma;
drop table if exists Producto;
drop table if exists Genero;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 100 increment by 1;


create table Genero (
	nombre varchar(512), 
    descripcion blob,
	primary key (nombre)
);

create table Juego (
	id bigint not null auto_increment, 
	nombre varchar(512), 
	genero varchar(512),
	descripcion blob, 
	pvp float not null, 
	descuento float not null, 
	imagen varchar(512), 
    plataforma bigint,
	primary key (id),
    constraint fk_juego_genero foreign key (genero) references Genero(nombre),
    constraint fk_juego_plataforma foreign key (plataforma) references Plataforma(id)
);

create table Plataforma (
	id bigint not null auto_increment, 
	nombrePlataforma varchar(20),
    descripcion blob,
	imagen varchar(512),
    pvp float not null,    	
    descuento float not null, 
	primary key (id)
);
