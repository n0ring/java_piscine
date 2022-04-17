import java.util.Scanner;


public class Program
{
	public static void main(String[] args) {
		Scanner	sc			=	new Scanner(System.in);
		long	min_grades	= 0;
		String	tmpInput;
		
		for (int i = 1; i <= 18; i++)
		{
			tmpInput = sc.nextLine();
			if (tmpInput.equals("42"))
				break ;
			if (!tmpInput.equals("Week " + i))
				errorExit(sc);
			min_grades += getWeekGrade(sc);
			min_grades *= 10;
		} 
		System.out.print(min_grades);
		sc.close();
	}

	private static int getWeekGrade(Scanner sc)
	{
		int currentMin = 10;
		int currentVal;
		for (int i = 0; i < 5; i++)
		{
			currentVal = sc.nextInt();
			if (currentVal < 1 || currentVal > 9)
				errorExit(sc);
			if (currentVal < currentMin)
				currentMin = currentVal;

			}
		return currentMin;
	}

	private static void errorExit(Scanner sc)
	{
		sc.close();
		System.out.print("Illegal Argument\n");
		System.exit(1);
	}
}