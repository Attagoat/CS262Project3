import java.util.Arrays;

public class TestDriver {
    public static void main(String[] args) {
        MyWord[] words = new MyWord[5];
        char[] chicken = {'c','h','i','c','k','e','n'};
        char[] dog = {'D','o','g'};
        char[] egg = {'e','g','g'};
        char[] zebra = {'z', 'e', 'b','r', 'a'};
        char[] abomination = "Abomination".toCharArray();
        words[0] = new MyWord(abomination);
        words[1] = new MyWord(zebra);
        words[2] = new MyWord(dog);
        words[3] = new MyWord(egg);
        words[4] = new MyWord(chicken);

        Arrays.sort(words);

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

    }
}
