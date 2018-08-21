public class Exercicio5
{
	public static void main (String args[])
	{	
		int workdays = Integer.parseInt (args[0]);
	
		float wage = Float.parseFloat (args[1]);

		float payment = wage / (22 / workdays);

		System.out.print (payment);
	}
}
