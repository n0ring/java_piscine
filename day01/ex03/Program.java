import java.util.Scanner;

public class Program
{
	private static final int MAX_WEEKS = 18;
	private static final int MAX_GRADES = 5;
	private static final int MIN_GRADE = 1;
	private static final int MAX_GRADE = 9;
	private static final int ERROR_EXIT = -1;

	public static void main(String[] args) {
		Scanner	sc			=	new Scanner(System.in);
		long	min_grades	=	0;
		String	tmpInput;
		int		i;
		
		for (i = 1; i <= MAX_WEEKS; i++) {
			tmpInput = sc.nextLine();
			if (tmpInput.equals("42")) {
				break ;
			}
			if (!tmpInput.equals("Week " + i)) {
				sc.close();
				errorExit();
			}
			min_grades *= 10;
			min_grades += getWeekGrade(sc);
			sc.nextLine();
		}
		printChart(min_grades, i - 1);
		sc.close();
	}

	private static int getWeekGrade(Scanner sc) {
		int currentMin = 10;
		int currentVal;
		for (int i = 0; i < MAX_GRADES; i++) {
			currentVal = sc.nextInt();
			if (currentVal < MIN_GRADE || currentVal > MAX_GRADE) {
				sc.close();
				errorExit();
			}
			if (currentVal < currentMin) {
				currentMin = currentVal;
			}
		}
		return currentMin;
	}

	private static void errorExit() {
		System.out.print("Illegal Argument\n");
		System.exit(ERROR_EXIT);
	}

	private static void printChartLine(long grade, int week) {
		System.out.print("Week " + week + " ");
		for (int i = 0; i < grade; i++) {
			System.out.print("=");
		}
		System.out.print(">\n");
	}

	private static void printChart(long grades, int weekNumber) {
		if (weekNumber == 0) {
			return ;
		}
		printChart(grades / 10, weekNumber - 1);
		if (grades > 0) {
			printChartLine(grades % 10, weekNumber);
		}
	}
}