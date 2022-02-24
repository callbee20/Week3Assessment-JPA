<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method= "post" action= "listNavigationServlet">
<table>
<c:forEach items= "${requestScope.allListeners}" var= "currentlist">
<tr>
	<td><input type= "radio" name= "id" value= "${currentlist.id}"></td>
	<td><h2>${currentlist.listName}</h2></td></tr>
	<tr><td colspan= "3">Entry Date: ${currentlist.enteredDate}</td></tr>
	<tr><td colspan= "3">Listener: ${currentlist.listener.listenerName}</td></tr>
	<c:forEach var= "listVal" items= "${currentlist.listOfBands}">
		<tr><td></td><td colspan= "3">${listVal.bandName}, ${listVal.genre}, ${listVal.favSong}
		</td>
		</tr>
	</c:forEach>
</c:forEach>
</table>
<input type= "submit" value= "edit" name= "doThisToList">
<input type= "submit" value= "delete" name= "doThisToList">
<input type= "submit" value= "add" name= "doThisToList">
</form>
<a href= "addItemsForListServlet">Create a new listener</a>
<a href= "start.html">Insert a new band</a>
</body>
</html>