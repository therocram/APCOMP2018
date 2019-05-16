package sortPractice;

import java.util.ArrayList;

public abstract class ArrayInt extends ArrayList<Integer> implements Sortable
{
	public ArrayInt()
	{
		this(new int[] {});
	}
	
	public ArrayInt(int size)
	{
		super(size);
	}
	
	public ArrayInt(int[] elements)
	{
		for(int i : elements)
		{
			this.add(i);
		}
	}
	
	public abstract void sort();
	
	public String toString()
	{
		String print = "";
		
		for(int i : this)
		{
			print += i + " ";
		}
		
		return print;
	}
}
