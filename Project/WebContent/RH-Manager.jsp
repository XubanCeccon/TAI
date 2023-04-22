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
			<li class="nav-item"><a class="nav-link active" id="tab1-tab"
				data-bs-toggle="tab" href="#tab1">Calendrier</a></li>
			<li class="nav-item"><a class="nav-link" id="tab2-tab"
				data-bs-toggle="tab" href="#tab2">Demandes de CP</a></li>
			<li class="nav-item"><a class="nav-link" id="tab3-tab"
				data-bs-toggle="tab" href="#tab3">Absences exceptionnelles</a></li>
		</ul>
		<div class="tab-content bordered" id="tabsContent">
			<div class="tab-pane fade show active" id="tab1" role="tabpanel"
				aria-labelledby="tab1-tab">
				<div class="row">
					<div class="col-md-4">
						<p>Sélectionner un employé</p>
					</div>
					<div class="col-md-4">
						<select class="form-select" id="locationSelect" name="location">
							<option value="" selected>Choose a location</option>
							<option value="location1">Location 1</option>
							<option value="location2">Location 2</option>
							<option value="location3">Location 3</option>
						</select>
					</div>
					<div class="col-md-4">
						<select class="form-select" id="employeeSelect" name="employee">
							<option value="" selected>Choose an employee</option>
							<option value="employee1">Employee 1</option>
							<option value="employee2">Employee 2</option>
							<option value="employee3">Employee 3</option>
						</select>
					</div>
					<div class="mt-4">
						<div class="row mb-3">
							<div class="col-md-4">
								<strong>Nom de l'employé :</strong>
							</div>
							<div class="col-md-8">
								<!-- Employee Name -->
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-4">
								<strong>Site de l'employé :</strong>
							</div>
							<div class="col-md-8">
								<!-- Employee Site -->
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-4">
								<strong>Solde de jours de congé payés disponibles :</strong>
							</div>
							<div class="col-md-8">
								<!-- Available Paid Leave Balance -->
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-4">
								<strong>Nombre de jours de congé payé annuel :</strong>
							</div>
							<div class="col-md-8">
								<!-- Annual Paid Leave Days -->
							</div>
						</div>
					</div>

				</div>

			</div>
			<div class="tab-pane fade" id="tab2" role="tabpanel"
				aria-labelledby="tab2-tab">
				<div class="position-relative mt-4">
					<h2 class="position-absolute top-0 start-4 fs-4 bg-white px-3"
						style="transform: translateY(-50%);">Demandes de CP</h2>
					<div class="border p-4"
						style="min-height: 300px; min-width: 300px;">
						<!-- Add your content inside this div -->
						<div class="row align-items-center mb-3 border p-3">
							<div class="col-4">
								<span class="fw-bold">Nom de l'employé :</span>
							</div>
							<div class="col-4">
								<span>Date range: <em>01/01/2023</em> - <em>10/01/2023</em></span>
							</div>
							<div class="col-4 d-flex justify-content-end">
								<button class="btn btn-success me-2">
									<i class="bi bi-check"></i>
								</button>
								<button class="btn btn-danger">
									<i class="bi bi-x"></i>
								</button>
							</div>
						</div>

					</div>
				</div>
			</div>


			<div class="tab-pane fade" id="tab3" role="tabpanel"
				aria-labelledby="tab3-tab">
				<div class="d-flex flex-column flex-grow-1">
					<div class="position-relative mt-4">
						<h2 class="position-absolute top-0 start-4 fs-4 bg-white px-3"
							style="transform: translateY(-50%);">Absences
							exceptionnelles</h2>
						<div class="border p-4 pb-3 d-flex flex-column">
							<div class="row align-items-center mb-3">
								<div class="col-4">
									<span class="fw-bold">Nom de l'employé :</span>
								</div>
								<div class="col-4">
									<span>Date range: <em>01/01/2023</em> - <em>10/01/2023</em></span>
								</div>
								<div class="col-4 d-flex justify-content-end">
									<button class="btn btn-success me-2">
										<i class="bi bi-check"></i>
									</button>
									<button class="btn btn-danger">
										<i class="bi bi-x"></i>
									</button>
								</div>
							</div>
							<p class="mt-2">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit, sed do eiusmod tempor incididunt ut labore et
								dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
								exercitation ullamco laboris nisi ut aliquip ex ea commodo
								consequat. Duis aute irure dolor in reprehenderit in voluptate
								velit esse cillum dolore eu fugiat nulla pariatur.</p>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>
