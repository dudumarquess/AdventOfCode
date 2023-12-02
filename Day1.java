
import java.util.Scanner;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			Scanner sc = new Scanner(file);
			int sum = 0;
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				sum += trebuchet(line);
			}
			System.out.println(sum);
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int trebuchet(String line) {
		StringBuilder result = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();

		for (int i = 0; i < line.length(); i++) {
			char leftChar = line.charAt(i);
			if(Character.isDigit(leftChar)) {
				result.append(leftChar);
				result.append(trebuchetRight(line));
				return Integer.parseInt(result.toString());
			}else {
				sb1.append(leftChar);
				int number = getNumber(sb1.toString());
				if(number != 0) {
					result.append(number);
					result.append(trebuchetRight(line));
					return Integer.parseInt(result.toString());
				}
			}
		}
		return 0;
	}

	public static int trebuchetRight(String line) {
		StringBuilder result = new StringBuilder();

		for (int i = line.length() - 1; i >= 0; i--) {
			char rightChar = line.charAt(i);
			if(Character.isDigit(rightChar)) {
				return Character.getNumericValue(rightChar);
			}else {
				result.insert(0, rightChar);
				int number = getNumber(result.toString());
				if (number != 0) {
					return number;
				}
			}
		}
		return 0;
	}

	public static int getNumber(String line) {
		String padrao = "(?:one|two|three|four|five|six|seven|eight|nine)";
		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = pattern.matcher(line);

		if(matcher.find()) {
			String numero = matcher.group();
			return obterValor(numero);
		}
		return 0;
	}

	public static int obterValor(String numero) {
		switch (numero) {
			case "one":
				return 1;
			case "two":
				return 2;
			case "three":
				return 3;
			case "four":
				return 4;
			case "five":
				return 5;
			case "six":
				return 6;
			case "seven":
				return 7;
			case "eight":
				return 8;
			case "nine":
				return 9;
		}
		return 0;
	}
}
