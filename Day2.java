import java.util.Scanner;
import java.io.File;

public class Day2 {
	public static void main(String[] args) {
		try {
			File file = new File("input.txt");
			Scanner sc = new Scanner(file);
			int sum = 0;
			while(sc.hasNextLine()) {
				String[] jogo = sc.nextLine().split(":");
				String[] idString = jogo[0].split(" ");
				
				int id = Integer.parseInt(idString[1]);
				String[] sets = jogo[1].split(";");
				int[] minimum = minimumCubes(sets);
				int power = minimum[0] * minimum[1] * minimum[2];
				sum += power;
			}
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isPossible (String[] s) {
		int[] quantidades = {12,13,14};
		for(String set : s) {
			String[] cores = set.split(",");
			for(String cor : cores) {
				String[] dividir = cor.split(" ");
				int quantidade = Integer.parseInt(dividir[1]);
				if(dividir[2].equals("red")){
					if(quantidade > quantidades[0]) {
						return false;
					}
				}else if(dividir[2].equals("green")) {
					if(quantidade > quantidades[1]) {
						return false;
					}
				}else {
					if(quantidade > quantidades[2]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static int[] minimumCubes (String[] s) {
		int[] minimum = new int[3];
		for(String set : s) {
			String[] cores = set.split(",");
			for(String cor : cores) {
				String[] dividir = cor.split(" ");
				int quantidade = Integer.parseInt(dividir[1]);
				if(dividir[2].equals("red") && quantidade > minimum[0]){
					minimum[0] = quantidade;
				}else if(dividir[2].equals("green") && quantidade > minimum[1]) {
					minimum[1] = quantidade;
				}else if(dividir[2].equals("blue") && quantidade > minimum[2]){
					minimum[2] = quantidade;
				}
			}
		}
		return minimum;
	}
}
