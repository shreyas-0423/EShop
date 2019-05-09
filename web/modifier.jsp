<%@page  isThreadSafe="false" errorPage="myerrors.jsp" contentType="text/html" import="java.sql.*"%>

<%@include file="header.jsp" %>
<%
    
    
        String s1=request.getParameter("name");
        String s2=request.getParameter("desc");
        String s3=request.getParameter("cat");
        String s4=request.getParameter("price");
%>
<form action="ModifyProduct">
     Product Code <input type="text" name="pcode"/><br><br>
<% if(s1!=null) %>Product Name <input type="text" name="name"/><br><br>
<% if(s2!=null) %>Product DESC <input type="text" name="desc"/><br><br>
<% if(s3!=null) %>Product CAT <input type="text" name="cat"/><br><br>
<% if(s4!=null) %>Product PRICE <input type="text" name="price"/><br><br>
                    <input type="submit" value="MODIFY DETAILS">
</form>