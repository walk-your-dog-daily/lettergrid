package com.example.lettergrid.controller;

import com.example.lettergrid.service.LetterPrinter;
import com.example.lettergrid.model.LetterGridRequest;
import com.example.lettergrid.service.XLetterService;
import com.example.lettergrid.service.YLetterService;
import com.example.lettergrid.service.ZLetterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/v1/lettergrid")
public class LetterGridController {
    private final Map<Character, LetterPrinter> letterServices = new HashMap<>();
    public LetterGridController(XLetterService xLetterService,
                                YLetterService yLetterService,
                                ZLetterService zLetterService) {
        letterServices.put('x', xLetterService);
        letterServices.put('y', yLetterService);
        letterServices.put('z', zLetterService);
    }

    @PostMapping
    public ResponseEntity<String> generateLetterGrid(@RequestBody LetterGridRequest request) {
        String letters = request.getLetter().toLowerCase();
        int size = request.getSize();

        if (!letters.matches("[xyz]+")) {
            return ResponseEntity.badRequest().body("Invalid letters. Only X, Y, Z are allowerd.");
        }

        if (size <= 3 || size % 2 == 0) {
            ResponseEntity.badRequest().body("Invalid size. Size should be odd number greater than 3.");
        }

        Set<Character> uniqueLetters = new HashSet<>();
        for (char letter : letters.toCharArray()){
            uniqueLetters.add(letter);
        }

        StringBuilder result = new StringBuilder();
        for (char letter : uniqueLetters) {
            LetterPrinter service = letterServices.get(letter);
            if (service != null) {
                result.append(service.printGrid(size));
                result.append("\n");
            }

        }

        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }

}
