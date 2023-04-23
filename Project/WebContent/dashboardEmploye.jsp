<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Activate Individual Tabs in Bootstrap via jQuery</title>
<link rel="stylesheet" href="css/tableauDeBord.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
$(document).ready(function(){
    $("#myTab li:eq(0) a").tab("show"); // show second tab (0-indexed, like an array)
});
</script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<style>
.bordered {
	border: 1px solid #dee2e6;
	border-radius: .25rem;
	padding: 1rem;
	min-height: 75vh;
}
</style>

</head>
<body>
<div class="m-4">
    <ul class="nav nav-tabs" id="myTab">
        <li class="nav-item">
            <a href="#home" class="nav-link" data-bs-toggle="tab">Tableau de bord</a>
        </li>
        <li class="nav-item">
            <a href="#profile" class="nav-link" data-bs-toggle="tab">G&eacuterer mes cong&eacutes & mes absences</a>
        </li>
        <li class="nav-item">
            <a href="#messages" class="nav-link" data-bs-toggle="tab">Consulter mes demandes</a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane fade" id="home">
            <h4 class="mt-2">Nom: ${user.prenom} ${user.nom}</h4>
            <h4 class="mt-2">Site: ${user.site}</h4>
            <br>
            <h4 class="mt-2">Solde de cong&eacutes disponibles: ${user.soldeCP}</h4>
            <h4 class="mt-2">Droit annuel de CP: ${user.droitAnnuelCP}</h4>
            <br>
            <h4 class="mt-2">Compteur d'absences: ${user.compteurAbsence}</h4>
        </div>
        <div class="tab-pane fade" id="profile">
            <div class="position-relative mt-4">
                <h2 class="position-absolute top-0 start-4 fs-4 bg-white px-3"
                    style="transform: translateY(-50%);">Demandes de CP</h2>
                <div class="border p-4"
                    style="min-height: 300px; min-width: 300px;">
                    <!-- Add your content inside this div -->
                    <div class="row align-items-center mb-3 border p-3">
                                            <div class="col-4">
                                                <span class="fw-bold">Congé payé </span>
                                            </div>
                                            <div class="col-4">
                                                <span>Du <em>01/01/2023</em> au <em>10/01/2023</em></span>
                                            </div>
                                            <div class="col-4 d-flex justify-content-end">
                                            <p> Manager    </p>
                                                <button class="btn btn-success me-2">

                                                    <i class="bi bi-check"></i>
                                                </button>
                                            <p> RH    </p>
                                                <button class="btn btn-danger">

                                                    <i class="bi bi-x"></i>
                                                </button>
                                            </div>
                    </div>
                    <div class="row align-items-center mb-3 border p-3">
                                            <div class="col-4">
                                                <span class="fw-bold">Absence exceptionnelle </span>
                                            </div>
                                            <div class="col-4">
                                                <span>Du <em>01/02/2023</em> au <em>10/02/2023</em></span>
                                            </div>
                                            <div class="col-4 d-flex justify-content-end">
                                            <p> Manager    </p>
                                                <button class="btn btn-success me-2">

                                                    <i class="bi bi-check"></i>
                                                </button>
                                            <p> RH   </p>
                                                <button class="btn btn-success me-2">

                                                    <i class="bi bi-check"></i>
                                                </button>
                                            </div>
                    </div>
                    <div class="row align-items-center mb-3 border p-3">
                                            <div class="col-4">
                                                <span class="fw-bold">Formation externe </span>
                                            </div>
                                            <div class="col-4">
                                                <span>Du <em>20/03/2023</em> au <em>25/03/2023</em></span>
                                            </div>
                                            <div class="col-4 d-flex justify-content-end">
                                            <p> Manager    </p>
                                                <button class="btn btn-success me-2">

                                                    <i class="bi bi-check"></i>
                                                </button>
                                            <p> RH  </p>
                                                <button class="btn btn-danger">

                                                    <i class="bi bi-x"></i>
                                                </button>
                                            </div>
                                        </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="messages">
            <h4 class="mt-2">Messages tab content</h4>
            <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis.</p>
        </div>
    </div>
</div>
</body>
</html>