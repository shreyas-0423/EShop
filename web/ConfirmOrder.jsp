<%-- 
    Document   : ConfirmOrder
    Created on : 5 Jan, 2019, 3:58:32 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
        <h1>Enter Your Details</h1>
        <form action="SaveAddress">
            <pre>
                Address <input type="text" name="uadd"/>
                state   <input type="text" name="ustate"/>
                pincode <input type="text" name="upin"/>
                Adress type <select>
                            <option>HOME</option>
                            <option>OFFICE</option>
                            </select>
                            <input type="submit" value="PROCEED TO CHECK-OUT"/>            

            </pre>
        </form>
       
        
    </body>
</html>
