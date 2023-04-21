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
    $("#myTab li:eq(1) a").tab("show"); // show second tab (0-indexed, like an array)
});
</script>
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
            <h4 class="mt-2">Nom</h4>
            <p>Aliquip placeat salvia cillum iphone. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
            <h4 class="mt-2">Site</h4>
            <p>Aliquip placeat salvia cillum iphone. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
            <h4 class="mt-2">Solde de cong&eacutes disponibles</h4>
            <p>Aliquip placeat salvia cillum iphone. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
            <h4 class="mt-2">Jour(s) s&eacutelectionn&eacute(s)</h4>
            <p>Aliquip placeat salvia cillum iphone. Reprehenderit butcher retro keffiyeh dreamcatcher synth.</p>
        </div>
        <div class="tab-pane fade" id="profile">
            <h4 class="mt-2">Profile tab content</h4>
            <p>Vestibulum nec erat eu nulla rhoncus fringilla ut non neque. Vivamus nibh urna, ornare id gravida ut, mollis a magna. Aliquam porttitor condimentum nisi, eu viverra ipsum porta ut. Nam hendrerit bibendum turpis, sed molestie mi fermentum id. Aenean volutpat velit sem. Sed consequat ante in rutrum convallis. Nunc facilisis leo at faucibus adipiscing.</p>
        </div>
        <div class="tab-pane fade" id="messages">
            <h4 class="mt-2">Messages tab content</h4>
            <p>Donec vel placerat quam, ut euismod risus. Sed a mi suscipit, elementum sem a, hendrerit velit. Donec at erat magna. Sed dignissim orci nec eleifend egestas. Donec eget mi consequat massa vestibulum laoreet. Mauris et ultrices nulla, malesuada volutpat ante. Fusce ut orci lorem. Donec molestie libero in tempus imperdiet. Cum sociis natoque penatibus et magnis.</p>
        </div>
    </div>
</div>
</body>
</html>