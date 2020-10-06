<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: LemonChiffon">
<h5>John McCool</h5>
<form action="http://localhost:8080/Hausarbeit/Parkhaus" method="post" id="nameform">
  <label for="fname">Tag:</label>
  <input type="text" id="fname=1" name="fname">
  <label for="lname">Uhrzeit:</label>
  <input type="text" id="lname" name="lname">


<input type="submit" form="nameform" value="Einplanen">
</form>
<h5>Susanne McDoof</h5>
<form action="http://localhost:8080/Hausarbeit/Parkhaus" method="post" id="nameform">
  <label for="fname">Tag:</label>
  <input type="text" id="fname=2" name="fname">
  <label for="lname">Uhrzeit:</label>
  <input type="text" id="lname" name="lname">


<input type="submit" form="nameform" value="Einplanen2">
</form>
</body>
</html>