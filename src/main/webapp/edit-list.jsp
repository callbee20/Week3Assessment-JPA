<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a list</title>
</head>
<body>
<form action= "editListenerDetailsServlet" method= "post">
<input type= "hidden" name= "id" value= "${listToEdit.id}">
List Name: <input type= "text" name= "listName" value= "${listToEdit.listName}"><br />
Entry Date: <input type= "text" name= "month" placeholder= "mm" size= "4" value= "${month}"> <input type= "text" name= "date" placeholder= "dd" size= "4" value= "${date}">, <input type= "text" name= "year" placeholder= "yyyy" size= "4" value= "${year}">
Listener Name: <input type= "text" name= "listenerName" value= "${listToEdit.listener.listenerName}"><br />

Available Bands:<br />
<select name= "allItemsToAdd" multiple size= "6">
<c:forEach items= "${requestScope.allBands}" var= "currentitem">
	<option value= "${currentitem.id}">${currentitem.bandName} | ${currentitem.genre} | ${currentitem.favSong}</option>
</c:forEach>
</select>
<br />
<input type= "submit" value= "Edit List and Add Bands">
</form>
<a href= "start.html">Go add new Bands instead.</a>
</body>
</html>