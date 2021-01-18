ALTER TABLE taller1.designa DROP CONSTRAINT Designa;
ALTER TABLE taller1.designa DROP CONSTRAINT Designa2;
ALTER TABLE taller1.curso DROP CONSTRAINT FKcurso773804;
ALTER TABLE taller1.asigna DROP CONSTRAINT Asigna;
ALTER TABLE taller1.asigna DROP CONSTRAINT FKasigna176793;
ALTER TABLE taller1.notasest DROP CONSTRAINT FKnotasest55776;
ALTER TABLE taller1.matricula DROP CONSTRAINT Matricula;
ALTER TABLE taller1.matricula DROP CONSTRAINT Matricula2;
ALTER TABLE taller1.notasest DROP CONSTRAINT estudiante_notas;
ALTER TABLE taller1.paralelo DROP CONSTRAINT curso_paralelo;
ALTER TABLE taller1.ciclo DROP CONSTRAINT FKciclo263824;
ALTER TABLE taller1.Estudiante DROP CONSTRAINT FKEstudiante176645;
ALTER TABLE taller1.director DROP CONSTRAINT FKdirector553693;
ALTER TABLE taller1.ProfesorCurso DROP CONSTRAINT FKProfesorCu810949;
ALTER TABLE taller1.ProfesorEspecialidad DROP CONSTRAINT FKProfesorEs760316;
ALTER TABLE taller1.DesignaEspecialidad DROP CONSTRAINT DesignaEspecialidad;
ALTER TABLE taller1.DesignaEspecialidad DROP CONSTRAINT DesignaEspecialidad2;
ALTER TABLE taller1.notasest DROP CONSTRAINT Notasest;
ALTER TABLE taller1.notasest DROP CONSTRAINT Notasest2;
ALTER TABLE taller1.Materia DROP CONSTRAINT FKMateria662355;
DROP TABLE IF EXISTS taller1.director CASCADE;
DROP TABLE IF EXISTS taller1.ciclo CASCADE;
DROP TABLE IF EXISTS taller1.paralelo CASCADE;
DROP TABLE IF EXISTS taller1.curso CASCADE;
DROP TABLE IF EXISTS taller1.notasest CASCADE;
DROP TABLE IF EXISTS taller1.designa CASCADE;
DROP TABLE IF EXISTS taller1.aula CASCADE;
DROP TABLE IF EXISTS taller1.asigna CASCADE;
DROP TABLE IF EXISTS taller1.valoracion CASCADE;
DROP TABLE IF EXISTS taller1.matricula CASCADE;
DROP TABLE IF EXISTS taller1.DesignaEspecialidad CASCADE;
DROP TABLE IF EXISTS taller1.Persona CASCADE;
DROP TABLE IF EXISTS taller1.Estudiante CASCADE;
DROP TABLE IF EXISTS taller1.ProfesorCurso CASCADE;
DROP TABLE IF EXISTS taller1.ProfesorEspecialidad CASCADE;
DROP TABLE IF EXISTS taller1.Materia CASCADE;
CREATE TABLE taller1.director (
  PersonaCi int4 NOT NULL, 
  Unidad    varchar(255), 
  Gestion   int4 NOT NULL UNIQUE, 
  PRIMARY KEY (PersonaCi));
CREATE TABLE taller1.ciclo (
  Idciclo           int4 NOT NULL, 
  Nombre            varchar(255), 
  Turno             varchar(255), 
  Estado            bool DEFAULT 'true' NOT NULL, 
  directorGestion   int4 NOT NULL, 
  DirectorPersonaCi int4 NOT NULL, 
  directorPersonaCi int4, 
  PRIMARY KEY (Idciclo));
CREATE TABLE taller1.paralelo (
  Idparalelo varchar(255) NOT NULL, 
  Nombre     varchar(255), 
  estado     bool DEFAULT 'true', 
  Idcurso    int4 NOT NULL, 
  PRIMARY KEY (Idparalelo, 
  Idcurso));
