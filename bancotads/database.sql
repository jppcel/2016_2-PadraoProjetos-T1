CREATE TABLE genero (
	id int auto_increment not null,
	name varchar(60) not null,
	PRIMARY KEY(id)
);

CREATE TABLE tipoConta (
	id int auto_increment not null,
	name varchar(60) not null,
	PRIMARY KEY(id)
);

CREATE TABLE tipoUsuario (
	id int auto_increment not null,
	name varchar(60) not null,
	PRIMARY KEY(id)
);

CREATE TABLE pessoa (
	id int auto_increment not null,
	name varchar(200) not null,
	born date not null,
	cpf varchar(14) not null,
	genero int not null,
	dataCadastro varchar(150) not null,
	PRIMARY KEY(id),
	FOREIGN KEY(genero) references genero(id)
);

CREATE TABLE agencia (
	id int auto_increment not null,
	name varchar(100) not null,
	numeroAgencia varchar(5) not null,
	saldo double not null,
	PRIMARY KEY(id)
);

CREATE TABLE conta (
	id int auto_increment not null,
	agencia int not null,
	numeroConta varchar(8) not null,
	tipoConta int not null,
	saldo double not null,
	dataCriacao datetime not null,
	PRIMARY KEY(id),
	FOREIGN KEY(agencia) references agencia(id),
	FOREIGN KEY(tipoConta) references tipoConta(id),
	FOREIGN KEY(agencia) references agencia(id)
);

CREATE TABLE usuario (
	id int auto_increment not null,
	pessoa int not null,
	username varchar(100) not null,
	password varchar(150) not null,
	passwordOperacoes varchar(150) not null,
	tipoUsuario int not null,
	conta int null,
	dataCriacao datetime not null,
	dataModificacao datetime null,
	dataDesativacao datetime null,
	ativo boolean not null,
	PRIMARY KEY(id),
	FOREIGN KEY(pessoa) references pessoa(id),
	FOREIGN KEY(tipoUsuario) references tipoUsuario(id),
	FOREIGN KEY(conta) references conta(id)
);
