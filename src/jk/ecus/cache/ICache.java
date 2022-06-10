package jk.ecus.cache;

public interface ICache<T>
{    
    public void put(String id, T value);
    
    public T get(String id);
    
    public void reset();
}
