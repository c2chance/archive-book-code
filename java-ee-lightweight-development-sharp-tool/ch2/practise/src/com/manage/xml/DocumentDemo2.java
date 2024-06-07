package com.manage.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;




public class DocumentDemo2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		// 获得documentBuilder
		DocumentBuilderFactory factory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// 加载XML文件
		
		   InputStream is = new FileInputStream("E:\\student.xml");
		   // 解析XML文档的输入流，得到一个Document，以后的处理都是对Document对象进行的
		   Document doc = builder.parse(is);
		
		
		//Document doc = builder.parse("E:\\student.xml");
		// 获取根节点
		Element root = doc.getDocumentElement();
		// 从XML根节点遍历
		NodeList books = root.getChildNodes();
		
		for(int i =0;i<books.getLength();i++){
			Node child = books.item(i);
			// 判断是否将空白区域当做字符元素
			if(child.getNodeType() == Node.ENTITY_REFERENCE_NODE){
				// 查找到一个book元素
				Element bookElement = (Element)child;
				Student b = new Student();
				// 使用元素属性作为bookId
				b.setName(bookElement.getAttribute("name"));
			}
			
			
		}
	}

}
