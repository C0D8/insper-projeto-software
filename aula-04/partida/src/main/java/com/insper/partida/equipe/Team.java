package com.insper.partida.equipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insper.partida.game.Game;
//import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
//@Entity
@Document("team")
public class Team {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String identifier;

    private String name;

    private String stadium;

//    @JsonIgnore
//    @OneToMany(mappedBy = "away")
//    private List<Game> away;

//    @JsonIgnore
//    @OneToMany(mappedBy = "home")
//    private List<Game> home;
}
