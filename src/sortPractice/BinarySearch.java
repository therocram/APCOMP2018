package sortPractice;

public class BinarySearch 
{

	public static void main(String[] args) 
	{
		int[] elements = {0, 23, 41, 2, 18, 4, 9};
		
		System.out.println(binarySearch(elements, 41));
	}
	
	public static int binarySearch(int[] elements, int target)
	{
		int left = 0;
		int right = elements.length - 1;
		int middle;
		
		while(left <= right)
		{
			middle = (left + right) / 2;
			
			if(target < elements[middle])
			{
				right = middle - 1;
			}
			
			else if(target > elements[middle])
			{
				left = middle + 1;
			}
			
			else
			{
				return middle;
			}
		}
		
		return -1;
	}

}
