package com.example.lettergrid.service;

import org.springframework.stereotype.Service;

@Service
public class ZLetterService implements LetterPrinter {

    @Override
    public String printGrid(int size){
        StringBuilder grid = new StringBuilder();

        for(int row = 0; row < size; row++) {
            for(int col =0; col < size; col++){
                if(row == 0 || row == size - 1 || row + col == size - 1)  {
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
