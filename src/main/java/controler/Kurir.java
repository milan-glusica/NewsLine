/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class Kurir {
    
    String todaysNews= "https://www.kurir.rs/rss/najnovije-vesti/";
    String sports= "https://www.kurir.rs/rss/sport/";
    String region = "https://www.kurir.rs/rss/region/";
    String fun= "https://www.kurir.rs/rss/zabava/";

 

   
   @RequestMapping("/rubrike")
String KRubrike(@RequestParam String rubrike,Model model) throws ParserConfigurationException, SAXException, IOException{

    if(rubrike.equals("Todays News")){
List<String> l = new ArrayList();
KurirS(l,"todaysNews");
model.addAttribute("k1", l);
}
    else if(rubrike.equals("Region")){
List<String> l = new ArrayList();
KurirS(l,"region");
model.addAttribute("k2", l);

}
    else if(rubrike.equals("Sports")){

List<String> l = new ArrayList();
KurirS(l,"sports");
model.addAttribute("k3", l);

}else {

List<String> l = new ArrayList();
KurirS(l,"fun");
model.addAttribute("k4", l);


}



return"Rubrike";
}

public void KurirS(List<String> li,String url) throws ParserConfigurationException, SAXException, IOException{

       switch (url) {
           case "todaysNews":
               {
                   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse(todaysNews);
                   Element el= root.getDocumentElement();
                   NodeList list= el.getElementsByTagName("item");
                   int item= list.getLength();
                   for (int i = 0; i <item ; i++) {
                       Element e = (Element)list.item(i);
                       String title= e.getElementsByTagName("title").item(0).getTextContent()+"<br>";
                       String description= e.getElementsByTagName("description").item(0).getTextContent()+"<br>";
                       String link ="<a href='"+e.getElementsByTagName("link").item(0).getTextContent()+"'>Vise detalja na linku</a><br>";
                       li.add(title);
                       li.add(link);
                       li.add(description);
                   } 
                   break;
               } case "region":
               {
                   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse(region);
                   Element el= root.getDocumentElement();
                   NodeList list= el.getElementsByTagName("item");
                   int item= list.getLength();
                   for (int i = 0; i <item ; i++) {
                       Element e = (Element)list.item(i);
                       String title= e.getElementsByTagName("title").item(0).getTextContent()+"<br>";
                       String description= e.getElementsByTagName("description").item(0).getTextContent()+"<br>";
                       String link ="<a href='"+e.getElementsByTagName("link").item(0).getTextContent()+"'>Vise detalja na linku</a><br>";
                       li.add(title);
                       li.add(link);
                       li.add(description);
                   } 
                   break;
               }
          
           case "sports":
               {
                   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse(sports);
               
                Element el= root.getDocumentElement();
                   NodeList list= el.getElementsByTagName("item");
                   int item= list.getLength();
                   for (int i = 0; i <item ; i++) {
                       Element e = (Element)list.item(i);
                       String title= e.getElementsByTagName("title").item(0).getTextContent()+"<br>";
                       String description= e.getElementsByTagName("description").item(0).getTextContent()+"<br>";
                       String link ="<a href='"+e.getElementsByTagName("link").item(0).getTextContent()+"'>Vise detalja na linku</a><br>";
                       li.add(title);
                       li.add(link);
                       li.add(description);
                   } 
               }
           case "fun":{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse(fun);
               
                Element el= root.getDocumentElement();
                   NodeList list= el.getElementsByTagName("item");
                   int item= list.getLength();
                   for (int i = 0; i <item ; i++) {
                       Element e = (Element)list.item(i);
                       String title= e.getElementsByTagName("title").item(0).getTextContent()+"<br>";
                       String description= e.getElementsByTagName("description").item(0).getTextContent()+"<br>";
                       String link ="<a href='"+e.getElementsByTagName("link").item(0).getTextContent()+"'>Vise detalja na linku</a><br>";
                       li.add(title);
                       li.add(link);
                       li.add(description);
                   } 
               
               }


}

}

}