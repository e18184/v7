ALTER TABLE taller1.director ADD PRIMARY KEY (PersonaCi);
ALTER TABLE taller1.ciclo ADD PRIMARY KEY (Idciclo);
ALTER TABLE taller1.paralelo ADD PRIMARY KEY (Idparalelo, Idcurso);
ALTER TABLE taller1.curso ADD PRIMARY KEY (Idcurso);
ALTER TABLE taller1.notasest ADD PRIMARY KEY (estudianteCi, gestion, paraleloIdparalelo2, paraleloIdcurso2, MateriaSigla);
ALTER TABLE taller1.designa ADD PRIMARY KEY (Fechadesignacion, paraleloIdparalelo, profesorCi, paraleloIdcurso);
ALTER TABLE taller1.aula ADD PRIMARY KEY (Idaula);
ALTER TABLE taller1.asigna ADD PRIMARY KEY (Horaentrada, Horasalida, Anno, paraleloIdparalelo, aulaIdaula, paraleloIdcurso);
ALTER TABLE taller1.valoracion ADD PRIMARY KEY (Idvaloracion);
ALTER TABLE taller1.matricula ADD PRIMARY KEY (Fecha, paraleloIdparalelo, estudianteCi, paraleloIdcurso);
ALTER TABLE taller1.DesignaEspecialidad ADD PRIMARY KEY (Fechadesignacion, profesorCi);
ALTER TABLE taller1.Persona ADD PRIMARY KEY (Ci);
ALTER TABLE taller1.Estudiante ADD PRIMARY KEY (PersonaCi);
ALTER TABLE taller1.ProfesorCurso ADD PRIMARY KEY (PersonaCi);
ALTER TABLE taller1.ProfesorEspecialidad ADD PRIMARY KEY (PersonaCi);
ALTER TABLE taller1.Materia ADD PRIMARY KEY (Sigla);
