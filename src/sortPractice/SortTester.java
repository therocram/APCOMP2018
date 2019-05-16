package sortPractice;

public class SortTester 
{

	public static void main(String[] args) 
	{
		ArrayInt[] collection = new ArrayInt[3];
		
		collection[0] = new SelectionInt(10);
		collection[1] = new InsertionInt(10);
		collection[2] = new MergeInt(10);
		
		int[] elements = {12, 35, 17, 1, 23, 8, -9, 4, 3};
		
		for(int i : elements)
		{
			collection[0].add(i);
			collection[1].add(i);
			collection[2].add(i);
		}
		
		for(ArrayInt item : collection)
		{
			System.out.println(item.toString() + "\n");
		}
		
		for(ArrayInt item : collection)
		{
			item.sort();
		}
		
		for(ArrayInt item : collection)
		{
			System.out.println(item.toString() + "\n");
		}
		
		
	}

}
