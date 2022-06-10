package jk.ecus.cache;

import java.util.HashMap;
import java.util.Map;

public class ObjectCache implements ICache<Object>
{
    //--------------------------------------------------
    //Fields
    
	private Map<String, Object> cache;

    //--------------------------------------------------
    
    protected ObjectCache()
    {
    	this.cache = new HashMap<String, Object>();
    }

    //--------------------------------------------------
    
    public void put(String id, Object value)
    {
    	cache.put(id, value);
    }
    
    public Object get(String id)
    {
    	return cache.get(id);
    }
    
    public void reset()
    {
    	cache.clear();
    }
}
