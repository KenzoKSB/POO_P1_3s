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