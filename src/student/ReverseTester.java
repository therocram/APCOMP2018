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
		
		if(index < forward.length())
		{
			ret += forward.charAt(forward.length() -1 - index);
			reverse(forward, index + 1);
		}
		
		return ret;
	}

}
