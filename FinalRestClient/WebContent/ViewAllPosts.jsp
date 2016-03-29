<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"> Here are all the Posts </h2></br></br>
<%@page import= "java.io.StringReader,
ksu.chakravaram.client.modelclasses.Post,
ksu.chakravaram.client.modelclasses.ListPosts,
ksu.chakravaram.client.modelclasses.Profiles,


                 
 				ksu.chakravaram.client.DAO.DAO"
%>
 

<%
DAO dao=new DAO();
ListPosts p=dao.viewPosts();

for(Post pst :p.getPosts())
{
	Profiles pf= dao.viewProfile(pst.getProfile_id());
	int mid=pf.getProfile_id();
    
    
    %>
   
        <h1>From : <%=pf.getFirstname().toUpperCase()+" "+pf.getLastname().toUpperCase()%></br>
        <h1> Post: <%=pst.getPost()+ ""+mid %></h1>
                <h1>
                Time: <%=pst.getTime() %>
        <a href="ViewProfile.jsp?id=<%=mid%>"> click</a>
        
        
    
    <%
}

%>

</body>
</html>