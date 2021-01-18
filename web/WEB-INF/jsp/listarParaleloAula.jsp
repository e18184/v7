<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos del Paralelo</h1>
         <a href="index.htm"> MENU PRINCIPAL </a>
        <p><a href="insertarEstudiante.htm"> Insertar Estudiante </a></p>
        <table border="2">
            <thead>
                <tr>
                    <th>idparalelo</th>
                    
                    <th>nombre</th>
                    
                    <th> ABM </th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach  items="${datos}" var="dato">
                    <tr>
                        <td> <c:out value="${dato.idparalelo}"/></td>
                        
                        <td> <c:out value="${dato.nombre}"/></td>
                       
                        <td> <a href="<c:url value="adicionarparaleloaula.htm?idparalelo=${dato.idparalelo}"/>"> A </a> &NegativeMediumSpace;&NegativeMediumSpace; 
                                <a href="<c:url value="modificarparaleloaula.htm?idparalelo=${dato.idparalelo}"/>"> M </a> 
                        </td>
                    </c:forEach>
                    
            </tbody>
            
        </table>
        
    </body>
</html>