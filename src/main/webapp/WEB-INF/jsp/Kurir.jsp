<%-- 
    Document   : Kurir
    Created on : Feb 27, 2020, 5:24:47 PM
    Author     : milan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kurir</title>
        <style type="text/css">
    body{color:black ;background:gray; }        
        </style>
    
    </head>
    <body>
        <h1>Kurir!!!</h1>
        
        
        
        
        <br>
        <form action="rubrike" method="post">
            <select name="rubrike">
                <option>Todays News</option>
                <option>Sports</option>
                <option>Region</option>
                <option>Fun</option>
            </select>
            <input type="submit" name="Pick" value="Pick">
            
            
            
        </form>
    
    
    </body>
</html>
