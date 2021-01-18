<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos del Estudiante</h1>
        
        <form:form method="post" action="matricularestudiante.htm"  commandName="matricula">
             <p>
                 
                <form:label path="estudianteId">Ci del Estudiante</form:label>
                <form:input path="estudianteId" value="${estudianteId}"   /> 
                
            </p>
            <p>
                <form:label path="paraleloId">Paralelo a Matricular</form:label> 
                <form:select path="paraleloId"> 
                    <form:option value="0">Seleccione.....</form:option>
                    <form:options items="${paraleloId}" />
                </form:select>
            </p>
            <p>
                <form:label path="fecha">Fecha Matriculacion</form:label>
                <form:input path="fecha" />
            </p>
            
          
          
            <hr>
            <form:button>Enviar</form:button> <a href="listarmatriculaParaleloEstudiantes.htm"> Cancelar </a>
        </form:form>
        
    </body>
</html>