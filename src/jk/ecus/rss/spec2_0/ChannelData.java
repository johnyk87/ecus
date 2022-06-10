package jk.ecus.rss.spec2_0;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class ChannelData {

	public static final String CHANNEL_XML_TAG = "channel";
	private static final String TITLE_XML_TAG = "title";
	private static final String DESC_XML_TAG = "description";
	private static final String LINK_XML_TAG = "link";

	private String title;
	private String description;
	private String link;
	
	public ChannelData(Element xml)
	{
		NodeList nlTitle = xml.getElementsByTagName(TITLE_XML_TAG);
		NodeList nlDescription = xml.getElementsByTagName(DESC_XML_TAG);	
		NodeList nlLink = xml.getElementsByTagName(LINK_XML_TAG);
		
		if(nlTitle.getLength() != 0) this.title = nlTitle.item(0).getTextContent();
		if(nlDescription.getLength() != 0) this.description = nlDescription.item(0).getTextContent();
		if(nlLink.getLength() != 0) this.link = nlLink.item(0).getTextContent();
	}
	
	public ChannelData(String name, String description, String link)
	{
		this.title = name;
		this.description = name;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String toXML()
	{
		String xml = new String();
		
		xml += "<" + CHANNEL_XML_TAG + ">\n";
		if(title != null) xml += "\t<" + TITLE_XML_TAG + ">" + title + "</" + TITLE_XML_TAG + ">\n";
		if(description != null) xml += "\t<" + DESC_XML_TAG + ">" + description + "</" + DESC_XML_TAG + ">\n";
		if(link != null) xml += "\t<" + LINK_XML_TAG + ">" + link + "</" + LINK_XML_TAG + ">\n";
		xml += "</" + CHANNEL_XML_TAG + ">";
		
		return xml;
	}
}
