# JPAHibernateSimples
Banco de dados Mysql
```mysql
CREATE DATABASE usuariodb;
USE usuariodb;
CREATE TABLE nivel(
	id INT NOT NULL,
	descricao VARCHAR(45)NOT NULL,
		PRIMARY KEY(id)
);
CREATE TABLE usuario(
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(45),
	login VARCHAR(45),
	senha VARCHAR(45),
	nascimento DATE,
	nivel_id INT,
		PRIMARY KEY(id),
		FOREIGN KEY(nivel_id) REFERENCES nivel(id)
);

-- PREENCHER OS CAMPOS DA TABLE NIVEL
INSERT INTO nivel VALUES (1,'Administrador');
INSERT INTO nivel VALUES (1,'Usuario Comun');

-- PREENCHER OS CAMPOS DA TABELA USUARIO
INSERT INTO usuario VALUES (null,'Akira Matsumoto','akira','123',01/01/1999,1);
INSERT INTO usuario VALUES (null,'Maria dos Santos','maria','111',02/02/2000,2);
INSERT INTO usuario VALUES (null,'Pedro da Silva','pedro','222',20/10/1980,2);
INSERT INTO usuario VALUES (null,'Carla Vieira','carla','333',05/05/1995,2);
INSERT INTO usuario VALUES (null,'Otavio Mesquita','otavio','444',11/12/2001,2);

```
