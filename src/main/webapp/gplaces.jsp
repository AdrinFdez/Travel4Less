<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Travel4Less</title>
    <link rel="stylesheet" href="css/estilos.css">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.7.2/js/all.js" integrity="sha384-0pzryjIRos8mFBWMzSSZApWtPl/5++eIfzYmTgBBmXYdhvxPc+XcFEk+zJwDgWbP" crossorigin="anonymous"></script>
    <style> 
           	table {
			  border-style: hidden;
			}
			table tr {
			  border: 2px solid black;
			}
        </style> 
    <!--<script src="js/header.js"></script>-->
 </head>
<body>

<header>
  		<div class="wrapper">
  			<div class="logo">
          		Travel4Less
        	</div>
		
  			
  			<nav style="padding-top: 50px;">
  				<a href="index.html">Home</a>
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
  	
<div class="steps">
	<table class="steps">
		<tr>
			<td id="step">Skyscanner</td>
			<td id="step">- - - o - - -</td>
			<td id="step">Google Calendar</td>
			<td id="step">- - - o - - -</td>
			<td id="step"><b>Google Places</b></td>
			<td id="step">- - - o - - -</td>
			<td id="step">Google Drive</td>
		</tr>
	</table>
</div>

<div style="padding-top: 40px;"></div>

<div class="info">
	<div class="container">

		<!--<h1 id="titleSky">Flights from <c:out value="${originPlace}"/> to <c:out value="${destinationPlace}"/> </h1>-->
		<form id="FlightResultForm" action="/googleDrivePlacesNew" method="post">
		<!--<button type="submit" name="goToEnd" value="<c:out value="#"/>" style="float: right;">Add the info </button>-->
	    	<table id="places">
	        	<tr>
	            	<th>Name</th>
					<th>Open now?</th>
					<th style="text-align:center">Location</th>
					<th>Add</th>
	        	</tr>
	        	<c:forEach items="${requestScope.placeSearch}" var="placeSearch">
					<tr>
						<td>${placeSearch.name}</td>
						<td><c:choose>
							<c:when test="${placeSearch.openingHours.openNow  == 'true'}">
								OPEN						
							</c:when>
							<c:otherwise>
								NOT OPEN
							</c:otherwise>
						</c:choose></td>
						<td><p align="center"><iframe src="https://maps.google.com/maps?q=${placeSearch.geometry.location.lat},${placeSearch.geometry.location.lng}&hl=es;z=14&amp;output=embed" width="250" height="250"></iframe></p></td>
						<!--<td><button type="submit" name="infoPlace" value="<c:out value="${placeSearch.name}"/>">Add to your Drive!</button></td>-->
						<td><a type="button" href="/googleDrivePlacesNew?rest=${placeSearch.name}&address=${placeSearch.formattedAddress}">Add to your Drive!</a></td>
					</tr>
				</c:forEach>	
	    	</table>
		</form>
	</div>
</div>
</body>
</html>