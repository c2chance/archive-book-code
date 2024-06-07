package com.car.util.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * 用于操作ＸＭＬ文件，包括查找、新增、删除、修改结点.
 */
public final class XmlOper {
    private XmlOper() {
    }

    private static Logger logger = LoggerFactory.getLogger(XmlOper.class);

    /**
     * 获取父结点parent的所有子结点.
     *
     * @param parent 父节点
     * @return 所有的子节点
     */
    public static NodeList getNodeList(Element parent) {
        return parent.getChildNodes();
    }

    /**
     * 在父结点中查询指定名称的结点集.
     *
     * @param parent 父节点
     * @param name   待查询的节点名称
     * @return 符合条件的节点集
     */
    public static Element[] getElementsByName(Element parent, String name) {
        ArrayList<Node> resList = new ArrayList<Node>();
        NodeList nl = getNodeList(parent);
        for (int i = 0; i < nl.getLength(); i++) {
            Node nd = nl.item(i);
            if (nd.getNodeName().equals(name)) {
                resList.add(nd);
            }
        }
        Element[] res = new Element[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[0] = (Element) resList.get(i);
        }
        logger.debug(parent.getNodeName() + "'s children of " + name + "'s num:" + res.length);
        return res;
    }

    /**
     * 获取指定Element的名称.
     *
     * @param element 指定的element
     * @return 节点名称
     */
    public static String getElementName(Element element) {
        return element.getNodeName();
    }

    /**
     * 获取指定Element的值.
     *
     * @param element 指定的节点
     * @return 节点值
     */
    public static String getElementValue(Element element) {
        NodeList nl = element.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            if (nl.item(i).getNodeType() == Node.TEXT_NODE) {// 是一个Text Node
                logger.debug(element.getNodeName() + " has a Text Node.");
                return element.getFirstChild().getNodeValue();
            }
        }
        logger.error(element.getNodeName() + " hasn't a Text Node.");
        return null;
    }

    /**
     * 获取指定Element的属性attr的值.
     *
     * @param element 指定的节点
     * @param attr    节点属性
     * @return 节点属性值
     */
    public static String getElementAttr(Element element, String attr) {
        return element.getAttribute(attr);
    }

    /**
     * 设置指定Element的值.
     *
     * @param element 指定的节点
     * @param val     制定值
     */
    public static void setElementValue(Element element, String val) {
        Node node = element.getOwnerDocument().createTextNode(val);
        NodeList nl = element.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node nd = nl.item(i);
            if (nd.getNodeType() == Node.TEXT_NODE) { // 是一个Text Node
                nd.setNodeValue(val);
                logger.debug("modify " + element.getNodeName() + "'s node value succe.");
                return;
            }
        }
        logger.debug("new " + element.getNodeName() + "'s node value succe.");
        element.appendChild(node);
    }

    /**
     * 设置结点Element的属性.
     *
     * @param element 指定的节点
     * @param attr    属性名称
     * @param attrVal 属性值
     */
    public static void setElementAttr(Element element, String attr, String attrVal) {
        element.setAttribute(attr, attrVal);
    }

    /**
     * 在parent下增加结点child.
     *
     * @param parent 父节点
     * @param child  待增加的节点
     */
    public static void addElement(Element parent, Element child) {
        parent.appendChild(child);
    }

    /**
     * 在parent下增加字符串tagName生成的结点.
     *
     * @param parent  父节点
     * @param tagName 子节点名称
     */
    public static void addElement(Element parent, String tagName) {
        Document doc = parent.getOwnerDocument();
        Element child = doc.createElement(tagName);
        parent.appendChild(child);
    }

    /**
     * 在parent下增加tagName的Text结点，且值为text.
     *
     * @param parent  父节点
     * @param tagName 待新增内容的节点
     * @param text    增加的内容
     */
    public static void addElement(Element parent, String tagName, String text) {
        Document doc = parent.getOwnerDocument();
        Element child = doc.createElement(tagName);
        setElementValue(child, text);
        parent.appendChild(child);
    }

    /**
     * 将父结点parent下的名称为tagName的结点移除.
     *
     * @param parent  父节点
     * @param tagName 待移除的借点名称
     */
    public static void removeElement(Element parent, String tagName) {
        logger.debug("remove " + parent.getNodeName() + "'s children by tagName " + tagName + " begin   ");
        NodeList nl = parent.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node nd = nl.item(i);
            if (nd.getNodeName().equals(tagName)) {
                parent.removeChild(nd);
                logger.debug("remove child '" + nd + "' success.");
            }
        }
        logger.debug("remove " + parent.getNodeName() + "'s children by tagName " + tagName + " end.");
    }

}
