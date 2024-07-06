<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
 <meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initialscale=1.0">
 <link rel="stylesheet"
href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
 <title>Página de Error</title>
 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
 <section class="container">
 <div class="alert alert-warning display-3 alert-heading" role="alert">
  Error!!!
</div>
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Espera un momento!</h4>
  <p>Ha ocurrido un error, no te preocupes, todo se puede solucionar!</p>
  <hr>
  <p class="mb-0display-6">Verifica datos o metodos y vuelve a intentar</p>
</div>

 
 <a href="/${pageContext.request.contextPath}"> <button type="submit" class="btn btn-secondary"><i class="fa-solid fa-floppy-disk"></i> Regresar</button></a>
 </section>
 
 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>

</html>