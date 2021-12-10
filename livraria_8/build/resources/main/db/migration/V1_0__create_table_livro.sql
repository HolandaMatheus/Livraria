CREATE TABLE TB_LIVRO (
    id integer NOT NULL AUTO_INCREMENT,
    isbn varchar(50) DEFAULT NULL,
    titulo varchar(500) NOT NULL,
    descricao varchar (500) NOT NULL,
    preco double NOT NULL,
    PRIMARY KEY (id)
)