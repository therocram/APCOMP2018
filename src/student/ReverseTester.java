package student;
import javax.swing.JOptionPane;

public class ReverseTester 
{

	static String ret = "";
	static int forlength;
	
	public static void main(String[] args) 
	{
		String forward = "Chupacabra";
		forlength = forward.length();
		System.out.println(reverse(forward, 0));
	}
	
	public static String reverse(String forward, int index)
	{	
		//String ret = "";
		
		if(index >= forlength - 1)
		{
			return ret;
		}
		
		//System.out.println(forward.substring(index + 1));
		ret += forward.charAt(forward.length() - index - 1);
		return reverse(forward.substring(index), index + 1);	
	}

}
