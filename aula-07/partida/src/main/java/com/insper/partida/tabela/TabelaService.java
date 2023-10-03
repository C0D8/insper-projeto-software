package com.insper.partida.tabela;

import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.TeamService;
import com.insper.partida.equipe.dto.TeamReturnDTO;
import com.insper.partida.game.Game;
import com.insper.partida.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TabelaService {

    @Autowired
    private TeamService teamService;



    @Autowired
    private TabelaRepository tabelaRepository;

    public List<Tabela> getTabelas(){
        return tabelaRepository.findAll();
    }


    public Tabela getTabela(String time){


        Team time1 = teamService.getTeam(time);

//        TeamReturnDTO time_1 = TeamReturnDTO.covert(time1);

        Tabela t = tabelaRepository.findByNome(time1.getIdentifier());

        return t;

    }
    public void saveTabela1 (Tabela tab){
        tabelaRepository.save(tab);
    }
    public void saveTabela(Game game, Tabela tabela, String time ) {


        Team time1 = teamService.getTeam(time);


        TeamReturnDTO time_1 = TeamReturnDTO.covert(time1);


        tabela.setPontos(tabela.getPontos() + verificaResultado(time_1, game));
        tabela.setVitorias(tabela.getVitorias() + (verificaVitorias(time_1, game) ? 1 : 0));
        tabela.setDerrotas(tabela.getDerrotas() + (verificaDerrotas(time_1, game) ? 1 : 0));
        tabela.setEmpates(tabela.getEmpates() + (verificaEmpates(time_1, game) ? 1 : 0));
        tabela.setGolsPro(tabela.getGolsPro() + verificaGolsPro(time_1, game));
        tabela.setGolsContra(tabela.getGolsContra()  + verificaGolsContra(time_1, game));
        tabela.setJogos(tabela.getJogos() + 1);
        saveTabela1(tabela);

    }

    public Integer verificaResultado(TeamReturnDTO time, Game game) {
        if (game.getScoreHome() == game.getScoreAway()) {
            return 1;
        }
        if (game.getHome().equals(time.getIdentifier()) && game.getScoreHome() > game.getScoreAway()) {
            return 3;
        }
        if (game.getAway().equals(time.getIdentifier()) && game.getScoreAway() > game.getScoreHome()) {
            return 3;
        }
        return 0;
    }

    private Integer verificaGolsPro(TeamReturnDTO time, Game game) {
        if (game.getHome().equals(time.getIdentifier())) {
            return game.getScoreHome();
        }
        return game.getScoreAway();
    }

    private Integer verificaGolsContra(TeamReturnDTO time, Game game) {
        if (game.getHome().equals(time.getIdentifier())) {
            return game.getScoreAway();
        }
        return game.getScoreHome();
    }

    private boolean verificaVitorias(TeamReturnDTO time, Game game) {
        if (game.getHome().equals(time.getIdentifier()) && game.getScoreHome() > game.getScoreAway()) {
            return true;
        }
        if (game.getAway().equals(time.getIdentifier()) && game.getScoreAway() > game.getScoreHome()) {
            return true;
        }
        return false;
    }

    private boolean verificaDerrotas(TeamReturnDTO time, Game game) {
        if (game.getHome().equals(time.getIdentifier()) && game.getScoreHome() < game.getScoreAway()) {
            return true;
        }
        if (game.getAway().equals(time.getIdentifier()) && game.getScoreAway() < game.getScoreHome()) {
            return true;
        }
        return false;
    }

    private boolean verificaEmpates(TeamReturnDTO time, Game game) {
        if (game.getScoreHome() == game.getScoreAway()) {
            return true;
        }
        return false;
    }



}
