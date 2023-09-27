package com.vitaly.tictactoe;

import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    private final Field field = new Field();
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();



    public void start() {
        field.printField();
        while (true) {
            Integer userInput = getUserInput();
            field.getField()[userInput - 1] = Field.PlayerSymbol.X.getValue();
            if(checkWinner(Field.PlayerSymbol.X)) break;
            Integer pcInput = getPCInput();
            field.getField()[pcInput - 1] = Field.PlayerSymbol.O.getValue();
            field.printField();
            if(checkWinner(Field.PlayerSymbol.O)) break;
        }

    }

    private Integer getUserInput() {
        System.out.println("Ваш ход! Введите номер ячейки: 1 - 9");
        Integer input = scanner.nextInt();

        while (!validateInput(input)) {
            System.out.println("Выберите другую ячейку!");
            input = scanner.nextInt();
        }

        return input;
    }

    private boolean checkWinner(Field.PlayerSymbol symbol) {
        String[] symbols = field.getField();
        int[][] winnerCombinations = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}};
        for (int[] combination : winnerCombinations) {
            if (symbols[combination[0]] == Field.PlayerSymbol.X.getValue()
                    && symbols[combination[1]] == Field.PlayerSymbol.X.getValue()
                    && symbols[combination[2]] == Field.PlayerSymbol.X.getValue()) {
                System.out.println("Вы выиграли!");
                return true;
            }
        }
                for (int[] combination : winnerCombinations) {
                    if (symbols[combination[0]] == Field.PlayerSymbol.O.getValue()
                            && symbols[combination[1]] == Field.PlayerSymbol.O.getValue()
                            && symbols[combination[2]] == Field.PlayerSymbol.O.getValue()) {
                        System.out.println("Компьютер победил!");
                        return true;
                    }
                }
               if(Arrays.asList(symbols).contains(Field.PlayerSymbol.BLANK.getValue())) {
                   return false;
               }else {
                   System.out.println("Ничья!");
                   return true;
               }

            }




    private Integer getPCInput () {
        int input;
        do{
            input = random.nextInt(9)+1;
        } while (!validateInput(input));


        return input;
    }

    private boolean validateInput(int  input) {
        return input >= 0 && input <= 9 && field.getField()[input-1] == Field.PlayerSymbol.BLANK.getValue();
    }

}

