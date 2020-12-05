CREATE TABLE IF NOT EXISTS Conteiner (
	id serial PRIMARY KEY,
	nm_Cliente varchar(50),
	cd_Conteiner varchar(50),
	ic_Tipo int,
	ic_Status varchar(5),
	ic_Categoria varchar(10)
);

CREATE TABLE IF NOT EXISTS Movimentacao (
	id serial PRIMARY KEY,
	nm_Navio VARCHAR(100),
	ds_Movimentacao VARCHAR(50),
	dt_Inicio VARCHAR(10),
	dt_Final VARCHAR(10)
);