package com.insper.partida.game.exception;

public class GameNotExistsException extends  RuntimeException{

    public GameNotExistsException(){
        super("Jogo não existe");
    }
}
