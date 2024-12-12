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
    public void setMyWord(char c, int i){
        this.myWord[i] = c;
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
    public boolean equals(Object obj) {
        MyWord o = (MyWord) obj;
        for (int i = 0; i < o.getMyWord().length; i++) {
            if(o.getMyWord()[i] > 64 && o.getMyWord()[i] < 91){
                char lowercase = (char) (o.getMyWord()[i] + 32);
                o.setMyWord(lowercase, i);
            }
        }
        for (int i = 0; i < this.myWord.length; i++) {
            if(this.myWord[i] > 64 && this.myWord[i] < 91){
                this.myWord[i] += 32;
            }
        }
        boolean equal = true;
        if(this.getMyWord().length != o.getMyWord().length){
            equal = false;
        } else {
            for (int i = 0; i < o.getMyWord().length; i++) {
                if (this.getMyWord()[i] != o.getMyWord()[i]) {
                    equal = false;
                }
            }
        }
        return equal;
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