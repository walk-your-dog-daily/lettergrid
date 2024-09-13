package com.example.lettergrid.service;

import org.springframework.stereotype.Service;

@Service
public class XLetterService implements LetterPrinter {

    @Override
    public String printGrid(int size){
        StringBuilder grid = new StringBuilder();

        for(int row = 0; row < size; row++) {
            for(int col =0; col < size; col++){
                if(row == col || row + col == size - 1)  {
                    grid.append("*");
                }
                else {
                    grid.append(" ");
                }
            }
            grid.append("\n");
        }
        return grid.toString();
    }
}
