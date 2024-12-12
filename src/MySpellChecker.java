import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;

public class MySpellChecker {
    public static void main(String[] args){
        List<MyWord> dictionary = new ArrayList<MyWord>();
        List<MyWord> inputList = new ArrayList<MyWord>();
        List<MyWord> ignoreList = new ArrayList<MyWord>();
        Scanner scanley = new Scanner(System.in);
        try(Scanner dictScanner = new Scanner(new File(args[0])); Scanner inputScanner = new Scanner(new File(args[1]));
            PrintWriter correctionsWriter = new PrintWriter(new File("tempCorrect.txt"));
            PrintWriter dictWriter = new PrintWriter(new File("tempDict.txt"));
            ){

            while(dictScanner.hasNext()){
                MyWord dictWord = new MyWord(dictScanner.next().toCharArray());
                dictionary.add(dictWord);
            }
            int lineNumber = 1;
            while(inputScanner.hasNextLine()){
                String line = inputScanner.nextLine();
                String[] words = line.split("\s");
                for(String word : words){
                    inputList.add(new MyWord(word.toCharArray()));
                }


                for (int i = 0; i < inputList.size(); i++) {

                    if(!(ignoreList.contains(inputList.get(i))) &&!(dictionary.contains(inputList.get(i)))) {
                        MyWord check = inputList.get(i);
                        System.out.printf("""
                                Line %d: %s
                                check: %s
                                1 - Provide Corrections
                                2 - Ignore
                                3 - Ignore All
                                4 - Add to dictionary
                                
                                """, lineNumber, line, check);

                        System.out.print(">#");
                        int input = scanley.nextInt();
                        System.out.println();
                        if (input == 1) {
                            System.out.print("correction: ");
                            String r = scanley.next();
                            MyWord replace = new MyWord(r.toCharArray());
                            inputList.set(i, replace);
                        }
                        if (input == 3) {
                            ignoreList.add(inputList.get(i));
                        }
                        if (input == 4) {
                            dictionary.add(inputList.get(i));
                        }
                    }
                    correctionsWriter.print(inputList.get(i) + " ");
                }

                correctionsWriter.println();
                lineNumber++;
                inputList.clear();
            }
            for (int i = 0; i < dictionary.size(); i++) {
                dictWriter.println(dictionary.get(i));

            }


        } catch(FileNotFoundException e){
            System.out.println("Usage: (Dictionary File) (Input Location)");

        }
        //#TODO: Copy over temp files and store them in the other one
        try(
                Scanner = new Scanner(new File("tempCorrect.txt"));
                ){

        }


    }
}
