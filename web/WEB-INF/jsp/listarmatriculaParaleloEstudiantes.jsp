<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Pantalla Principal Matricular un estudiante a un Paralelo</title>
    </head>
    <body>
        <h1>Pantalla Principal Matricular un estudiante a un Paralelo</h1>
        <p><a href="insertarEstudiante.htm"> Insertar Estudiante </a></p>
        <table border="2">
            <thead>
                <tr>
                    <th>ci</th>
                    <th>nombre</th>
                    <th>ap</th>
                    <th>am</th>
                    <th>correo</th>
                    <th>telefono</th>
                    <!--<th>usuario</th>
                    <th>contrasena</th>
                    <th>suspendido</th>
                    <th>direccion</th>
                    <th>imagen</th>-->
                    <th> ABM </th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach  items="${datos}" var="dato">
                    <tr>
                        <td> <c:out value="${dato.ci}"/></td>
                        <td> <c:out value="${dato.nombre}"/></td>
                        <td> <c:out value="${dato.ap}"/></td>
                        <td> <c:out value="${dato.am}"/></td>
                        <td> <c:out value="${dato.correo}"/></td>
                        <td> <c:out value="${dato.telefono}"/></td>
                        <c:choose>
                            <c:when test="${dato.nromatriculaciones>0}">
                                <td> <a href="<c:url value="modificarmatricula.htm?ci=${dato.ci}"/>"> M </a> &NegativeMediumSpace;&NegativeMediumSpace; 
                                <a href="<c:url value="adicionarmatricula.htm?ci=${dato.ci}"/>"> A </a> 
                                </td>
                            </c:when>    
                            <c:otherwise>
                                <td> &NegativeMediumSpace;&NegativeMediumSpace; 
                                <a href="<c:url value="adicionarmatricula.htm?ci=${dato.ci}"/>"> A </a> 
                                </td>
                        </c:otherwise>
                        </c:choose>

                       
                    </c:forEach>
                    
            </tbody>
            
        </table>
        
    </body>
</html>