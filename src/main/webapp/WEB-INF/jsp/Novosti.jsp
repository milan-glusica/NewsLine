<%-- 
    Document   : Novosti
    Created on : Feb 27, 2020, 5:25:05 PM
    Author     : milan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novosti</title>
        <style type="text/css">
            body{color: whitesmoke; background: red;}
        </style>
    
    </head>
    <body>
        <h1>Novosti!!!</h1>
   
        <form action="Nrubrike" method="post">
            <select name="rubrike">
                <option>News</option>
                <option>Society</option>
                <option>Politics</option>
                <option>Sports</option>
                <option>Fun</option>
                <option>Culture</option>
                
            </select>            
            <input type="submit" name="Submit" value="Pick">
            
            
            
        </form>
    
    
    
    
    
    </body>
</html>