CREATE TABLE taller1.curso (
  Idcurso      int4 NOT NULL, 
  Nombre       varchar(255) DEFAULT 'True', 
  estado       bool DEFAULT 'True', 
  cicloIdciclo int4 NOT NULL, 
  PRIMARY KEY (Idcurso));
CREATE TABLE taller1.notasest (
  Bimestre1              int4 NOT NULL, 
  Bimestre2              int4 NOT NULL, 
  Bimestre3              int4 NOT NULL, 
  gestion                int4 NOT NULL, 
  estado                 bool, 
  estudianteCi           int4 NOT NULL, 
  paraleloIdcurso        int4 NOT NULL, 
  MateriaSigla           varchar(255) NOT NULL, 
  paraleloIdparalelo     varchar(255) NOT NULL, 
  valoracionIdvaloracion int4, 
  PRIMARY KEY (gestion, 
  estudianteCi, 
  paraleloIdcurso, 
  MateriaSigla, 
  paraleloIdparalelo));
COMMENT ON COLUMN taller1.notasest.Bimestre1 IS 'Notal final de un bismestre correspondiente a una determinada materia y un alumno';
COMMENT ON COLUMN taller1.notasest.gestion IS 'Las gestión en la cual lleva la materia un estudiante';
CREATE TABLE taller1.designa (
  paraleloIdcurso    int4 NOT NULL CHECK(paraleloIdcurso), 
  paraleloIdparalelo varchar(255) NOT NULL, 
  profesorCi         int4 NOT NULL, 
  Fechadesignacion   date NOT NULL, 
  Nrodocumento       varchar(255), 
  Tipodesignacion    varchar(255), 
  estado             bool DEFAULT 'true', 
  PRIMARY KEY (paraleloIdcurso, 
  paraleloIdparalelo, 
  profesorCi, 
  Fechadesignacion));
CREATE TABLE taller1.aula (
  Idaula varchar(10) NOT NULL, 
  Nombre varchar(255), 
  estado bool DEFAULT 'true', 
  PRIMARY KEY (Idaula));
CREATE TABLE taller1.asigna (
  Horaentrada         varchar(255) NOT NULL, 
  Horasalida          varchar(255) NOT NULL, 
  Anno                varchar(255) NOT NULL, 
  estado              bool, 
  aulaIdaula          varchar(10) NOT NULL, 
  paraleloIdcurso     int4 NOT NULL, 
  paraleloIdparalelo2 varchar(255) NOT NULL, 
  PRIMARY KEY (Horaentrada, 
  Horasalida, 
  Anno, 
  aulaIdaula, 
  paraleloIdcurso, 
  paraleloIdparalelo2));
COMMENT ON COLUMN taller1.asigna.Horaentrada IS 'Especifica la hora de entrada a un aula';
CREATE TABLE taller1.valoracion (
  Idvaloracion            int4 NOT NULL, 
  Vcualitativa            varchar(255), 
  Vcualitativaabreviacion int4 NOT NULL, 
  Vcliminf                int4 NOT NULL, 
  Vclimsup                int4 NOT NULL, 
  estado                  bool DEFAULT 'true', 
  PRIMARY KEY (Idvaloracion));
CREATE TABLE taller1.matricula (
  Fecha                date NOT NULL, 
  estado               bool DEFAULT 'true', 
  paraleloIdcurso      int4 NOT NULL, 
  EstudiantePersonaCi2 int4 NOT NULL, 
  paraleloIdparalelo2  varchar(255) NOT NULL, 
  PRIMARY KEY (Fecha, 
  paraleloIdcurso, 
  EstudiantePersonaCi2, 
  paraleloIdparalelo2));
