package jk.ecus.rss.spec2_0;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Item {

	public static final String ITEM_XML_TAG = "item";
	private static final String TITLE_XML_TAG = "title";
	private static final String DESC_XML_TAG = "description";
	private static final String PUBD_XML_TAG = "pubDate";
	private static final String GUID_XML_TAG = "guid";
	private static final String LINK_XML_TAG = "link";
	public static final String READ_XML_ATTR = "read";

	private String title;
	private String description;
	private String pubDate;
	private String guid;
	private String link;
	
	private boolean read;
	
	public Item(Element xml)
	{
		NodeList nlTitle = xml.getElementsByTagName(TITLE_XML_TAG);
		NodeList nlDescription = xml.getElementsByTagName(DESC_XML_TAG);		
		NodeList nlPubDate = xml.getElementsByTagName(PUBD_XML_TAG);
		NodeList nlGuid = xml.getElementsByTagName(GUID_XML_TAG);
		NodeList nlLink = xml.getElementsByTagName(LINK_XML_TAG);
		
		if(nlTitle.getLength() != 0) this.title = nlTitle.item(0).getTextContent();
		if(nlDescription.getLength() != 0) this.description = nlDescription.item(0).getTextContent();
		if(nlPubDate.getLength() != 0) this.pubDate = nlPubDate.item(0).getTextContent();
		if(nlGuid.getLength() != 0) this.guid = nlGuid.item(0).getTextContent();
		if(nlLink.getLength() != 0) this.link = nlLink.item(0).getTextContent();
		
		String attrRead = xml.getAttribute(READ_XML_ATTR);
		this.read = (attrRead.equals("")) ? false : Boolean.parseBoolean(attrRead);
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

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
	
	@Override
	public boolean equals(Object object)
	{
		Item item = (Item) object;
		
		if(title != null && !title.equals(item.getTitle()))
			return false;
		else if(title == null && item.getTitle() != null)
			return false;
		else if(description != null && !description.equals(item.getDescription()))
			return false;
		else if(description == null && item.getDescription() != null)
			return false;
		else if(pubDate != null && !pubDate.equals(item.getPubDate()))
			return false;
		else if(pubDate == null && item.getPubDate() != null)
			return false;
		else if(guid != null && !guid.equals(item.getGuid()))
			return false;
		else if(guid == null && item.getGuid() != null)
			return false;
		else if(link != null && !link.equals(item.getLink()))
			return false;
		else if(link == null && item.getLink() != null)
			return false;
		else
			return true;
	}
	
	public String toXML()
	{
		String xml = new String();
		
		xml += "<" + ITEM_XML_TAG + " " + READ_XML_ATTR + "=\"" + read + "\">\n";
		if(title != null) xml += "\t<" + TITLE_XML_TAG + "><![CDATA[" + title + "]]></" + TITLE_XML_TAG + ">\n";
		if(description != null) xml += "\t<" + DESC_XML_TAG + "><![CDATA[" + description + "]]></" + DESC_XML_TAG + ">\n";
		if(pubDate != null) xml += "\t<" + PUBD_XML_TAG + ">" + pubDate + "</" + PUBD_XML_TAG + ">\n";
		if(guid != null) xml += "\t<" + GUID_XML_TAG + "><![CDATA[" + guid + "]]></" + GUID_XML_TAG + ">\n";
		if(link != null) xml += "\t<" + LINK_XML_TAG + "><![CDATA[" + link + "]]></" + LINK_XML_TAG + ">\n";
		xml += "</" + ITEM_XML_TAG + ">";
		
		return xml;
	}
}
