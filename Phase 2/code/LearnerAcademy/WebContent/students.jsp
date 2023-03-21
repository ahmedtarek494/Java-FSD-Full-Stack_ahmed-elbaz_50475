<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Subject"%>
<%@page import="com.entity.Teachers"%>
<%@page import="com.entity.Class"%>
<%@page import="com.entity.Student"%>
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
<title>Students MasterList</title>
</head>
<body>
<form action="StudentController" method="post">

<label> Student Name </label>
<input type="text" name="name"><br/>
<label>Select Class</label>        
        <select name="class">
           <%
Object obj4 = request.getAttribute("listOfClasses");
if(obj4!=null){
List<Class> ll = (List)obj4;
Iterator<Class> li = ll.iterator();
while(li.hasNext()){
	Class p = li.next();
	%>
                <option value="<%=p.getId() %>"
                    >
          <%=p.getId() %> , <%=p.getName() %>
                </option>
	<% 
}
}
%>

        </select><br/>
      <br></br>
<input type="submit" value="Add">
<input type="reset" value="reset">
</form>
<br/>
<table>
  <tr>
    <th>Student ID</th>
    <th>Student Name</th>
    <th>Class Name</th>
  </tr>
<%
Object obj = request.getAttribute("listOfStudents");
if(obj!=null){
List<Student> ll = (List)obj;
Iterator<Student> li = ll.iterator();
while(li.hasNext()){
	Student p = li.next();
	%>
	  <tr>
    <td><%=p.getId() %></td>
    <td><%=p.getName() %></td>
    <% if(p.getClassId()!=null){ %>
    <td><%=p.getClassId().getId() %> ,<%=p.getClassId().getName() %></td>
    <%} else { %>
    <td>No Class Assigned</td>
     <%}  %>
 
   
  </tr>

	<% 
}
}
%>



</table>
</body>
</html>