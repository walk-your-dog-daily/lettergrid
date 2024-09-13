package com.example.lettergrid.service;
import org.springframework.stereotype.Service;
@Service
public class YLetterService implements LetterPrinter {
    @Override
    public String printGrid(int size) {
        StringBuilder grid = new StringBuilder();
        int middle = size / 2;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // Conditions for drawing 'Y':
                // 1. Top part diagonal (line from top-left to middle)
                // 2. Bottom part vertical line
                if (row < middle && (col == row || col == (size - row - 1))) {
                    grid.append("*");
                } else if (row >= middle && col == middle) {
                    grid.append("*");
                } else {
                    grid.append(" ");
                }
            }
            grid.append("\n");
        }
        return grid.toString();
    }
}