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
		
  			
  			<nav>
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
				<td id="step"><b>Skyscanner</b></td>
				<td id="step">- - - o - - -</td>
				<td id="step">Google Calendar</td>
				<td id="step">- - - o - - -</td>
				<td id="step">Google Places</td>
				<td id="step">- - - o - - -</td>
				<td id="step">Google Drive</td>
			</tr>
		</table>
	</div>

	<div style="padding-top: 40px;"></div>
	
	<div class="info">
		<div class="container">
			<h1 id="titleSky">Best flight from <c:out value="${param.origin}"/> to to <c:out value="${param.destination}"/> on the <c:out value="${param.date}"/> </h1>
			<form id="FlightResultForm" action="/googleCalendarSkyscannerNew" method="post">
				<button type="submit" name="createCalendar" value="<c:out value="${param.destination}"/>" style="float: right;">Add a calendar to your collection!</button>
	    		<table id="flights">
	        		<tr>
	            		<th>#</th>
	            		<th>Direct</th>
	            		<th>Departure</th>
	            		<th>Price (EUR)</th>
	            		<!--<th style="text-align:center">Choose Flight</th>-->
	        		</tr>
	        		
	        		<c:forEach items="${requestScope.flights}" var="flight">
		            	<tr>
		            		<td>	<c:out value="${flight.quoteId}"/> </td>
		            		<td>	<c:choose>
		            					<c:when test="${flight.direct} == true">
		            					YES
		            					</c:when>
		            					<c:otherwise>
		            						NO
		            					</c:otherwise>
		            				</c:choose>
		            		</td>
		                	<td>	<c:out value="${flight.outboundLeg.departureDate}"/></td>
		                	<td>	<c:out value="${flight.minPrice}"/></td>
		               		 <!--<td>
		                		<button id="bookFlight" onclick=" window.open('<c:out value="${result.bookingLink}"/>', '_blank'); return false;" > Buy </button>
		                	</td> -->
	            		</tr>
	        		</c:forEach>			
	    		</table>
			</form>
		</div>
	</div>
	</body>
</html>