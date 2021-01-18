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
        <h1>Datos del Profesor de Curso</h1>
        
        <a href="index.htm"> MENU PRINCIPAL </a>
        <p><a href="insertarEstudiante.htm"> Insertar Profesor de Curso </a></p>
        <table border="2">
            <thead>
                <tr>
                    <th>ci</th>
                    <th>unidad</th>
                    <th>area</th>
                     <th>nombre</th>
                    <th>ap</th>
                    <th>am</th>
                    <th>correo</th>
                    <th>telefono</th>
                    <th>usuario</th>
                    <th>contrasena</th>
                    <th>suspendido</th>
                    <th>direccion</th>
                    <th>imagen</th>
                     <th>ciclo</th>
                    <th> ABM </th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach  items="${datos}" var="dato">
                    <tr>
                        <td> <c:out value="${dato.ci}"/></td>
                        <td> <c:out value="${dato.unidad}"/></td>
                        <td> <c:out value="${dato.area}"/></td>
                        <td> <c:out value="${dato.nombre}"/></td>
                        <td> <c:out value="${dato.ap}"/></td>
                        <td> <c:out value="${dato.am}"/></td>
                        <td> <c:out value="${dato.correo}"/></td>
                        <td> <c:out value="${dato.telefono}"/></td>
                        <td> <c:out value="${dato.usuario}"/></td>
                        <td> <c:out value="${dato.contrasena}"/></td>
                        <td> <c:out value="${dato.suspendido}"/></td>
                        <td> <c:out value="${dato.direccion}"/></td>
                        <td> <c:out value="${dato.imagen}"/></td>
                        <td> <c:out value="${dato.ciclo}"/></td>
                        <td> <a href="<c:url value="modificarEstudiante.htm?ci=${dato.ci}"/>"> M </a> &NegativeMediumSpace;&NegativeMediumSpace; 
                                <a href="<c:url value="formEstudianteEliminar?ci=${dato.ci}"/>"> E </a> 
                        </td>
                    </c:forEach>
                    
            </tbody>
            
        </table>
        
    </body>
</html>