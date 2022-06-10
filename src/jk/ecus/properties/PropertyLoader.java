package jk.ecus.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import jk.ecus.properties.exception.PropertiesException;

public class PropertyLoader {
	
	protected static Map<String, String> load(String path) throws PropertiesException
	{
		return load(loadResource(path));
	}
	
	/********************AUX***************************/
	
	private static Properties loadResource(String path) throws PropertiesException
	{
        try
        {
        	InputStream is = PropertyLoader.class.getResourceAsStream(path);
            
            if(is == null) throw new PropertiesException("Unknown resource: " + path);
            
            Properties props = new Properties();
            props.load(is);
            
            return props;
        }
        catch(PropertiesException e)
        {
        	throw e;
        }
        catch (IOException e)
        {
            throw new PropertiesException(e);
        }
	}
	
	private static Map<String, String> load(Properties props)
	{
		Map<String, String> properties = new HashMap<String, String>();
		
		if(props == null)
			return properties;
		
		try
		{
			Iterator<Object> it = props.keySet().iterator();
			
			while(it.hasNext())
			{
				String key = (String) it.next();
				String value = props.getProperty(key);
				
				if(value != null && value.length() != 0)
					properties.put(key, value);
			}
			
			return properties;
		}
		catch(Exception e)
		{
			return new HashMap<String, String>();
		}
	}
}
