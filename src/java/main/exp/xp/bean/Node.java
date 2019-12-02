package exp.xp.bean;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <PRE>
 * XML节点
 * </PRE>
 * <br/><B>PROJECT : </B> exp-xml-paper
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2015-06-01
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class Node {

	/** 无效属性名，用于UI界面占位 */
	public final static String NEW_ATTRIBUTE = " new attribute ";
	
	private String name;
	
	private String text;
	
	private Map<String, String> attributes;
	
	public Node(String name) {
		this.name = (name == null ? "" : name.trim());
		this.text = "";
		this.attributes = new HashMap<String, String>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = (text == null ? "" : text.trim());
	}

	public void setAttribute(String attribute, String value) {
		attributes.put(attribute, value);
	}
	
	public String delAttribute(String attribute) {
		return attributes.remove(attribute);
	}

	public String getAttributeVal(String attribute) {
		String value = attributes.get(attribute);
		return (value == null ? "" : value);
	}
	
	public void clearAttributes() {
		attributes.clear();
	}
	
	public List<String> getAttributeKeys() {
		List<String> keys = new LinkedList<String>(attributes.keySet());
		Collections.sort(keys, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		return keys;
	}

	@Override
	public String toString() {
		return name;
	}
}
