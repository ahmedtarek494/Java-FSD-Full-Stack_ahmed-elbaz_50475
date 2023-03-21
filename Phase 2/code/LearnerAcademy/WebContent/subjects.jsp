<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Subject"%>
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
<form action="Subject" method="post">

<label>Subject Name </label>
<input type="text" name="name"><br/>

<label>Level</label>
<input type="text" name="level"><br/>
<br></br>
<input type="submit" value="Add">
<input type="reset" value="reset">
</form>
<br/>
<table>
  <tr>
    <th>ID</th>
    <th>Subject Name</th>
    <th>Subject Level</th>
  </tr>
<%
Object obj = request.getAttribute("listOfSubjects");
if(obj!=null){
List<Subject> ll = (List)obj;
Iterator<Subject> li = ll.iterator();
while(li.hasNext()){
	Subject p = li.next();
	%>
	  <tr>
    <td><%=p.getId() %></td>
    <td><%=p.getName() %></td>
    <td><%=p.getLevel() %></td>
  </tr>

	<% 
}
}
%>



</table>
</body>
</html>