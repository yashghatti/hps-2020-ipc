import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q2Main {

    private static List<String> phrases = new ArrayList<>();
    private static String query = "";

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Input:");
        int lines = Integer.parseInt(sn.nextLine());
        readInput(sn, lines);


    }

    private static void readInput(Scanner sn, int lines) {
        for(int i=1; i<=lines-1; i++)
            phrases.add(sn.nextLine());
        query = sn.nextLine();
    }

}