package Parsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class xmlParsing {
    public final static String rootPath = "resources";

    public static void main(String args[]) {
        System.out.println("hello");
        doParsingDepth1();
        doParsingDepth2();
    }

    public static void doParsingDepth1() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(rootPath + "/xmlFiles/depth1.xml");

            Element root = document.getDocumentElement();
            System.out.println("root : " + root);

            Node firstNode = root.getFirstChild();
            System.out.println("first node : " + firstNode);

            Node data = firstNode.getNextSibling();
            System.out.println("first data : " + data);

            NodeList recordList = data.getChildNodes();
            for (int i = 0; i < recordList.getLength(); i++) {
                Node item = recordList.item(i);

                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(item.getNodeName());
                    System.out.println(item.getTextContent());
                } else {
                    System.out.println("공백");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doParsingDepth2() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(rootPath + "/xmlFiles/depth2.xml");

            Element root = document.getDocumentElement();
            System.out.println("root : " + root);
        } catch (Exception e) {

        }
    }
}
