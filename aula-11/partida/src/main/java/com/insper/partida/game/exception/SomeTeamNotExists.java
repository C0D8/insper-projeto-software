package com.insper.partida.game.exception;

public class SomeTeamNotExists extends  RuntimeException{

    public SomeTeamNotExists() {

        super("Algum dos times não existe!");

    }
}
