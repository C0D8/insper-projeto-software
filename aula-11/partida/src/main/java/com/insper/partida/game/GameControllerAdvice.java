package com.insper.partida.game;
import com.insper.partida.common.ErrorDTO;
import com.insper.partida.game.exception.GameNotExistsException;
import com.insper.partida.game.exception.SomeTeamNotExists;
import com.insper.partida.game.exception.TeamEqualsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GameControllerAdvice {


        @ExceptionHandler(GameNotExistsException.class)
        @ResponseBody
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ErrorDTO GameNotExistsException(GameNotExistsException ex) {
            ErrorDTO error = new ErrorDTO();
            error.setMessage(ex.getMessage());
            error.setCode(400);
            error.setTime(LocalDateTime.now());
            return error;
        }


        @ExceptionHandler(SomeTeamNotExists.class)
        @ResponseBody
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ErrorDTO SomeTeamNotExists(SomeTeamNotExists ex) {
            ErrorDTO error = new ErrorDTO();
            error.setMessage(ex.getMessage());
            error.setCode(400);
            error.setTime(LocalDateTime.now());
            return error;
        }


    @ExceptionHandler(TeamEqualsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO TeamEqualsException(TeamEqualsException ex) {
        ErrorDTO error = new ErrorDTO();
        error.setMessage(ex.getMessage());
        error.setCode(400);
        error.setTime(LocalDateTime.now());
        return error;
    }


}