CREATE TABLE taller1.DesignaEspecialidad (
  Fechadesignacion               date NOT NULL, 
  Nrodocumento                   varchar(255), 
  estado                         bool, 
  profesorCi                     int4 NOT NULL, 
  MateriaSigla                   varchar(255) NOT NULL, 
  ProfesorEspecialidadPersonaCi2 int4 NOT NULL, 
  PRIMARY KEY (Fechadesignacion, 
  MateriaSigla, 
  ProfesorEspecialidadPersonaCi2));
CREATE TABLE taller1.Persona (
  Ci            int4 NOT NULL, 
  Nombre        varchar(255), 
  Ap            varchar(255), 
  Am            varchar(255), 
  Correo        varchar(255), 
  Telefono      varchar(255), 
  Usuario       varchar(255), 
  Contrasena    varchar(255), 
  Suspendido    int4, 
  Direccion     varchar(255), 
  Imagen        varchar(255), 
  Estado        bool, 
  Unidad        varchar(255), 
  Discriminator varchar(255), 
  PRIMARY KEY (Ci));
CREATE TABLE taller1.Estudiante (
  Rude      int4 NOT NULL, 
  PersonaCi int4 NOT NULL, 
  PRIMARY KEY (PersonaCi));
CREATE TABLE taller1.ProfesorCurso (
  Ciclo     int4, 
  PersonaCi int4 NOT NULL, 
  Gestion   int4 NOT NULL UNIQUE, 
  PRIMARY KEY (PersonaCi));
CREATE TABLE taller1.ProfesorEspecialidad (
  PersonaCi    int4 NOT NULL, 
  Especialidad varchar(255) NOT NULL, 
  Gestion      int4 NOT NULL UNIQUE, 
  PRIMARY KEY (PersonaCi));
CREATE TABLE taller1.Materia (
  Sigla        varchar(255) NOT NULL, 
  cursoIdcurso int4 NOT NULL, 
  Nombre       varchar(255), 
  Gestion      int4 NOT NULL, 
  Programa     varchar(255), 
  Nrohoras     int4 NOT NULL, 
  Estado       bool NOT NULL, 
  PRIMARY KEY (Sigla));
