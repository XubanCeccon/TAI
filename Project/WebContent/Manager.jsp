<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
            crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

    <link rel="stylesheet" href="css/tableauDeBord.css">
    <link rel="stylesheet" href="css/calendar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">


    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#myTab li:eq(1) a").tab("show"); // show second tab (0-indexed, like an array)
        });
    </script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</head>
<style>
    .bordered {
        border: 1px solid #dee2e6;
        border-radius: .25rem;
        padding: 1rem;
        min-height: 75vh;
    }
</style>

<body>

<header class="d-flex justify-content-between align-items-center px-3 py-2">
    <div class="d-flex align-items-center">
        <i class="bi bi-calendar-event fs-3 me-2"></i>
        <h3 class="mb-0">Time Manager</h3>
    </div>
    <button class="btn btn-outline-secondary">
        <i class="bi bi-person-circle"><a href="LoginController"></a></i>
    </button>
</header>

<hr>

<div class="container mt-3">
    <ul class="nav nav-tabs" id="tabs">
        <li class="nav-item"><a class="nav-link active" id="tab1-tab" data-bs-toggle="tab" href="#tab1">Tableau de bord</a></li>
        <li class="nav-item"><a class="nav-link" id="tab2-tab" data-bs-toggle="tab" href="#tab2">G&eacuterer mes cong&eacutes & mes absences</a></li>
        <li class="nav-item"><a class="nav-link" id="tab3-tab" data-bs-toggle="tab" href="#tab3">Consulter mes demandes</a></li>
    </ul>
    <div class="tab-content bordered" id="tabsContent">
        <div class="tab-pane fade show active" id="tab1" role="tabpanel"
             aria-labelledby="tab1-tab">
            <div class="half">
                <p>Tabulation non implémentée</p>
            </div>

            <div class="half">
<%--                <jsp:useBean id="user" scope="request" type="UserBeanModel"/>--%>
                <h4 class="mt-2">Nom: ${user.prenom} ${user.nom}</h4>
                <h4 class="mt-2">Site: ${user.site}</h4>
                <br>
                <h4 class="mt-2">Solde de cong&eacutes disponibles: ${user.soldeCP}</h4>
                <h4 class="mt-2">Droit annuel de CP: ${user.droitAnnuelCP}</h4>
                <br>
                <h4 class="mt-2">Compteur d'absences: ${user.compteurAbsence}</h4>
            </div>

        </div>
        <div class="tab-pane fade" id="tab2" role="tabpanel" aria-labelledby="tab2-tab">
            <div class="position-relative mt-4">
                <h2 class="position-absolute top-0 start-4 fs-4 bg-white px-3" style="transform: translateY(-50%);">Demandes de CP </h2>

                <div class="border p-4" style="min-height: 300px; min-width: 300px;">
                    ${cp_list}
                </div>
            </div>
        </div>

        <div class="tab-pane fade" id="tab3" role="tabpanel"aria-labelledby="tab3-tab">
            <div class="position-relative mt-4">
                <h2 class="position-absolute top-0 start-4 fs-4 bg-white px-3" style="transform: translateY(-50%);">Demandes d'absences </h2>

                <div class="border p-4" style="min-height: 300px; min-width: 300px;">
                    ${absence_list}
                </div>
            </div>
        </div>


    </div>

</div>
</body>
</html>
