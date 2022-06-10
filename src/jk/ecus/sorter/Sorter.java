package jk.ecus.sorter;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import jk.ecus.sorter.exception.SorterException;

public class Sorter
{
	public static<T> List<T> sort(Collection<T> collection, Comparator<T> comparator) throws SorterException
	{
		try
		{
			List<T> aux = new LinkedList<T>();
			
			aux.addAll(collection);
			
			Collections.sort(aux, comparator);
					
			return aux;
		}
		catch(Exception e)
		{
			throw new SorterException(e);
		}
	}
}
