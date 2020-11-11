import java.util.List;

public class Phrase {

    private String value;

    public Phrase(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean matches(String query) {
        return this.value.matches(query);
    }

    public int indexOfWord(String word) {
        return this.value.indexOf(word);
    }
}
