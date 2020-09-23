CREATE DATABASE Academico;
USE Academico;
DROP TABLE Aluno;
DROP TABLE Instituicao;
CREATE TABLE Instituicao (
	Id uniqueidentifier NOT NULL,
        Nome varchar(100) NOT NULL,
        CNPJ varchar(14) NOT NULL,
        PRIMARY KEY (ID)
);
CREATE TABLE Aluno (
	Id uniqueidentifier NOT NULL,
	Instituicao_Id uniqueidentifier NULL,
	Nome varchar(100) NOT NULL,
	CPF varchar(11) NOT NULL,
	Matricula varchar(9) NOT NULL,
	Data_Nascimento datetime NOT NULL,
	Data_Matricula datetime NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (Instituicao_Id) REFERENCES Instituicao(Id)
);
