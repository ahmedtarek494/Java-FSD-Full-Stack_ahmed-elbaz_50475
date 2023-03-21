<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Teachers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="TeacherController" method="post">

<label>Teacher Name </label>
<input type="text" name="name"><br/>

<label>age</label>
<input type="number" name="age"><br/>
<br></br>
<input type="submit" value="Add">
<input type="reset" value="reset">
</form>
<br/>
<table>
  <tr>
    <th>ID</th>
    <th>Teacher Name</th>
    <th>Teacher age</th>
  </tr>
<%
Object obj = request.getAttribute("listOfTeachers");
if(obj!=null){
List<Teachers> ll = (List)obj;
Iterator<Teachers> li = ll.iterator();
while(li.hasNext()){
	Teachers p = li.next();
	%>
	  <tr>
    <td><%=p.getId() %></td>
    <td><%=p.getName() %></td>
    <td><%=p.getAge() %></td>

  </tr>

	<% 
}
}
%>



</table>
</body>
</html>