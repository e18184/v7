<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos del Paralelo</h1>
        
        <form:form method="post" action="adicionarparaleloaula.htm"  commandName="asigna">
             <p>
                 
                <form:label path="paraleloId">id del paralelo</form:label>
                
                <input type="text" name="paraleloId" value="<c:out value="${asigna.getParalelo().getIdparalelo()}"></c:out>" readonly="TRUE">  
                
                 
                
            </p>
            <p>
                <form:label path="aulaId">Aula a asignar</form:label> 
                <form:select path="aulaId"> 
                    <form:option value="0">Seleccione.....</form:option>
                    <form:options items="${aulaId}" />
                    
                </form:select>
            </p>
            <p>
                <form:label path="horaentrada">Hora entrada</form:label>
                <form:input path="horaentrada" />
            </p>
            <p>
                <form:label path="horasalida">Hora salida</form:label>
                <form:input path="horasalida" />
            </p>
            <p>
                <form:label path="anno">Año</form:label>
                <form:input path="anno" />
            </p>
            
          
          
            <hr>
            <form:button>Enviar</form:button> <a href="listarParaleloAula.htm"> Cancelar </a>
        </form:form>
        
    </body>
</html>