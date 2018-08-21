public class Exercicio4
{
	public static void main (String args[])
	{	
		float weight = Float.parseFloat (args[0]);
		float height = Float.parseFloat (args[1]);
	
		float imc = weight / (height * height);

		System.out.print (imc);
	}
}
