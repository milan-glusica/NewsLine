<%-- 
    Document   : Blic
    Created on : Feb 27, 2020, 4:44:55 PM
    Author     : milan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blic!!</title>
        <style type="text/css">
            body{color: red;
                 background: black;         
            }
            
        </style>
    
    </head>
    <body>
        <h1>BLIC!!!</h1>
        
        
        
        
         <a href="index.jsp">RETURN ON FIRST PAGE </a>
         
         <br>
         
         <br>
         <form action="Brubrike" method="post">
             <select name="rubrike" >
                 <option>Todays News</option>
                 <option>Politics</option>
                 <option>Society</option>
                 
             </select>
             <input type="submit" value="Pick" name="Pick"> 
            
         </form>
         <br>

    </body>
</html>
