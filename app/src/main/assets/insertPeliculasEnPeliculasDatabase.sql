DELETE FROM peliculasTabla;
INSERT INTO peliculasTabla (idPelicula, titulo, anho, fechaVisionado, ciudadVisionado, valoracion, duracion, pais, directorPrincipal, genero, sinopsis, imagen, actorPrincipal)
VALUES (1, 'Prueba1', 1991, '2019-04-03', 'Madrid', 5, '120', 'SPA', 'Manolo', 'Terror', 'Pruébala', 'IMAGEN_PNG1', 'Rigoberto'),
       (2, 'Prueba2', 1992, '2020-04-03', 'Vigo', 6, '180', 'ENG', 'Paco', 'Thriller', 'Mírala', 'IMAGEN_PNG2', 'Gumersinda'),
       (3, 'Prueba3', 1993, '2021-05-01', 'Barcelona', 7, '150', 'ITA', 'Lucía', 'Drama', 'Mira esto', 'IMAGEN_PNG3', 'Mariano'),
       (4, 'Prueba4', 1994, '2021-06-01', 'Valencia', 8, '130', 'FRA', 'Juan', 'Comedia', 'Prueba esto', 'IMAGEN_PNG4', 'Carmen'),
       (5, 'Prueba5', 1995, '2021-07-01', 'Sevilla', 9, '140', 'USA', 'Ana', 'Ciencia ficción', 'Otra prueba', 'IMAGEN_PNG5', 'Luis'),
       (6, 'Prueba6', 1996, '2021-08-01', 'Zaragoza', 10, '110', 'CHN', 'Pepe', 'Aventura', 'Prueba más', 'IMAGEN_PNG6', 'Lucas'),
       (7, 'Prueba7', 1997, '2021-09-01', 'Málaga', 8, '170', 'AUS', 'Marta', 'Acción', 'Algo nuevo', 'IMAGEN_PNG7', 'Juan'),
       (8, 'Prueba8', 1998, '2021-10-01', 'Bilbao', 6, '190', 'MEX', 'Sara', 'Romance', 'Prueba final', 'IMAGEN_PNG8', 'Lucía'),
       (9, 'Prueba9', 1999, '2021-11-01', 'Cádiz', 5, '160', 'CAN', 'Alba', 'Drama', 'Mira otra', 'IMAGEN_PNG9', 'Manuel'),
       (10, 'Prueba10', 2000, '2021-12-01', 'Toledo', 7, '200', 'JPN', 'Mario', 'Thriller', 'La última', 'IMAGEN_PNG10', 'Natalia');
