import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Q2Main {

    private static List<Phrase> phrases = new ArrayList<>();
    private static String query = "";
    private static String firstWordGroup = "";

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Input:");
        int lines = Integer.parseInt(sn.nextLine());
        readInput(sn, lines);

        query = sn.nextLine()
                .replace("?",".?")
                .replace("_",".")
                .replace("*",".*");

        System.out.println("\nOutput:");
        Matcher matcher = Pattern.compile("\\w+").matcher(query);
        if(matcher.find())
            firstWordGroup = matcher.group();
        for(Phrase phrase: phrases.stream()
                .filter(phrase -> phrase.matches(query))
                .sorted((p1, p2) -> {
                    if(p1.indexOfWord(firstWordGroup) < 0)
                        return 1;
                    return (p1.indexOfWord(firstWordGroup) - p2.indexOfWord(firstWordGroup));
                })
                .collect(Collectors.toList())) {

            System.out.println(phrase.getValue());
        }

    }

    private static void readInput(Scanner sn, int lines) {
        for(int i=1; i<lines; i++)
            phrases.add(new Phrase(sn.nextLine()));
    }

}