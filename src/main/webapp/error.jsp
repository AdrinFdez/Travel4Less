 <!DOCTYPE html> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Travel4Less</title>
    <link rel="stylesheet" href="css/estilos.css">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.7.2/js/all.js" integrity="sha384-0pzryjIRos8mFBWMzSSZApWtPl/5++eIfzYmTgBBmXYdhvxPc+XcFEk+zJwDgWbP" crossorigin="anonymous"></script>
    <!--<script src="js/header.js"></script>-->

  </head>

  <body>
  	<header>
  		<div class="wrapper">
  			<div class="logo">
          		Travel4Less
        	</div>
		
  			
  			<nav>
  				<a href="index.html">Home</a>
  				<a href="faqs.html">FAQs</a>
  				<a href="whoarewe.html">Who are we?</a>
  				<a href="api/docs/index.html">API</a>
  				<a href="https://app.swaggerhub.com/apis/Travel4less/Travel4less/2">API Swagger</a>
  			</nav>
  		</div>
		
	  <div align="center" style="color: red"> <c:out value="${message}"/></div>
        
  	</header>

    <h1 id="titlesgoogle">Ups! Something went wrong there.Try again clicking Home.</h1>

  </body>
</html>
