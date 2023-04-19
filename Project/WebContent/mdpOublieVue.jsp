<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">


</head>
<body>
	<div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
      <div class="col-md-4 border border-dark p-3 rounded">
      	<div class="text-center mt-3">
        	<h1 class="mb-4"><i class="bi bi-calendar-event"></i>   Time Manager</h1>
        </div>
        <form action="/ProgicielControleur" method="post">
          <div class="mb-3">
            <label for="email" class="form-label">Adresse email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="Saisir l'identifiant">
          </div>
              <button type="submit" class="btn btn-primary w-100">Se connecter</button>
          <br>
          <div class="text-center mt-3">
        	<a href="ProgicielVue.jsp">back</a>	
      	  </div>
        </form>
      </div>
    </div>
    
    <script src="path/to/bootstrap.min.js"></script>
</body>
</html>