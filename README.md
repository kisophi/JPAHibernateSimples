# JPAHibernateSimples
CRUD com JPA Hibernate


CREATE DATABASE usuariodb;

USE usuariodb;

CREATE TABLE usuario(
	id int AUTO_INCREMENT,
    nome VARCHAR(45),
    login VARCHAR(45),
    senha VARCHAR(45),
    nascimento DATE,
    PRIMARY KEY(id)
);
