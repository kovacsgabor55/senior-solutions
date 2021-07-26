package euro2022;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {

    GameRepository gameRepository;

    @BeforeEach
    void init() {
        gameRepository = new GameRepository();

    }

    @Test
    void addGame() {
        GameRepository gameRepository=new GameRepository();
        Game game = new Game("Turkey", "Italy", 0, 3);
        gameRepository.addGame(game);
        assertEquals(1, gameRepository.getGames().size());
        assertEquals("Turkey", gameRepository.getGames().get(0).getFirstCountry());
        assertEquals("Italy", gameRepository.getGames().get(0).getSecondCountry());
        assertEquals(0, gameRepository.getGames().get(0).getFirstCountryScore());
        assertEquals(3, gameRepository.getGames().get(0).getSecondCountryScore());
    }

    @Test
    void addGameToFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(GameRepositoryTest.class.getResourceAsStream("/results.csv")));
        gameRepository.addGameToFile(reader);
        assertEquals(15, gameRepository.getGames().size());
    }

    @Test
    void biggestGoalDifference() {
        System.out.println(gameRepository.biggestGoalDifference());
    }

    @Test
    void goalsCountry() {
        System.out.println(gameRepository.goalsCountry("Italy"));
    }

    @Test
    void maxGoalsCountry() {
        System.out.println(gameRepository.maxGoalsCountry());
    }
}