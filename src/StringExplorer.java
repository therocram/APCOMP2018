/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";
		
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);
		
		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);
		
		int notFoundPsn = sample.indexOf("slow");
		System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
		
		int FoundPsn1 = sample.indexOf('a');
		System.out.println("sample.indexOf('a') = " + FoundPsn1);
		
		int FoundPsn2 = sample.indexOf('o', 16);
		System.out.println("sample.indexOf('o') = " + FoundPsn2);
		
		int FoundPsn3 = sample.indexOf("laz", 20);
		System.out.println("sample.indexOf(\"laz\") = " + FoundPsn3);
		
		//  Try other methods here:

	}

}
