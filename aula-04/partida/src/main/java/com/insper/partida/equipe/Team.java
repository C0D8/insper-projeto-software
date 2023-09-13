package com.insper.partida.equipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insper.partida.game.Game;
<<<<<<< HEAD
//import jakarta.persistence.*;
=======
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
<<<<<<< HEAD
//@Entity
=======
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
@Document("team")
public class Team {

    @Id
<<<<<<< HEAD
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
    private String id;

    private String identifier;

    private String name;

    private String stadium;

<<<<<<< HEAD
//    @JsonIgnore
//    @OneToMany(mappedBy = "away")
//    private List<Game> away;

//    @JsonIgnore
//    @OneToMany(mappedBy = "home")
//    private List<Game> home;
=======
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
}
