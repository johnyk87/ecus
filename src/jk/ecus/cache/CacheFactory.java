package jk.ecus.cache;

import java.util.HashMap;
import java.util.Map;

import jk.ecus.cache.exception.CacheException;

public class CacheFactory
{
	private static Map<String, ICache<?>> instances; 
	
    public static ICache<?> getCache(String id) throws CacheException
    {
    	checkInit();
    	
    	if(!instances.containsKey(id))
    		throw new CacheException("Unknown element");
		
		return instances.get(id);
    }
	
    public static <T extends ICache<?>> ICache<?> createCache(String id, Class<T> type) throws CacheException
    {
    	checkInit();
    	
    	try
    	{
        	if(id == null || instances.containsKey(id))
        		throw new CacheException((id == null) ? ("Id can't be null") : ("A cache already exists for the id: " + id));
	    	
        	ICache<?> instance =(type == null) ? new ObjectCache() : type.newInstance();
	    	
	    	instances.put(id, instance);
			
			return instance;
    	}
    	catch(CacheException e)
    	{
    		throw e;
    	}
    	catch(Exception e)
    	{
    		throw new CacheException(e);
    	}
    }
    
    //------------------------------------------------------------------------------
    //aux
    
    private static void checkInit()
    {
		if (instances == null)
		    instances = new HashMap<String, ICache<?>>();
    }
}
