## Como rodar

1. Instalar PostgreSQL

2. Criar banco:

CREATE DATABASE jogo_db;

3. Criar tabela:

CREATE TABLE tb_musica(
    faixa SERIAL PRIMARY KEY,
    titulo VARCHAR(255)
);

INSERT INTO tb_musica
(titulo)
VALUES
('Jeremy'),
('Stairway to Heaven'),
('Numb'),
('Dream On'),
('Black'),
('Smells Like Teen Spirit'),
('Californication'),
('In the End'),
('Fear of the Dark'),
('Highway to Hell');

SELECT * FROM tb_musica;

4. Compilar:

javac -cp ".;lib/postgresql-42.7.10.jar" *.java

5. Executar:

java -cp ".;lib/postgresql-42.7.10.jar;." Jogo