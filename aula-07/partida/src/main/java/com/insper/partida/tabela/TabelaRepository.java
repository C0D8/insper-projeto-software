package com.insper.partida.tabela;


import com.insper.partida.equipe.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaRepository extends MongoRepository<Tabela, String> {

    Tabela findByNome(String nome);

}
