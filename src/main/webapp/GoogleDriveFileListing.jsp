<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
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
		
  			
  			<nav style="padding-top: 50px;">
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

<div class="steps">
	<table class="steps">
		<tr>
			<td id="step">Skyscanner</td>
			<td id="step">- - - o - - -</td>
			<td id="step">Google Calendar</td>
			<td id="step">- - - o - - -</td>
			<td id="step">Google Places</td>
			<td id="step">- - - o - - -</td>
			<td id="step"><b>Google Drive</b></td>
		</tr>
	</table>
</div>

<div style="padding-top: 40px;"></div>

<div class="info">
	<div class="container">

		<h1 id="titlegoogle">Your files in Google Drive</h1>

    	<p class="message">${message}</p>
    	
    	<p id="btfinal">
    	    <a href="/googleDriveFileEdit.jsp" type="button" class="button">Save your trip info into a file!</a>
        	<button type="button" onClick="javascript:window.location.href = '/'" class="button">Back</button>
		</p>

    	<table id="files">
        	<tr>
            	<th>Name</th>
            	<th>Last modification date</th>
            	<th style="text-align:center">Edit</th>
            	<th style="text-align:center">Delete</th>
        	</tr>
        	<c:forEach items="${requestScope.files.items}" var="file">
            <tr>
                <td><c:out value="${file.title}"/></td>
                <td><c:out value="${file.modifiedDate}"/></td>
                <td>
                    <a href="/googleDriveFileUpdate?id=${file.id}"><img id="edit" src="./img/edit.png" width="30px"></a>
                </td>
                <td>
                    <a href="/googleDriveFileDelete?id=${file.id}"><img id="delete" src="./img/delete.png" width="24px"></a>
                </td>
            	</tr>
        	</c:forEach>			
    	</table>
    	<p id="btfinal">
    	    <a href="/googleDriveFileEdit.jsp" type="button" class="button">Save your trip info into a file!</a>
        	<button type="button" onClick="javascript:window.location.href = '/'" class="button">Back</button>
		</p>
	</div>
</div>
</body>
</html>