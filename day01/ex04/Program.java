import java.util.Scanner;

public class Program
{

	public static void main(String[] args) {
		Scanner	sc			=	new Scanner(System.in);
		String	inputStr;
		char[] 	chars;
		int[] 	counts;
		char[] 	stringArr;

		inputStr	= sc.nextLine();
		chars		= new char[inputStr.length()];
		counts		= new int[inputStr.length()];
		stringArr	= inputStr.toCharArray();
		for (int i = 0; i < inputStr.length(); i++) {
			for (int k = 0; i < chars.length; k++)
			{
				if (chars[k] == 0) {
					chars[k] = stringArr[i];
				}
				if (stringArr[i] == chars[k]) {
					counts[k] = counts[k] + 1; /// change
					break ;
				}
			}
		}
		for (int i = 0; counts[i] != 0; i++) {
			System.out.print(counts[i] + " ");
		}
		System.out.print("\n");

		for (int i = 0; chars[i] != 0; i++) {
			System.out.print(chars[i] + " ");
		}
		
		sc.close();
	}
}

