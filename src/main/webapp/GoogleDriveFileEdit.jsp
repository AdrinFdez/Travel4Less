<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% String controller = "/googleDriveFileNew"; %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
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

<c:if test="${not empty file}">
    <% controller = "/googleDriveFileUpdate";%>
</c:if>

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

    <p class="message">${message}</p>

    <form action="<%= controller%>" method="post">
        <c:if test="${not empty file}">
            <input type="hidden" name="id" value="${file.id}">
        </c:if>
        <label for="title">File name:</label>
        <input type="text" name="title" id="title"
               <c:if test="${not empty file}">
                   disabled="true" 
                   value="${file.title}"
               </c:if>
               />
        <label id="content" for="content">Content:</label>
        <textarea id="content2" name="content">${content}</textarea>
		<br>
        <div class="bottom_links">
            <button id="submit" type="submit" class="button">Submit</button>
            <button id="back" type="button" onClick="javascript:window.location.href = '/googleDriveFileList'" class="button">Cancel</button>
        </div>
    </form>
</div>
</div>
</body>
</html>