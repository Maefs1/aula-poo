public class Exercicio7
{
	public static void main (String args[])
	{	
		String name = args[0];
		float grade[] = new float [3];
		float summary;

		for (int  i = 0; i < 3; i++)
		{
			grade[i] = Float.parseFloat (args[i+1]);
			summary += grade[i];
		}
		
		summary /= 3;
		
		System.out.print ("Nome do aluno: " + name);
		System.out.print ("Media: " + summary);
		if (summary >= 5,75)
		{
			System.out.print ("Situacao: Aprovado");
		}else
		{
			System.out.print ("Situacao: Reprovado");
		}		
	}
}
