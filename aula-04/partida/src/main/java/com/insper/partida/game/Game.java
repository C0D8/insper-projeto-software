package com.insper.partida.game;

import com.insper.partida.equipe.Team;
//import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
//@Entity
@Document("game")
public class Game {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String identifier;

    private Integer scoreHome;

    private Integer scoreAway;
//
//    @ManyToOne
//    @JoinColumn(name = "id_home")
    private String home;

//    @ManyToOne
//    @JoinColumn(name = "id_away")
    private String away;

    private String stadium;

    private Integer attendance;

    private LocalDateTime gameDate;

    private String status;

}
