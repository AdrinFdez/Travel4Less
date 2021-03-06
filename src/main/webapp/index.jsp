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
  				<a href="index.jsp">Home</a>
  				<a href="faqs.html">FAQs</a>
  				<a href="whoarewe.html">Who are we?</a>
  				<a href="api/docs/index.html">API</a>
  				<a href="https://app.swaggerhub.com/apis/Travel4less/Travel4less/2">API Swagger</a>
  			</nav>
  		</div>

      <div class="title" style="font-size: 25px; color: #f2f2f2; padding-left: 70px;">
       An amazing experience is waiting for you!
      </div>
        
  	</header>

    
  	
    <div class="info">
      	<form id="searchForm" action="/SkyscannerSearch" method="post" class="sc">
	      <div>
	        <label>Start point </label>
	        <input class="input" type="text" name="origin" placeholder="Origin" required/>
	      </div>
	      <div>
	        <label>Where do you want to go?</label>
	        <input class="input" type="text" name="destination" placeholder="Destination" required>
	      </div>
	      <div>
	        <label>When would you like to go?</label>
	        <input class="input" type="date" name="date" placeholder="  dd / MM /yyyy " id="date" required>
	      </div>
	      <div><button type="submit">Go!</button></div>
   	  	</form>
   	</div>
    <br>
    

    <div class="wrapper2">
      <div class="content">
        <p>Do you want to travel but your wallet is nearly empty? <br>
        Want a way to find the perfect destination and flight that fits your budget?<br>
        If your answer to any of these questions is “yes”: that’s your place. In Travel4Less you’ll find the best way to travel with the best price and fitting your budget. <br>
        Do you dare to find the best price?</p><br>
      </div>
      <div class="img">
        <img src="img/travel4less3.png">
      </div>
    </div>
    <div class="info">
    	<c:forEach items="${requestScope.stats}" var="stat">
    		<p>Confirmed: <c:out value="${stat.confirmed}"/> from which: </p>
    		<p>Recovered: <c:out value="${stat.recovered}"/></p>
    		<p>Deaths: <c:out value="${stat.deaths}"/></p>
    		<p>Province: <c:out value="${stat.province}"/></p>
    		<p>Last Update: <c:out value="${stat.lastUpdate}"/></p>
    		<br>
		            
	    </c:forEach>
    	
    	
    </div>

  </body>
</html>
