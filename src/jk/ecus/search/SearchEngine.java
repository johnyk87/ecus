package jk.ecus.search;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {

	//**************************************************************
	//members
	
	private static List<SearchBranch> managers;
	private static List<String> words;
	
	//**************************************************************
	//api
	
	public static List<SearchResult> search(String param)
	{
		if(!initWords(param))
			return new LinkedList<SearchResult>();
		
		List<SearchResult> results = search();
		
		clear();
		
		return results;
	}
	
	//**************************************************************
	//initializers and destroyers
	
	private static boolean initWords(String param)
	{
		if(param == null)
			return false;
		
		words = new LinkedList<String>();
		
		String[] split = param.toLowerCase().split(" ");
		
		for(int i=0; i<split.length; i++)
		{
			String word = split[i].trim();
			if(word.length() != 0)
				words.add(word);
		}
		
		return words.size() != 0;
	}
	
	private static void clear()
	{
		managers = null;
		words = null;
	}
	
	//**************************************************************
	//search algorithm
	
	private static List<SearchResult> search()
	{
    	List<SearchResult> results = new LinkedList<SearchResult>();
		
		for(int i=0; i<words.size(); i++)
		{
			if(i==0)
			{
				results = searchManagers(words.get(i));
			}
			else
			{
				results.retainAll(searchManagers(words.get(i)));
			}
		}
		
		return results;
	}

    private static List<SearchResult> searchManagers(String word)
    {
    	List<SearchResult> results = new LinkedList<SearchResult>();
    	
    	for(int i=0; i<managers.size(); i++)
    	{
    		results.addAll(managers.get(i).search(word));
    	}
    	
    	return results;
    }
}
