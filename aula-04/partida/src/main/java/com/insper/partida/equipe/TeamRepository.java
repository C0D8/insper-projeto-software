package com.insper.partida.equipe;

<<<<<<< HEAD
//import org.springframework.data.jpa.repository.JpaRepository;
=======
>>>>>>> 1a4b4e0f12da106c0f47ae1a30c67f27995c4e35
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
    Team findByIdentifier(String identifier);
}
