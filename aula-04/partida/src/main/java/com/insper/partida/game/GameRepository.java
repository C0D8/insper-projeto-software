package com.insper.partida.game;

import com.insper.partida.equipe.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
<<<<<<< HEAD
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
=======
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    Game findByIdentifier(String identifier);


    Page<Game> findByHomeAndAway(Team tHome, Team tAway, Pageable pageable);

    Page<Game> findByAttendanceGreaterThan(Integer attendance, Pageable pageable);

<<<<<<< HEAD
//
//    @Query("select sum(g.scoreHome) from Game g where g.home = ?1")
//    public Integer sumScoreTeamHome(Team team);
=======

    //@Query("select sum(g.scoreHome) from Game g where g.home = ?1")
    //public Integer sumScoreTeamHome(Team team);
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
}
