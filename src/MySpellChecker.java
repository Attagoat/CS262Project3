import java.io.FileNotFoundException;
import java.util.Scanner;

public class MySpellChecker {


    public static void main(String[] args){
        try(Scanner dictScanner = new Scanner(args[0]); Scanner inputScanner = new Scanner(args[1])){
            

        } catch(Exception e){
            System.out.println("Usage: (Dictionary File) (Input Location)");
        }
    }
}
