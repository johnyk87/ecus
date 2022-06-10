package jk.ecus.rss.parser;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import jk.ecus.rss.exception.RSSException;
import jk.ecus.rss.spec2_0.Feed;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Entry point for parsing a feed.
 * 
 * @author JohnyK
 *
 */
public class FeedParser {
	
	/**
	 * Parse the feed at a given url.
	 * 
	 * @param link				the url to the feed
	 * @return						a Feed with the information parsed from the given url
	 * @throws Exception	any exception thrown by the parser
	 */
	public static Feed parse(String link) throws RSSException
	{
		try
		{
			Document doc = parseUrl(link);
			Feed feed = parseFeed(doc);
			
			return feed;
		}
		catch(Exception e)
		{
			throw new RSSException(e);
		}
	}
	
	/**
	 * Parse the feed at a given url with a set of credentials.
	 * 
	 * @param link				the url to the feed
	 * @param auth			an authenticator with credentials to use in the connection
	 * @return						a Feed with the information parsed from the given url
	 * @throws Exception	any exception thrown by the parser
	 */
	public static Feed parse(String link, Authenticator auth) throws RSSException
	{
		try
		{
			Authenticator.setDefault(auth);
			Document doc = parseUrl(link);
			Feed feed = parseFeed(doc);
			Authenticator.setDefault(null);
			
			return feed;
		}
		catch(Exception e)
		{
			throw new RSSException(e);
		}
	}
	
	/*----------------------PARSING METHODS-------------------------*/
	
	private static Document parseUrl(String link) throws ParserConfigurationException, SAXException, IOException
	{
		URL url = new URL(link);
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		
		Document doc = docBuilder.parse(url.openStream());
		
		return doc;
	}

	private static Feed parseFeed(Document doc)
	{
		Element data = getData(doc);
		NodeList items = doc.getElementsByTagName("item");
		
		return new Feed(data, items);
	}
	
	/*----------------------AUX METHODS-------------------------*/
	
	private static Element getData(Document doc)
	{
		Element channel = (Element) doc.getElementsByTagName("channel").item(0).cloneNode(true);
		NodeList items = channel.getElementsByTagName("item");
		
		return removeNodes(channel, items);
	}
	
	private static Element removeNodes(Element elem, NodeList nodes)
	{
		while(nodes.getLength() != 0)
		{
			elem.removeChild(nodes.item(0));
		}
		
		return elem;
	}
}
