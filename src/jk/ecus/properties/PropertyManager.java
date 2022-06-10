package jk.ecus.properties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jk.ecus.properties.exception.PropertiesException;

public class PropertyManager
{
	private static final String DEFAULT_FILE = "mappings.properties";
	
    //--------------------------------------------------
	//singleton
	
	private static PropertyManager mappings;	
	private static Map<String, PropertyManager> instances;
	
	public static PropertyManager getInstance(Class<?> clazz) throws PropertiesException
	{
		if(mappings == null)
			mappings = new PropertyManager(DEFAULT_FILE);
		
		if(instances == null)
			instances = new HashMap<String, PropertyManager>();
		
		String file = mappings.get(clazz.getName());
		
		return getInstance(file);
	}
	
    //--------------------------------------------------
	//aux
	
	private static PropertyManager getInstance(String file) throws PropertiesException
	{
		if(file == null)
			throw new PropertiesException("Invalid argument");
			
		PropertyManager instance = instances.get(file);
		if(instance == null)
		{
			instance =  new PropertyManager(file);
			instances.put(file, instance);
		}
		
		return instance;
	}
	
    //--------------------------------------------------
	//members
	
    private Map<String, String> properties;
	
    //--------------------------------------------------
    
    private PropertyManager()
    {
		this.properties = new HashMap<String, String>();
    }
    
    private PropertyManager(String file) throws PropertiesException
    {
		this.properties = PropertyLoader.load("/" + file);
    }

    //--------------------------------------------------
	//container methods
	
	public String get(String ref)
	{
		return properties.get(ref);
	}

	public boolean has(String ref)
	{
		return properties.containsKey(ref);
	}
	
	public Map<String, String> getAll(String prefix)
	{
		Map<String, String> values = new HashMap<String, String>();
		Iterator<String> it = properties.keySet().iterator();
		
		while(it.hasNext())
		{
			String key = it.next();
			
			if(key.startsWith(prefix))
			{
				values.put(key, properties.get(key));
			}
		}
		
		return values;
	}
}
