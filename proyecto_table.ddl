CREATE TABLE taller1.director (
  PersonaCi int4 NOT NULL, 
  Unidad    varchar(255), 
  Gestion   int4 NOT NULL UNIQUE);
CREATE TABLE taller1.ciclo (
  Idciclo           SERIAL NOT NULL, 
  Nombre            varchar(255), 
  Turno             varchar(255), 
  directorGestion   int4 NOT NULL, 
  DirectorPersonaCi int4 NOT NULL, 
  Estado            bool DEFAULT 'true' NOT NULL);
CREATE TABLE taller1.paralelo (
  Idparalelo varchar(255) NOT NULL, 
  Nombre     varchar(255), 
  estado     bool DEFAULT 'true', 
  Idcurso    int4 NOT NULL);
CREATE TABLE taller1.curso (
  Idcurso      SERIAL NOT NULL, 
  cicloIdciclo int4 NOT NULL, 
  Nombre       varchar(255) DEFAULT 'True', 
  estado       bool DEFAULT 'True');
CREATE TABLE taller1.notasest (
  Bimestre1              int4 NOT NULL, 
  Bimestre2              int4 NOT NULL, 
  Bimestre3              int4 NOT NULL, 
  estudianteCi           int4 NOT NULL, 
  valoracionIdvaloracion int4, 
  gestion                int4 NOT NULL, 
  estado                 bool, 
  paraleloIdparalelo2    varchar(255) NOT NULL, 
  paraleloIdcurso2       int4 NOT NULL, 
  MateriaSigla           varchar(255) NOT NULL);
COMMENT ON COLUMN taller1.notasest.Bimestre1 IS 'Notal final de un bismestre correspondiente a una determinada materia y un alumno';
COMMENT ON COLUMN taller1.notasest.gestion IS 'Las gestión en la cual lleva la materia un estudiante';
CREATE TABLE taller1.designa (
  Fechadesignacion       date NOT NULL, 
  paraleloIdparalelo     varchar(255) NOT NULL, 
  profesorCi             int4 NOT NULL, 
  paraleloIdcurso        int4 NOT NULL, 
  Nrodocumento           varchar(255), 
  Tipodesignacion        varchar(255), 
  estado                 bool DEFAULT 'true', 
  ProfesorCursoPersonaCi int4);
CREATE TABLE taller1.aula (
  Idaula varchar(10) NOT NULL, 
  Nombre varchar(255), 
  estado bool DEFAULT 'true');
CREATE TABLE taller1.asigna (
  Horaentrada        varchar(255) NOT NULL, 
  Horasalida         varchar(255) NOT NULL, 
  Anno               varchar(255) NOT NULL, 
  paraleloIdparalelo varchar(255) NOT NULL, 
  aulaIdaula         varchar(10) NOT NULL, 
  estado             bool, 
  paraleloIdcurso    int4 NOT NULL);
COMMENT ON COLUMN taller1.asigna.Horaentrada IS 'Especifica la hora de entrada a un aula';
CREATE TABLE taller1.valoracion (
  Idvaloracion            SERIAL NOT NULL, 
  Vcualitativa            varchar(255), 
  Vcualitativaabreviacion int4 NOT NULL, 
  Vcliminf                int4 NOT NULL, 
  Vclimsup                int4 NOT NULL, 
  estado                  bool DEFAULT 'true');
CREATE TABLE taller1.matricula (
  Fecha                date NOT NULL, 
  paraleloIdparalelo   varchar(255) NOT NULL, 
  estudianteCi         int4 NOT NULL, 
  estado               bool DEFAULT 'true', 
  paraleloIdcurso      int4 NOT NULL, 
  EstudiantePersonaCi2 int4);
CREATE TABLE taller1.DesignaEspecialidad (
  Fechadesignacion               date NOT NULL, 
  profesorCi                     int4 NOT NULL, 
  Nrodocumento                   varchar(255), 
  estado                         bool, 
  MateriaSigla                   varchar(255) NOT NULL, 
  ProfesorEspecialidadPersonaCi2 int4 NOT NULL);
CREATE TABLE taller1.Persona (
  Ci            SERIAL NOT NULL, 
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
  Discriminator varchar(255));
CREATE TABLE taller1.Estudiante (
  Rude      int4 NOT NULL, 
  PersonaCi int4 NOT NULL);
CREATE TABLE taller1.ProfesorCurso (
  Ciclo     int4, 
  PersonaCi int4 NOT NULL, 
  Gestion   int4 NOT NULL UNIQUE);
CREATE TABLE taller1.ProfesorEspecialidad (
  Especialidad varchar(255) NOT NULL, 
  PersonaCi    int4 NOT NULL, 
  Gestion      int4 NOT NULL UNIQUE);
CREATE TABLE taller1.Materia (
  Sigla        varchar(255) NOT NULL, 
  cursoIdcurso int4 NOT NULL, 
  Nombre       varchar(255), 
  Gestion      int4 NOT NULL, 
  Programa     varchar(255), 
  Nrohoras     int4 NOT NULL, 
  Estado       bool NOT NULL);
