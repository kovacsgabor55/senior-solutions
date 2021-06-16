package euro2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameRepository {
    private final List<Game> games;

    public GameRepository() {
        games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void addGameToFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            games.add(parseGame(line));
        }
    }

    private Game parseGame(String line) {
        String[] parts = line.split(";");
        return new Game(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
    }

    public List<Game> getGames() {
        return new ArrayList<>(games);
    }

    public Game biggestGoalDifference() {
        if (games.isEmpty()) {
            throw new IllegalStateException("No game found!");
        }
        Game result = null;
        int maxDifferent = -1;
        for (Game item : games) {
            int tmp = Math.abs(item.getFirstCountryScore() - item.getSecondCountryScore());
            if (maxDifferent < tmp) {
                maxDifferent = tmp;
                result = item;
            }
        }
        return result;
    }

    public int goalsCountry(String country) {
        int result = 0;
        for (Game item : games) {
            if (item.getFirstCountry().equals(country)) {
                result += item.getFirstCountryScore();
            }
            if (item.getSecondCountry().equals(country)) {
                result += item.getSecondCountryScore();
            }
        }
        return result;
    }

    public String maxGoalsCountry() {
        if (games.isEmpty()) {
            throw new IllegalStateException("No game found!");
        }
        Set<String> countries = new HashSet<>();
        for (Game item : games) {
            countries.add(item.getFirstCountry());
            countries.add(item.getSecondCountry());
        }
        String result = null;
        int tmp = -1;
        for (String item : countries) {
            int actual = goalsCountry(item);
            if (tmp < actual) {
                tmp = actual;
                result = item;
            }
        }
        return result;
    }
}
