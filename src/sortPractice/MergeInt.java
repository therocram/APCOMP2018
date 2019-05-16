package sortPractice;

public class MergeInt extends ArrayInt {

	public MergeInt() 
	{
		super();
	}
	
	public MergeInt(int size)
	{
		super(size);
	}
	
	public MergeInt(int[] elements) 
	{
		super(elements);
	}

	@Override
	public void sort() 
	{
		MergeInt temp = new MergeInt(size());
		
		mergeSortHelper(this, 0, size() - 1, temp);
		
	}
	
	private void mergeSortHelper(MergeInt elements, int from, int to, MergeInt temp)
	{
		if(from < to)
		{
			int mid = (from + to) / 2;
			mergeSortHelper(elements, from, mid, temp);
			mergeSortHelper(elements, mid + 1, to, temp);
			merge(elements, from, mid, to, temp);
		}
	}
	
	private void merge(MergeInt elements, int from, int mid, int to, MergeInt temp)
	{
		int i = from;
		int j = mid + 1;
		int k = from;
		
		while(i <= mid && j <= to)
		{
			if(elements.get(i) < elements.get(j))
			{
				temp.set(k, elements.get(i));
				i++;
			}
			
			else if(elements.get(j) > elements.get(i))
			{
				temp.set(k, elements.get(j));
				j++;
			}
			
			k++;
		}
		
		while(i <= mid)
		{
			temp.set(k, elements.get(i));
			i++;
			k++;
		}
		
		while(j <= to)
		{
			temp.set(k, elements.get(j));
			j++;
			k++;
		}
		
		for(k = from; k <= to; k++)
		{
			elements.set(k, temp.get(k));
		}
		
	}

}
