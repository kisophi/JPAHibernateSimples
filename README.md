# JPAHibernateSimples
``` 
CREATE DATABASE usuariodb;
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
```
