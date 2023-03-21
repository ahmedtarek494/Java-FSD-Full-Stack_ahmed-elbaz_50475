<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Subject"%>
<%@page import="com.entity.Teachers"%>
<%@page import="com.entity.Class"%>
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
<title>Classes MasterList</title>
</head>
<body>
<form action="ClassController" method="post">

<label> Class Name </label>
<input type="text" name="name"><br/>

<label>Select Subject</label>        
        <select name="subject">
           <%
Object obj1 = request.getAttribute("listOfSubjects");
if(obj1!=null){
List<Subject> ll = (List)obj1;
Iterator<Subject> li = ll.iterator();
while(li.hasNext()){
	Subject p = li.next();
	%>
                <option value="<%=p.getId() %>"
                    >
                 <%=p.getName() %>
                </option>
	<% 
}
}
%>

        </select><br/>
        <label>Select Teacher</label>        
        <select name="teacher">
           <%
Object obj2 = request.getAttribute("listOfTeachers");
if(obj2!=null){
List<Teachers> ll = (List)obj2;
Iterator<Teachers> li = ll.iterator();
while(li.hasNext()){
	Teachers p = li.next();
	%>
                <option value="<%=p.getId() %>"
                    >
                 <%=p.getName() %>
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
    <th>Class ID</th>
    <th>Class Name</th>
    <th>Class Subject</th>
    <th>Class Teacher</th>
  </tr>
<%
Object obj = request.getAttribute("listOfClasses");
if(obj!=null){
List<Class> ll = (List)obj;
Iterator<Class> li = ll.iterator();
while(li.hasNext()){
	Class p = li.next();
	%>
	  <tr>
    <td><%=p.getId() %></td>
    <td><%=p.getName() %></td>
    <% if(p.getSubjectId()!=null){ %>
    <td><%=p.getSubjectId().getName() %></td>
    <%} else { %>
    <td>No Subject Assigned</td>
     <%}  %>
       <% if(p.getTeacherId()!=null){ %>
    <td><%=p.getTeacherId().getName() %></td>
    <%} else { %>
    <td>No Teacher Assigned</td>
     <%}  %>
   
  </tr>

	<% 
}
}
%>



</table>
</body>
</html>