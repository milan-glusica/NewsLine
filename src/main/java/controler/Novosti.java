
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
public class Novosti {
    
    String news= "https://www.novosti.rs/rss/rss-Sve-vesti";
    String society="https://www.novosti.rs/rss/1-Sve-vesti";
    String politics="https://www.novosti.rs/rss/2-Sve%20vesti";
    String sports="https://www.novosti.rs/rss/11|12|30|14|13-Sve%20vesti";
    String fun="https://www.novosti.rs/rss/24|33|34|25|20|18|32|19-Sve%20vesti";
  String culture= "https://www.novosti.rs/rss/31|10-Sve%20vesti";

  
  public void novostiS(List<String> li,String url) throws ParserConfigurationException, SAXException, IOException{

       switch (url) {
           case "news":
               {
                   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse(news);
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
               } case "society":
               {
                   DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse(society);
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
                 
           case "politics":{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse(politics);
               
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
           case"culture":{
           
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                   DocumentBuilder document=factory.newDocumentBuilder();
                   Document root= document.parse(culture);
               
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


@RequestMapping("/Nrubrike")
String rubrike(@RequestParam String rubrike,Model model) throws ParserConfigurationException, SAXException, IOException{

    if(rubrike.equals("News")){
List<String> l = new ArrayList();
novostiS(l,"news");
model.addAttribute("n1", l);
}
else if(rubrike.equals("Society")){
List<String> l = new ArrayList();
novostiS(l,"society");
model.addAttribute("n2", l);
}
else if(rubrike.equals("Politics")){

List<String> l = new ArrayList();
novostiS(l,"politics");
model.addAttribute("n3", l);

}
else if(rubrike.equals("Sports")){
List<String> l = new ArrayList();
novostiS(l,"sports");
model.addAttribute("n4", l);

} else if(rubrike.equals("Fun")){

List<String> l = new ArrayList();
novostiS(l,"fun");
model.addAttribute("n5", l);

} else {
List<String> l = new ArrayList();
novostiS(l,"culture");
model.addAttribute("n6", l);



}


return"Rubrike";
}



}