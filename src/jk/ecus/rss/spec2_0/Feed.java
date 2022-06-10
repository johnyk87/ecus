package jk.ecus.rss.spec2_0;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Feed {

	private ChannelData data;
	private List<Item> items;
	
	public Feed(Element data)
	{
		this.data = new ChannelData(data);
		this.items = new LinkedList<Item>();
	}
	
	public Feed(Element data, NodeList items)
	{
		this.data = new ChannelData(data);
		this.items = new LinkedList<Item>();
		
		for(int i=0; i<items.getLength(); i++)
		{
			this.items.add(new Item((Element) items.item(i)));
		}
	}
	
	public ChannelData getData() {
		return data;
	}
	
	public List<Item> getItems()
	{
		return items;
	}
	
	public void setItems(List<Item> items)
	{
		this.items = items;
	}
}
