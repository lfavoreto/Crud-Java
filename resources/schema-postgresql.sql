CREATE TABLE IF NOT EXISTS Conteiner (
	id serial PRIMARY KEY,
	nm_Cliente varchar(50),
	cd_Conteiner varchar(50),
	ic_Tipo int,
	ic_Status varchar(5),
	ic_Categoria varchar(10)
);