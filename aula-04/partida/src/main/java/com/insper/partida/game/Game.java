package com.insper.partida.game;

import com.insper.partida.equipe.Team;
<<<<<<< HEAD
//import jakarta.persistence.*;
=======
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
<<<<<<< HEAD
//@Entity
=======
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
@Document("game")
public class Game {

    @Id
<<<<<<< HEAD
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
    private String id;

    private String identifier;

    private Integer scoreHome;

    private Integer scoreAway;
//
//    @ManyToOne
//    @JoinColumn(name = "id_home")
    private String home;

<<<<<<< HEAD
//    @ManyToOne
//    @JoinColumn(name = "id_away")
    private String away;

=======
    private String away;

    private String home;

>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
    private String stadium;

    private Integer attendance;

    private LocalDateTime gameDate;

    private String status;

}
