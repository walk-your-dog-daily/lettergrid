package com.example.lettergrid.model;

public class LetterGridRequest {
    private String letter;
    private int size;

    public LetterGridRequest(){
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
