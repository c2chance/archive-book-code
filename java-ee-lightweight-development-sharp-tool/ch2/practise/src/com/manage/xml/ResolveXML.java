package com.manage.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ResolveXML {
	public static void readXMLDOM() {
		try {
			// 得到DOM解析器的实例
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			// 从工厂获得DOM解析器
			// 使用静态方法newDocumentBuilder得到DOM解析器
			DocumentBuilder builder = factory.newDocumentBuilder();
			// 读取XML文档并且转换为输入流
			InputStream is = new FileInputStream(
					"E:\\manage\\practise\\src\\com\\manage\\xml\\student3.xml");
			// 解析XML文档的输入流得到Document
			Document doc = builder.parse(is);
			doc.normalize();
			// 得到XML文档的根节点
			Element root = doc.getDocumentElement();
			// 显示根节点名称
			System.out.println(root.getNodeName());
			// 得到节点的子节点
			NodeList nodeList = doc.getElementsByTagName("学生");
			if (nodeList != null) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						// 循环输出节点
						System.out.println("姓名："
								+ doc.getElementsByTagName("姓名").item(i)
										.getFirstChild().getNodeValue());
						System.out.println("性别："
								+ node.getAttributes().getNamedItem("性别")
										.getNodeValue());
						System.out.println("年龄："
								+ doc.getElementsByTagName("年龄").item(i)
										.getFirstChild().getNodeValue());
						System.out.println("电话："
								+ doc.getElementsByTagName("电话").item(i)
										.getFirstChild().getNodeValue());
					}
				}
			}
			is.close();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ResolveXML.readXMLDOM();
	}
}
