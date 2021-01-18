<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<c:url value="/listaEstudiantes.htm" />">Listado de productos</a>
        <h1>Resultados de formulario</h1>
        <ul>
            <li>Ci: <c:out value="${ci}"/> </li>
            <li>Rude : <c:out value="${rude}" /></li>
            <li>Nombre : <c:out value="${nombre}" /></li>
            <li>Apellido Paterno : <c:out value="${ap}" /></li>
            <li>Apellido Materno : <c:out value="${am}" /></li>
            <li>Correo : <c:out value="${correo}" /></li>
            <li>Telefono : <c:out value="${telefono}" /></li>
            <li>Usuario : <c:out value="${usuario}" /></li>
            <li>Contraseña : <c:out value="${contrasena}" /></li>
            <li>Suspendido : <c:out value="${suspendido}" /></li>
            <li>Direccion : <c:out value="${direccion}" /></li>
            <li>Imagen : <c:out value="${imagen}" /></li>
        </ul>
    </body>
</html>
