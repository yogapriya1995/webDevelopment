<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="net.javaguides.login.database.*"%>
<%@page import="net.javaguides.login.bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<!DOCTYPE html>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
   <title>Student List</title>
   <style>
    table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
} 
</style>
  </head>
  <body>
  <%
  String name=request.getParameter("username");
  %>
      <h1>Welcome :<%= name%> </h1>
      <table border ="1" width="500" align="center"  border-collapse="collapse">
         <tr bgcolor="537AAF" >
         
          
          <th style="color: white;"><b>Department</b></th>
          <th style="color: white;"><b>pass %</b></th>
          <th style="color: white;"><b>Student ID</b></th>
          <th style="color: white;"><b>Student mark</b></th>
         </tr>
        <%-- Fetching the attributes of the request object
             which was previously set by the servlet 
              "StudentServlet.java"
        --%> 
        
        <%
        Map<String, List<Student>> map = 
        (Map<String, List<Student>>)request.getAttribute("datas");
        for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
        	 String key = entry.getKey();
        	 int size=entry.getValue().size();
        	 int passmark=0;
        	 for(Student st:entry.getValue()){
        		 int mark= st.getMark();
        		
        		 if(mark>=35){
        			 passmark=passmark+1; 
        		 }
        		 }
        	 double l=(double)passmark/size;
        	 double average=l*100;
        	 %>
        	  <tr>
        	  <td rowSpan=<%=size%>><%=key%></td>
        	  <td rowSpan=<%=size%>><%=average%></td>
        	 <%
        	 
        	 //List<Student> value = entry.getValue();
        	 for(Student s:entry.getValue()){
        		 String message= s.getName();
        %>
        	
            <td onClick="alert('<%=message%>')"> <%=s.getStudentId()%> </td>
            <td><%=s.getMark()%></td>
           
            </tr>
            <%}}%>
        
        </table> 
        <hr/>
    </body>
</html>