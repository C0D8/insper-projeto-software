package com.insper.partida.aposta;

//import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
//@Entity
@Document("bet")
public class Bet {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private BetStatus status;
    private BetResult result;

    private String gameIdentifier;

}