ALTER TABLE taller1.designa ADD CONSTRAINT Designa FOREIGN KEY (paraleloIdparalelo, paraleloIdcurso) REFERENCES taller1.paralelo (Idparalelo, Idcurso);
ALTER TABLE taller1.designa ADD CONSTRAINT Designa2 FOREIGN KEY (profesorCi) REFERENCES taller1.ProfesorCurso (PersonaCi);
ALTER TABLE taller1.curso ADD CONSTRAINT FKcurso773804 FOREIGN KEY (cicloIdciclo) REFERENCES taller1.ciclo (Idciclo);
ALTER TABLE taller1.asigna ADD CONSTRAINT Asigna FOREIGN KEY (paraleloIdparalelo2, paraleloIdcurso) REFERENCES taller1.paralelo (Idparalelo, Idcurso);
ALTER TABLE taller1.asigna ADD CONSTRAINT FKasigna176793 FOREIGN KEY (aulaIdaula) REFERENCES taller1.aula (Idaula);
ALTER TABLE taller1.notasest ADD CONSTRAINT FKnotasest55776 FOREIGN KEY (valoracionIdvaloracion) REFERENCES taller1.valoracion (Idvaloracion);
ALTER TABLE taller1.matricula ADD CONSTRAINT Matricula FOREIGN KEY (paraleloIdparalelo2, paraleloIdcurso) REFERENCES taller1.paralelo (Idparalelo, Idcurso);
ALTER TABLE taller1.matricula ADD CONSTRAINT Matricula2 FOREIGN KEY (EstudiantePersonaCi2) REFERENCES taller1.Estudiante (PersonaCi);
ALTER TABLE taller1.notasest ADD CONSTRAINT estudiante_notas FOREIGN KEY (estudianteCi) REFERENCES taller1.Estudiante (PersonaCi);
ALTER TABLE taller1.paralelo ADD CONSTRAINT curso_paralelo FOREIGN KEY (Idcurso) REFERENCES taller1.curso (Idcurso);
ALTER TABLE taller1.ciclo ADD CONSTRAINT FKciclo263824 FOREIGN KEY (directorPersonaCi) REFERENCES taller1.director (PersonaCi);
ALTER TABLE taller1.Estudiante ADD CONSTRAINT FKEstudiante176645 FOREIGN KEY (PersonaCi) REFERENCES taller1.Persona (Ci);
ALTER TABLE taller1.director ADD CONSTRAINT FKdirector553693 FOREIGN KEY (PersonaCi) REFERENCES taller1.Persona (Ci);
ALTER TABLE taller1.ProfesorCurso ADD CONSTRAINT FKProfesorCu810949 FOREIGN KEY (PersonaCi) REFERENCES taller1.Persona (Ci);
ALTER TABLE taller1.ProfesorEspecialidad ADD CONSTRAINT FKProfesorEs760316 FOREIGN KEY (PersonaCi) REFERENCES taller1.Persona (Ci);
ALTER TABLE taller1.DesignaEspecialidad ADD CONSTRAINT DesignaEspecialidad FOREIGN KEY (MateriaSigla) REFERENCES taller1.Materia (Sigla);
ALTER TABLE taller1.DesignaEspecialidad ADD CONSTRAINT DesignaEspecialidad2 FOREIGN KEY (ProfesorEspecialidadPersonaCi2) REFERENCES taller1.ProfesorEspecialidad (PersonaCi);
ALTER TABLE taller1.notasest ADD CONSTRAINT Notasest FOREIGN KEY (paraleloIdparalelo, paraleloIdcurso) REFERENCES taller1.paralelo (Idparalelo, Idcurso);
ALTER TABLE taller1.notasest ADD CONSTRAINT Notasest2 FOREIGN KEY (MateriaSigla) REFERENCES taller1.Materia (Sigla);
ALTER TABLE taller1.Materia ADD CONSTRAINT FKMateria662355 FOREIGN KEY (cursoIdcurso) REFERENCES taller1.curso (Idcurso);
INSERT INTO taller1.Persona(Ci, Nombre, Ap, Am, Correo, Telefono, Usuario, Contrasena, Suspendido, Direccion, Imagen, Estado, Unidad, Discriminator) VALUES (1, 'carlos', 'perez', 'perez', 'perez@hotmail.com', '59160257836', 'perez', 'perez', 0, 'av. montes', '', true, 'Maria Clara', 'director');
INSERT INTO taller1.Persona(Ci, Nombre, Ap, Am, Correo, Telefono, Usuario, Contrasena, Suspendido, Direccion, Imagen, Estado, Unidad, Discriminator) VALUES (2, 'mario', 'alfaro', 'quito', 'mario@hotmail.com', '4545646', 'alfaro', 'alfaro', 0, 'av. americas', '', true, 'Belgrano', 'profesorespecialidad');
INSERT INTO taller1.director(PersonaCi, Unidad, Gestion) VALUES (1, 'Carmen Mealla', 2016);
INSERT INTO taller1.director(PersonaCi, Unidad, Gestion) VALUES (2, 'Belgrano', 2017);
INSERT INTO taller1.ciclo(Idciclo, Nombre, Turno, Estado, directorGestion, DirectorPersonaCi, directorPersonaCi) VALUES (1, 'Primaria', 'Mañana', true, 2016, 1, null);
INSERT INTO taller1.ciclo(Idciclo, Nombre, Turno, Estado, directorGestion, DirectorPersonaCi, directorPersonaCi) VALUES (2, 'Secundaria', 'Tarde', true, 2017, 2, null);
INSERT INTO taller1.curso(Idcurso, Nombre, estado, cicloIdciclo) VALUES (1, '1ra SeccionSe', true, 1);
INSERT INTO taller1.curso(Idcurso, Nombre, estado, cicloIdciclo) VALUES (2, '2da Seccion', true, 1);
INSERT INTO taller1.curso(Idcurso, Nombre, estado, cicloIdciclo) VALUES (3, '1ero Primaria', true, 1);
INSERT INTO taller1.curso(Idcurso, Nombre, estado, cicloIdciclo) VALUES (4, '2do Primaria', true, 1);
INSERT INTO taller1.curso(Idcurso, Nombre, estado, cicloIdciclo) VALUES (5, '3do  Primaria', true, 2);
INSERT INTO taller1.curso(Idcurso, Nombre, estado, cicloIdciclo) VALUES (6, '4to Primaria', true, 2);
INSERT INTO taller1.curso(Idcurso, Nombre, estado, cicloIdciclo) VALUES (7, '5to Primaria', true, 2);
INSERT INTO taller1.curso(Idcurso, Nombre, estado, cicloIdciclo) VALUES (8, '6to Primaria', true, 2);
INSERT INTO taller1.valoracion(Idvaloracion, Vcualitativa, Vcualitativaabreviacion, Vcliminf, Vclimsup, estado) VALUES (1, 'Valoracion Cualitativa', 1, 1, 100, true);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('1A', 'Primero A', true, 1);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('1B', 'Primero B', true, 1);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('1C', 'Primero C', true, 1);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('2A', 'Segundo A', true, 1);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('2B', 'Segundo B', true, 2);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('2C', 'Segundo C', true, 3);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('3A', 'Tercero A', true, 3);
INSERT INTO taller1.paralelo(Idparalelo, Nombre, estado, Idcurso) VALUES ('3B', 'Tercero B', true, 3);
INSERT INTO taller1.aula(Idaula, Nombre, estado) VALUES ('1A', 'Aula 1A', true);
INSERT INTO taller1.aula(Idaula, Nombre, estado) VALUES ('1B', 'Aula 1B', true);
INSERT INTO taller1.asigna(Horaentrada, Horasalida, Anno, estado, aulaIdaula, paraleloIdcurso, paraleloIdparalelo2) VALUES ('10:30', '12:00', '2016', True, '1A', 1, null);
INSERT INTO taller1.asigna(Horaentrada, Horasalida, Anno, estado, aulaIdaula, paraleloIdcurso, paraleloIdparalelo2) VALUES ('8:30', '10:00', '2016', True, '1A', 2, null);
INSERT INTO taller1.asigna(Horaentrada, Horasalida, Anno, estado, aulaIdaula, paraleloIdcurso, paraleloIdparalelo2) VALUES ('10:30', '12:00', '2017', True, '1A', 2, null);
INSERT INTO taller1.Estudiante(Rude, PersonaCi) VALUES (123, 1);
INSERT INTO taller1.matricula(Fecha, estado, paraleloIdcurso, EstudiantePersonaCi2, paraleloIdparalelo2) VALUES ('01/10/2015', True, '1A', 1, 1);
INSERT INTO taller1.matricula(Fecha, estado, paraleloIdcurso, EstudiantePersonaCi2, paraleloIdparalelo2) VALUES ('10/12/2015', True, '1C', 1, 1);
INSERT INTO taller1.ProfesorCurso(Ciclo, PersonaCi, Gestion) VALUES (2, 1, 2016);
INSERT INTO taller1.Materia(Sigla, cursoIdcurso, Nombre, Gestion, Programa, Nrohoras, Estado) VALUES ('1', 2, 'Matematicas', null, null, null, null);
INSERT INTO taller1.notasest(Bimestre1, Bimestre2, Bimestre3, gestion, estado, estudianteCi, paraleloIdcurso, MateriaSigla, paraleloIdparalelo, valoracionIdvaloracion) VALUES (58, 90, 100, 2016, true, 1, '1A', '1', 1, 1);
