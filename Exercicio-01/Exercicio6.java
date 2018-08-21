public class Exercicio6
{
	public static void main (String args[])
	{	
		int numbers[] = new int [10];
		int sum, biggest, smallest;
		float average;

		for (int i = 0; i < 10; i++)
		{	
			numbers[i] = Integer.parseInt (args[i]);
		}

		biggest = numbers[0];
		smallest = numbers[0];
		
		for (i = 0; i < 10; i++)
		{
			
			sum += numbers[i];
			
			if (numbers[i] > biggest)
			{
				biggest = numbers[i];
			}
			
			if (numbers[i] < smallest)
			{
				smallest = numbers[i];
			}	
		}
		
		average = sum / 10;
		
		System.out.print ("Sum: " + sum);
		System.out.print ("Average: " + average);
		System.out.print ("Biggest: "  + biggest);
		System.out.print ("Smallest: "  + smallest);	
	}
}
