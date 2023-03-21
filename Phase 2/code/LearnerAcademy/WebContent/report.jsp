<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Subject"%>
<%@page import="com.entity.Teachers"%>
<%@page import="com.entity.Class"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
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
<title>Full Report</title>
</head>
<body>
<form action="ReportController" method="post">


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
<input type="submit" value="View">
<input type="reset" value="reset">
</form>
<br/>
<%
Object obj5 = request.getAttribute("selectedClass");
if(obj5!=null){
Class ll = (Class)obj5;
%>
<label> Class Name : <%=ll.getName() %> </label><br/>
<% if(ll.getSubjectId()!=null){ %>
<label> Subject : <%=ll.getSubjectId().getName() %> </label><br/>
<% } else { %>
<label> Subject : No subject assigned </label><br/>
<% }  %>
<% if(ll.getTeacherId()!=null){ %>
<label> Teacher : <%=ll.getTeacherId().getName() %> </label><br/>
<% } else { %>
<label> Subject : No Teacher assigned </label><br/>
<% } } %>
<label> List of Students :  </label>
<table>
  <tr>
    <th>Student ID</th>
    <th>Student Name</th>
    
  </tr>
<%
Object obj = request.getAttribute("listOfStudents");
if(obj!=null){
Set<Student> ll = (Set)obj;
Iterator<Student> li = ll.iterator();
while(li.hasNext()){
	Student p = li.next();
	%>
	  <tr>
    <td><%=p.getId() %></td>
    <td><%=p.getName() %></td>
  
 
   
  </tr>

	<% 
}
}
%>



</table>
</body>
</html>