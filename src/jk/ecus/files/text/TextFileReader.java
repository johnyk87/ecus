package jk.ecus.files.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import jk.ecus.files.exception.FilesException;

/**
 * Reads and writes a list of strings to a text file.
 * 
 * @author JohnyK
 *
 */
public class TextFileReader {
	
	/**
	 * Reads a list of strings from a file.
	 * 
	 * @param file						path of the file to read from
	 * @return								a list of string correspondent to the lines of the file 
	 * @throws FilesException	when any i/o exception occurs
	 */
	public static List<String> read(String file) throws FilesException
	{
		try
		{
			BufferedReader bf = new BufferedReader(new FileReader(file));
			List<String> lines = new LinkedList<String>();
			
			String line = null;
			while((line = bf.readLine()) != null)
			{
				lines.add(line);
			}
			
			bf.close();
			
			return lines;
		}
		catch(Exception e)
		{
			throw new FilesException(e);
		}
	}
	
	/**
	 * Writes a list of strings to a file.
	 * 
	 * @param file						the file to write to
	 * @param append				whether the list should be appended to the contents of the file, if it exists
	 * @param lines					the list of strings to write to the file
	 * @throws FilesException	when any i/o exception occurs
	 */
	public static void write(String file, boolean append, List<String> lines) throws FilesException
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, append));
						
			for(int i=0; i<lines.size(); i++)
			{
				bw.write(lines.get(i));
				bw.newLine();
			}
			
			bw.close();
		}
		catch(Exception e)
		{
			throw new FilesException(e);
		}
	}
}
