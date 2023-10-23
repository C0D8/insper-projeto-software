package com.insper.partida.equipe.exception;

public class TeamNotExistsException extends RuntimeException {

    public  TeamNotExistsException() {
        super("Não existe time!");
    }

}
