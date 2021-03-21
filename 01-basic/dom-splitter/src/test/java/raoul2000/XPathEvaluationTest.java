package raoul2000;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XPathEvaluationTest {

	public Document parse(String response) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		dbfactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		dbfactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		return dbfactory.newDocumentBuilder().parse(new InputSource(new StringReader(response)));
	}
	
	public XPathExpression xpath(String expression) throws XPathExpressionException {
		return XPathFactory.newInstance().newXPath().compile(expression);
	}
	
	@Test
	void selectANumber_success() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		Document dom = parse("<a><b>1</b></a>");
		
		Double number = (Double) xpath("/a/b").evaluate(dom, XPathConstants.NUMBER);
		assertFalse(number.isNaN());
		assertEquals(1, number.intValue());
		
		Double number2 = (Double) xpath("/a/b/text()").evaluate(dom, XPathConstants.NUMBER);
		assertFalse(number2.isNaN());
		assertEquals(1, number2.intValue());	
				
	}
	
	@Test
	void selectWithCondition() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		Document dom = parse("<a>"
				+ "<b>1</b>"
				+ "</a>");
		
		Double number = (Double) xpath("/a[b=1]/b").evaluate(dom, XPathConstants.NUMBER);
		assertFalse(number.isNaN());
		assertEquals(1, number.intValue());
		
		Double number2 = (Double) xpath("/a[b=2]/b").evaluate(dom, XPathConstants.NUMBER);
		assertTrue(number2.isNaN());
				
	}
	
	@Test
	void selectWithCondition_fails() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		Document dom = parse("<a>"
				+ "<b>"
				+ "		<c>1</c>"
				+ "</b>"
				+ "</a>");
		
		Double number = (Double) xpath("/a[b/text()=1]").evaluate(dom, XPathConstants.NUMBER);
		assertTrue(number.isNaN());
	}
}
