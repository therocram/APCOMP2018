package sortPractice;

public class InsertionInt extends ArrayInt {

	public InsertionInt() 
	{
		super();
	}
	
	public InsertionInt(int size)
	{
		super(size);
	}

	public InsertionInt(int[] elements) 
	{
		super(elements);
	}

	@Override
	public void sort() 
	{
		for(int i = 1; i < this.size(); i++)
		{
			int temp = get(i);
			int possibleIndex = i;
			
			while(possibleIndex > 0  && temp < get(possibleIndex - 1))
			{
				set(possibleIndex, get(possibleIndex - 1));
				possibleIndex--;
			}
			
			set(possibleIndex, temp);
		}
	}

}
