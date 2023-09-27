package com.vitaly.tictactoe;

import java.util.Arrays;

public class Field {
    private final String[] field = new String[9];

    public Field() {
        Arrays.fill(this.field, PlayerSymbol.BLANK.getValue());
    }

    public String[] getField() {
        return field;
    }



    public void printField() {
        System.out.println(field[0] +"|"+ field[1] + "|"+ field[2]);
        System.out.println("-----");
        System.out.println(field[3] +"|"+ field[4] +"|"+ field[5]);
        System.out.println("-----");
        System.out.println(field[6] +"|"+ field[7] + "|"+ field[8]);
    }

    public enum PlayerSymbol{
        X("X"),
        O("O"),
        BLANK("*");
        private final String value;
        PlayerSymbol(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }

    }

}
