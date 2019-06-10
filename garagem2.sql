-- Database: ProgDesk

-- DROP DATABASE "ProgDesk";
CREATE SCHEMA Garagem
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
	

    -- private String Name;
    -- private String Color;
    -- private String Year;
    -- private String Model;
	
CREATE TABLE Garagem.Car (
   id serial PRIMARY KEY,
   name VARCHAR (50) NOT NULL,
   color VARCHAR (50) NOT NULL,
   year VARCHAR (4) NOT NULL,
   model VARCHAR(255) NOT NULL
);

    -- private String firstName;
    -- private String lastName;
    -- private String address;
    -- private String phone;
    -- private String email;
CREATE TABLE Garagem.Client (
   id serial PRIMARY KEY,
   firstName VARCHAR (50) NOT NULL,
   lastName VARCHAR (50) NOT NULL,
   address VARCHAR (50) NOT NULL,
   phone VARCHAR(25) NOT NULL,
   email VARCHAR (255) NOT NULL
);

  -- private String name;
  --   private String login;
  --   private String password;
CREATE TABLE Garagem.User (
   id serial PRIMARY KEY,
   name VARCHAR (50) NOT NULL,
   login VARCHAR (50) UNIQUE NOT NULL,
   password VARCHAR (50) NOT NULL
);

-- INSERT INTO ON USERS
INSERT INTO Garagem.User ("name", "login", "password")
VALUES	('root', 'root', 'root'),
		('Gustavo Borges', 'borges', 'abcd1234');

-- INSERT INTO ON CLIENTS
INSERT INTO Garagem.Client ("firstName", "lastName", "address", "phone", "email")
VALUES	('Luiz', 'Henrique', 'Rua das caracas, 201', '+55 11 33211010', 'luiz.henrique@hotmail.com'),
		('Artur', 'Massaro', 'Rua da lapa, 200', '+55 11 996110029', 'artur.massaro@yazo.com.br'),
		('Leonardo', 'Flores', 'Rua dos bobos, 0', '+55 43 991673296', 'leonardo.flores@gmail.com.br');

-- INSERT INTO ON CARS
INSERT INTO Garagem.Car ("name", "color", "year", "model")
VALUES	('Golf GTX', 'Branco', '2015', 'Volkswagen'),
		('Uno', 'Prata', '2015', 'Fiat'),
		('Palio', 'Branco', '2015', 'Fiat'),
		('CrossFox', 'Vermelho', '2015', 'Volkswagen'),
		('Voyage', 'Preto', '2011', 'Volkswagen');


