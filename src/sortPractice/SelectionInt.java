package sortPractice;

public class SelectionInt extends ArrayInt 
{
	public SelectionInt()
	{
		super();
	}
	
	public SelectionInt(int size)
	{
		super(size);
	}
	
	public SelectionInt(int[] elements)
	{
		super(elements);
	}
	
	@Override
	public void sort()
	{
		for(int i = 0; i < this.size() - 1; i++)
		{
			int minIndex = i;
			
			for(int j = i + 1; j < this.size(); j++)
			{
				if(get(j) < get(minIndex))
				{
					minIndex = j;
				}
			}
			
			int temp = get(i);
			set(i, get(minIndex));
			set(minIndex, temp);
		}
	}
	
}
