INSERT INTO taller1.Persona(Nombre, Ap, Am, Correo, Telefono, Usuario, Contrasena, Suspendido, Direccion, Imagen, Estado, Unidad, Discriminator) VALUES ('carlos', 'perez', 'perez', 'perez@hotmail.com', '59160257836', 'perez', 'perez', 0, 'av. montes', null, true, '', '');
INSERT INTO taller1.Persona(Nombre, Ap, Am, Correo, Telefono, Usuario, Contrasena, Suspendido, Direccion, Imagen, Estado, Unidad, Discriminator) VALUES ('mario', 'alfaro', 'quito', 'mario@hotmail.com', '4545646', 'alfaro', 'alfaro', 0, 'av. americas', '', true, '', '');
INSERT INTO taller1.director(Unidad, Gestion) VALUES (' 10', 2015);
INSERT INTO taller1.ciclo(Nombre, Turno, directorGestion, DirectorPersonaCi, Estado) VALUES ('1ra Seccion', 'm', 2015, 1, true);
INSERT INTO taller1.ciclo(Nombre, Turno, directorGestion, DirectorPersonaCi, Estado) VALUES ('Inicial', 't', 2015, 1, true);
INSERT INTO taller1.ciclo(Nombre, Turno, directorGestion, DirectorPersonaCi, Estado) VALUES ('Primaria', 'm', 2015, 1, true);
INSERT INTO taller1.curso(cicloIdciclo, Nombre, estado) VALUES (1, '1ra SeccionSe', true);
INSERT INTO taller1.curso(cicloIdciclo, Nombre, estado) VALUES (2, '2da Seccion', true);
INSERT INTO taller1.curso(cicloIdciclo, Nombre, estado) VALUES (3, '1ero Primaria', true);
INSERT INTO taller1.curso(cicloIdciclo, Nombre, estado) VALUES (3, '2do Primaria', true);
INSERT INTO taller1.curso(cicloIdciclo, Nombre, estado) VALUES (3, '3do  Primaria', true);
INSERT INTO taller1.curso(cicloIdciclo, Nombre, estado) VALUES (3, '4to Primaria', true);
INSERT INTO taller1.curso(cicloIdciclo, Nombre, estado) VALUES (3, '5to Primaria', true);
INSERT INTO taller1.curso(cicloIdciclo, Nombre, estado) VALUES (3, '6to Primaria', true);
INSERT INTO taller1.valoracion(Vcualitativa, Vcualitativaabreviacion, Vcliminf, Vclimsup, estado) VALUES ('Valoracion Cualitativa', 1, 1, 100, true);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('1A', 'Primero A', true, 1);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('1B', 'Primero B', true, 1);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('1C', 'Primero C', true, 1);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('2A', 'Segundo A', true, 2);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('2B', 'Segundo B', true, 2);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('2C', 'Segundo C', true, 2);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('3A', 'Tercero A', true, 3);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('3B', 'Tercero B', true, 3);
INSERT INTO taller1.aula(Idaula, Nombre, estado) VALUES ('1A', 'Aula 1A', true);
INSERT INTO taller1.aula(Idaula, Nombre, estado) VALUES ('1B', 'Aula 1B', true);
INSERT INTO taller1.asigna(Horaentrada, Horasalida, Anno, paraleloIdparalelo, aulaIdaula, estado, paraleloIdcurso) VALUES ('10:30', '12:00', '2016', '2C', '1A', True, 2);
INSERT INTO taller1.asigna(Horaentrada, Horasalida, Anno, paraleloIdparalelo, aulaIdaula, estado, paraleloIdcurso) VALUES ('8:30', '10:00', '2016', '2B', '1A', True, 2);
INSERT INTO taller1.asigna(Horaentrada, Horasalida, Anno, paraleloIdparalelo, aulaIdaula, estado, paraleloIdcurso) VALUES ('10:30', '12:00', '2017', '2B', '1A', True, 2);
INSERT INTO taller1.Estudiante(Rude) VALUES (123);
INSERT INTO taller1.matricula(Fecha, paraleloIdparalelo, estudianteCi, estado, paraleloIdcurso, EstudiantePersonaCi2) VALUES ('01/10/2015', '1B', 1, True, 1, 1);
INSERT INTO taller1.matricula(Fecha, paraleloIdparalelo, estudianteCi, estado, paraleloIdcurso, EstudiantePersonaCi2) VALUES ('10/12/2015', '2A', 2, True, 2, 1);
INSERT INTO taller1.Materia(Sigla, cursoIdcurso, Nombre, Gestion, Programa, Nrohoras, Estado) VALUES ('1', 2, 'Matematicas', 2015, '1', 40, true);
INSERT INTO taller1.notasest(Bimestre1, Bimestre2, Bimestre3, estudianteCi, valoracionIdvaloracion, gestion, estado, paraleloIdparalelo2, paraleloIdcurso2, MateriaSigla) VALUES (58, 90, 100, 1, 1, 2016, true, '1A', 1, '1');
INSERT INTO taller1.notasest(Bimestre1, Bimestre2, Bimestre3, estudianteCi, valoracionIdvaloracion, gestion, estado, paraleloIdparalelo2, paraleloIdcurso2, MateriaSigla) VALUES (90, 85, 89, 1, 1, 2016, true, '2C', 2, '1');
INSERT INTO taller1.notasest(Bimestre1, Bimestre2, Bimestre3, estudianteCi, valoracionIdvaloracion, gestion, estado, paraleloIdparalelo2, paraleloIdcurso2, MateriaSigla) VALUES (100, 100, 100, 1, 1, 2016, true, '3A', 3, '1');
INSERT INTO taller1.notasest(Bimestre1, Bimestre2, Bimestre3, estudianteCi, valoracionIdvaloracion, gestion, estado, paraleloIdparalelo2, paraleloIdcurso2, MateriaSigla) VALUES (90, 80, 75, 1, 1, 2016, true, '3A', 3, '1');
