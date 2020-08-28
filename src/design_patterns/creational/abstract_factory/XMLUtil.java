package design_patterns.creational.abstract_factory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class XMLUtil {
    public static Object getBean(){

        try {
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document document;
            document=db.parse(new File("src/design_patterns/creational/abstract_factory/config.xml"));
            NodeList nl=document.getElementsByTagName("className");
            System.out.println(nl.toString());
            Node node=nl.item(0).getFirstChild();
            System.out.println(node.toString());
            String cName=node.getNodeValue();

            Class c=Class.forName(cName);
            Object obj=c.getDeclaredConstructor().newInstance();
            return obj;



        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
