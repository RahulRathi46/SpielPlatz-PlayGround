<!DOCTYPE html>

<%--
This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>.</title>
    </head>
    <body>
        <% response.sendRedirect("index.html"); %>
    </body>
</html>