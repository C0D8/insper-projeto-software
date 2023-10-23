package com.insper.partida.game.exception;

public class TeamEqualsException extends RuntimeException {

    public  TeamEqualsException() {
        super("Times não podem ser iguais!");
    }

}
