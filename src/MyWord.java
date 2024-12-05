public class MyWord implements Comparable<MyWord>{
    private char[] myWord;

    public MyWord(){
        this.myWord = new char[1];
        this.myWord[0] = ' ';
    }

    public MyWord(char[] myWord){
        this.myWord = new char[myWord.length];
        for (int i = 0; i < myWord.length; i++) {
            this.myWord[i] = myWord[i];
        }
    }


    public char[] getMyWord() {
        return myWord;
    }

    @Override
    public int compareTo(MyWord o) {
        int myWordSorter = 0;
        char[] wordToCompare = o.getMyWord();
        char c1 = this.myWord[0];
        char c2 = wordToCompare[0];
        //Code to help ignore casing by converting local variables c1 and c2 to lowercase
        if(c1 > 64 && c1 < 91) {
            c1 += 32;
        }
        if(c2 > 64 && c2 < 91){
            c2 += 32;
        }
        if(c1 != c2){
            myWordSorter = c2-c1;
        }
        return myWordSorter;
    }

    @Override
    public String toString(){
        String out = "";
        for (int i = 0; i < this.myWord.length; i++) {
            out = out + this.myWord[i];
        }
        return out;
    }
}