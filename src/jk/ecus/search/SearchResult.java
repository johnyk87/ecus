package jk.ecus.search;

public interface SearchResult {
	
	//********************************************************
	//constants
	
	public static final String CATEGORY_SHOW = "show";
	public static final String CATEGORY_EPISODE = "episode";
	
	//********************************************************
	//methods
	
	public String getRef();	
	public String getFriendlyName();	
	public String getCategory();
	
	public boolean matches(String param);
}
