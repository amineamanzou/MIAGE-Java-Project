<%-- 
    Document   : deleteEmployee
    Created on : 6 oct. 2014, 10:44:49
    Author     : Amine Amanzou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/blocks/header.jsp" />
    </head>
    <body>
        <jsp:include page="/blocks/menuBar.jsp" />
        <div class="container">
            <div class="page-header">
                <h1>Portal for Employee Management <small>Delete </small></h1>
            </div>
            <div class="alert alert-danger">
                Cette action irréversible va également supprimer l'ensemble des statistiques associées !
            </div>
            <form class="form-horizontal" action="" method="post">
                <button type="submit" class="btn btn-danger">Confirmer la suppression</button>
                <a href="/admin/users/4" class="btn btn-default">Annuler</a>
            </form>
        </div>
    </body>
</html>
