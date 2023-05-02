<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RH Calendrier</title>
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

    <link rel="stylesheet" href="css/tableauDeBord.css">
    <link rel="stylesheet" href="css/calendar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">


    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#myTab li:eq(0) a").tab("show"); // show second tab (0-indexed, like an array)
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

<header
        class="d-flex justify-content-between align-items-center px-3 py-2">
    <div class="d-flex align-items-center">
        <i class="bi bi-calendar-event fs-3 me-2"></i>
        <h3 class="mb-0">Time Manager</h3>
    </div>
    <button class="btn btn-outline-secondary">
        <i class="bi bi-person-circle"></i>
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
                <p>Ici, un calendrier récapitulant les jours posés.</p>
            </div>

            <div class="half">
                <h4 class="mt-2">Nom: ${user.prenom} ${user.nom}</h4>
                <h4 class="mt-2">Site: ${user.site}</h4>
                <br>
                <h4 class="mt-2">Solde de cong&eacutes disponibles: ${user.soldeCP}</h4>
                <h4 class="mt-2">Droit annuel de CP: ${user.droitAnnuelCP}</h4>
                <br>
                <h4 class="mt-2">Compteur d'absences: ${user.compteurAbsence}</h4>
            </div>

        </div>
        <div class="tab-pane fade" id="tab2" role="tabpanel"
             aria-labelledby="tab2-tab">
            <div class="half">
                <div class="calendar">
                    <div class="calendar-header">
                        <span class="month-picker" id="month-picker">February</span>
                        <div class="year-picker">
                <span class="year-change" id="prev-year">
                    <pre><</pre>
                </span>
                            <span id="year">2021</span>
                            <span class="year-change" id="next-year">
                    <pre>></pre>
                </span>
                        </div>
                    </div>
                    <div class="calendar-body">
                        <div class="calendar-week-day">
                            <div>Sun</div>
                            <div>Mon</div>
                            <div>Tue</div>
                            <div>Wed</div>
                            <div>Thu</div>
                            <div>Fri</div>
                            <div>Sat</div>
                        </div>
                        <div class="calendar-days"></div>
                        <div class="calendar-footer">
                            <button id="clear-selection-btn">Effacez la sélection</button>
                        </div>
                    </div>
                    <div class="month-list"></div>
                </div>
                <script src="js/calendar.js"></script>
            </div>

            <div class="half">
                <h4 class="mt-2">Nom: ${user.prenom} ${user.nom}</h4>
                <h4 class="mt-2">Site: ${user.site}</h4>
                <br>
                <h4 class="mt-2">Solde de cong&eacutes disponibles: ${user.soldeCP}</h4>
                <div class="dropdown" id="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Type de demande
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#" data-value="Congé payé">Congé payé</a></li>
                        <li><a class="dropdown-item" href="#" data-value="Absence exceptionnelle">Absence exceptionnelle</a></li>
                        <li><a class="dropdown-item" href="#" data-value="Autre">Autre</a></li>
                    </ul>
                </div>

                <div id="clicked-day"></div>
                <div class="mt-3">
                    <textarea class="form-control" id="textbox" rows="5" cols="50" placeholder="Justification de l'absence"></textarea>
                    <button type="button" class="btn btn-primary mt-3" id="submit-button">Envoyer la demande</button>
                </div>

                <script src="js/dpdownsubmit.js"></script>
                <script src="js/calendar.js"></script>


                <p id="output"></p>
                <script src="button.js"></script>


            </div>

        </div>


        <div class="tab-pane fade" id="tab3" role="tabpanel"
             aria-labelledby="tab3-tab">
            <div class="position-relative mt-4">
                <h2 class="position-absolute top-0 start-4 fs-4 bg-white px-3"
                    style="transform: translateY(-50%);">Demandes de CP</h2>

                <div class="border p-4"
                     style="min-height: 300px; min-width: 300px;">
                    <div class="row align-items-center mb-3 border p-3">
                        <div id="selected-days-list"></div>
                    </div>

                </div>
            </div>
        </div>


    </div>

</div>
</body>
</html>
