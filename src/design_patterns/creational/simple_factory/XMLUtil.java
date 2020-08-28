package design_patterns.creational.simple_factory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLUtil {
    public static String getChartName(){
        try {
            DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document document;
            document=documentBuilder.parse(new File("src/design_patterns/creational/simple_factory/config.xml"));
            NodeList nl=document.getElementsByTagName("chartType");
            Node node=nl.item(0).getFirstChild();
            String name=node.getNodeValue().trim();
            return name;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
