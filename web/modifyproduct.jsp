<%-- 
    Document   : modifyproduct
    Created on : 8 Jan, 2019, 5:56:09 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
        <h1>MODIFY PRODUCT DETAILS</h1>
        <form action="modifier.jsp">
            
           

            <h4> Tell us which of the following field(s) are to be modified</h4><br>
            <input type="radio" name="name" >product-name <br>
            <input type="radio" name="desc" >product-description <br>
            <input type="radio" name="cat" >product-cat <br>
            <input type="radio" name="price" >product-price <br><br>
            
            <input type="submit" value="MODIFY">
        </form>
    </body>
</html>
