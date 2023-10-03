package com.insper.partida.game;

import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.TeamService;
import com.insper.partida.equipe.dto.SaveTeamDTO;
import com.insper.partida.equipe.dto.TeamReturnDTO;
import com.insper.partida.game.dto.EditGameDTO;
import com.insper.partida.game.dto.GameReturnDTO;
import com.insper.partida.game.dto.SaveGameDTO;
import com.insper.partida.tabela.Tabela;
import com.insper.partida.tabela.TabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TabelaService   tabelaService;

    public Page<GameReturnDTO> listGames(String home, String away, Integer attendance, Pageable pageable) {
        if (home != null && away != null) {

            Team tHome = teamService.getTeam(home);
            Team tAway = teamService.getTeam(away);

            Page<Game> games = gameRepository.findByHomeAndAway(tHome.getIdentifier(), tAway.getIdentifier(), pageable);
            return games.map(game -> GameReturnDTO.covert(game));

        } else if (attendance != null) {
            Page<Game> games =  gameRepository.findByAttendanceGreaterThan(attendance, pageable);
            return games.map(game -> GameReturnDTO.covert(game));
        }
        Page<Game> games =  gameRepository.findAll(pageable);
        return games.map(game -> GameReturnDTO.covert(game));
    }

    public GameReturnDTO saveGame(SaveGameDTO saveGameDTO) {

        Team teamM = teamService.getTeam(saveGameDTO.getHome());
        Team teamV = teamService.getTeam(saveGameDTO.getAway());

        if (teamM == null || teamV == null) {
            return null;
        }

        Game game = new Game();
        game.setIdentifier(UUID.randomUUID().toString());
        game.setHome(teamM.getIdentifier());
        game.setAway(teamV.getIdentifier());
        game.setAttendance(0);
        game.setScoreHome(0);
        game.setScoreAway(0);
        game.setGameDate(LocalDateTime.now());
        game.setStatus("SCHEDULED");

        gameRepository.save(game);
        return GameReturnDTO.covert(game);

    }

    public GameReturnDTO editGame(String identifier, EditGameDTO editGameDTO) {

        Game gameBD = gameRepository.findByIdentifier(identifier);

        gameBD.setScoreAway(editGameDTO.getScoreAway());
        gameBD.setScoreHome(editGameDTO.getScoreHome());
        gameBD.setAttendance(editGameDTO.getAttendance());

        String time = gameBD.getHome();

        Tabela tabela = tabelaService.getTabela(gameBD.getHome());
        Tabela tabela2 = tabelaService.getTabela(gameBD.getAway());


        tabelaService.saveTabela(gameBD, tabela, gameBD.getHome());
        tabelaService.saveTabela(gameBD, tabela2, gameBD.getAway());

        gameBD.setStatus("FINISHED");

        Game game = gameRepository.save(gameBD);
        return GameReturnDTO.covert(game);
    }

    public void deleteGame(String identifier) {
        Game gameBD = gameRepository.findByIdentifier(identifier);
        if (gameBD != null) {
            gameRepository.delete(gameBD);
        }
    }

    public Integer getScoreTeam(String identifier) {
        Team team = teamService.getTeam(identifier);

        return 0;
    }

    public GameReturnDTO getGame(String identifier) {
        return GameReturnDTO.covert(gameRepository.findByIdentifier(identifier));
    }

    public void generateData() {

        String [] teams = {"botafogo", "palmeiras", "gremio", "flamengo", "fluminense", "bragantino", "atletico-mg", "athletico-pr", "fortaleza", "cuiaba", "sao-paulo",
                        "internacional", "cruzeiro", "corinthians", "goias", "bahia", "santos", "vasco", "coritiba", "america-mg"};

        for (String team : teams) {
            SaveTeamDTO saveTeamDTO = new SaveTeamDTO();
            saveTeamDTO.setName(team);
            saveTeamDTO.setStadium(team);
            saveTeamDTO.setIdentifier(team);
            Tabela tab = new Tabela();

            tab.setNome(team);
            tabelaService.saveTabela1(tab);


            Team teamDB = teamService.getTeam(team);
            if (teamDB == null) {
                teamService.saveTeam(saveTeamDTO);
            }
        }


        for (int i = 0; i < 1000; i++) {

            Integer team1 = new Random().nextInt(20);
            Integer team2 = new Random().nextInt(20);
            while  (team1 == team2) {
                team2 = new Random().nextInt(20);
            }

            Game game = new Game();
            game.setHome(teams[team1]);
            game.setAway(teams[team2]);
            game.setStadium(teams[team1]);
            game.setIdentifier(UUID.randomUUID().toString());

            gameRepository.save(game);

            EditGameDTO game_c= new EditGameDTO();

            game_c.setScoreAway(new Random().nextInt(4));
            game_c.setScoreHome(new Random().nextInt(4));
            game_c.setAttendance(new Random().nextInt(4) * 1000);


            editGame(game.getIdentifier(), game_c);

        }



    }

    public List<Game> getGameByTeam(String identifier) {
        return gameRepository.findByHomeOrAway(identifier, identifier);
    }
}
