package model;

public class Classroom {

    private short digit;
    private String word;

    public Classroom(short digit, String word) {
        this.digit = digit;
        this.word = word;
    }

    public short getDigit() {
        return digit;
    }

    public String getWord() {
        return word;
    }
}
