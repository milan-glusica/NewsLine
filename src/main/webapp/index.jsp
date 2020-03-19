<%-- 
    Document   : index
    Created on : Feb 27, 2020, 3:39:56 PM
    Author     : milan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NEWSLINE</title>
    
        <style type="text/css">
            body{
                color: black;
                background: blueviolet;
            }
            
        </style>
    </head>
    
    <body>
        <h1>NEWSLINE!!!</h1>
    
        <p>APLICATION FOR READING NEWS!!</p>
       
        
        <div>
        <form action="pick" method="post">
            <select name="novine">
                <option>Blic</option>   
                
                <option>Kurir</option>   
                <option>Novosti</option>   
               
            </select> 
           
          <input type="submit" name="Pick" value="Pick">   
        </form>
    
       </div>
        
        
    </body>
</html>
