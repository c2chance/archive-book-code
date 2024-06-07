package com.car.util.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * 创建DOM并生成XML文件.
 */
public class XmlCreater {
    private static final Logger LOG = LoggerFactory.getLogger(XmlCreater.class);
    private Document doc = null; // 新创建的DOM
    private String path = null; // 生成的XML文件绝对路径

    /**
     * 初始化.
     *
     * @param path 文件路径
     */
    public XmlCreater(String path) {
        this.path = path;
        init();
    }

    /**
     * 初始化函数.
     */
    private void init() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument(); // 新建DOM
        } catch (ParserConfigurationException e) {
            LOG.error("Parse DOM builder error:" + e);
        }
    }

    /**
     * 创建根结点，并返回.
     *
     * @param rootTagName 根节点
     * @return 根节点
     */
    public Element createRootElement(String rootTagName) {
        if (doc.getDocumentElement() == null) {
            LOG.debug("create root element '" + rootTagName + "' success.");
            Element root = doc.createElement(rootTagName);
            doc.appendChild(root);
            return root;
        }
        LOG.warn("this dom's root element is exist,create fail.");
        return doc.getDocumentElement();
    }

    /**
     * 在parent结点下增加子结点tagName.
     *
     * @param parent  父节点
     * @param tagName 子节点名称
     * @return 子节点
     */
    public Element createElement(Element parent, String tagName) {
        Document doc = parent.getOwnerDocument();
        Element child = doc.createElement(tagName);
        parent.appendChild(child);
        return child;
    }

    /**
     * 在parent结点下增加值为value的子结点tabName.
     *
     * @param parent  父节点
     * @param tagName 子节点名称
     * @param value   子节点内容
     * @return 子节点
     */
    public Element createElement(Element parent, String tagName, String value) {
        Document doc = parent.getOwnerDocument();
        Element child = doc.createElement(tagName);
        XmlOper.setElementValue(child, value);
        parent.appendChild(child);
        return child;
    }

    /**
     * 在parent结点下增加属性.
     *
     * @param parent    节点
     * @param attrName  属性名称
     * @param attrValue 属性值
     */
    public void createAttribute(Element parent, String attrName, String attrValue) {
        XmlOper.setElementAttr(parent, attrName, attrValue);
    }

    /**
     * 根据DOM生成XML文件.
     */
    public void buildXmlFile() {
        TransformerFactory tfactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = tfactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            LOG.debug("New DOMSource success.");
            StreamResult result = new StreamResult(new File(path));
            LOG.debug("New StreamResult success.");
            transformer.setOutputProperty("encoding", "UTF-8");
            transformer.transform(source, result);
            LOG.debug("Build XML File '" + path + "' success.");
        } catch (TransformerConfigurationException e) {
            LOG.error("Create Transformer error:", e);
        } catch (TransformerException e) {
            LOG.error("Transformer XML file error:", e);
        }
    }
}
