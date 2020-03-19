/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
public class Blic {
  // String todaysNews="https://www.blic.rs/rss/danasnje-vesti";
 
   Object map(String adress){
   Map ur= new HashMap();
   ur.put("politics","https://www.blic.rs/rss/Vesti/Politika00");
   ur.put("society","https://www.blic.rs/rss/Vesti/Drustvo");
   ur.put("todaysNews","https://www.blic.rs/rss/danasnje-vesti");
   
   
   if(adress.equals("politics"))return ur.get("politics");
   
   else if(adress.equals("todaysNews")) return ur.get("todaysNews");
 
   return ur.get("society");
   }
   
   String politika= "https://www.blic.rs/rss/Vesti/Politika";
   String drustvo= "https://www.blic.rs/rss/Vesti/Drustvo";
   String danasnjeVesti= "https://www.blic.rs/rss/danasnje-vesti";

   
 
public void blicS(List<String> li,String url) throws ParserConfigurationException, SAXException, IOException{

       switch (url) {
           case "politika":
               {
                   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse("https://www.blic.rs/rss/Vesti/Politika");
                   Element el= root.getDocumentElement();
                   NodeList list= el.getElementsByTagName("item");
                   int item= list.getLength();
                   for (int i = 0; i <item ; i++) {
                       Element e = (Element)list.item(i);
                       String title= e.getElementsByTagName("title").item(0).getTextContent()+"<br>";
                       String description= e.getElementsByTagName("content:encoded").item(0).getTextContent()+"<br>";
                       String link ="<a href='"+e.getElementsByTagName("link").item(0).getTextContent()+"'>Vise detalja na linku</a><br>";
                       li.add(title);
                       li.add(link);
                       li.add(description);
                   } 
                   break;
               } case "danasnjeVesti":
               {
                   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse("https://www.blic.rs/rss/danasnje-vesti");
                   Element el= root.getDocumentElement();
                   NodeList list= el.getElementsByTagName("item");
                   int item= list.getLength();
                   for (int i = 0; i <item ; i++) {
                       Element e = (Element)list.item(i);
                       String title= e.getElementsByTagName("title").item(0).getTextContent()+"<br>";
                       String description= e.getElementsByTagName("content:encoded").item(0).getTextContent()+"<br>";
                       String link ="<a href='"+e.getElementsByTagName("link").item(0).getTextContent()+"'>Vise detalja na linku</a><br>";
                       li.add(title);
                       li.add(link);
                       li.add(description);
                   } 
                   break;
               }
          
           case "drustvo":
               {
                   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse("https://www.blic.rs/rss/Vesti/Drustvo");
               
                Element el= root.getDocumentElement();
                   NodeList list= el.getElementsByTagName("item");
                   int item= list.getLength();
                   for (int i = 0; i <item ; i++) {
                       Element e = (Element)list.item(i);
                       String title= e.getElementsByTagName("title").item(0).getTextContent()+"<br>";
                       String description= e.getElementsByTagName("content:encoded").item(0).getTextContent()+"<br>";
                       String link ="<a href='"+e.getElementsByTagName("link").item(0).getTextContent()+"'>Vise detalja na linku</a><br>";
                       li.add(title);
                       li.add(link);
                       li.add(description);
                   } 
               }
                   
       }
               
               }
       
   @RequestMapping("/pick")  
 String proba(@RequestParam String novine,Model model) throws ParserConfigurationException, SAXException, IOException{
       switch (novine) {
           case "Blic":
               return "Blic";
           case "Kurir":
               return "Kurir";
           default:
               return "Novosti";
       }

 }
@RequestMapping("/Brubrike")
String rubrike(@RequestParam String rubrike,Model model) throws ParserConfigurationException, SAXException, IOException{

    if(rubrike.equals("Todays News")){
    List<String> l= new ArrayList();
    
    blicS(l,"danasnjeVesti");
    model.addAttribute("b1", l);
    }else if(rubrike.equals("Politics")){
    List<String> l= new ArrayList();
    
    blicS(l,"politika");
    model.addAttribute("b2", l);
    }else {
    List<String> l= new ArrayList();
    
    blicS(l,"drustvo");
    model.addAttribute("b3", l);
    
    }


return "Rubrike";
}



}