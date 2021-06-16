package euro2022;

public class GameService {
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public String biggestGoalDifference() {
        Game result = repository.biggestGoalDifference();
        return result.getFirstCountry() + " : " + result.getSecondCountry();
    }

    public int goalsCountry(String country) {
        return repository.goalsCountry(country);
    }

    public String maxGoalsCountry() {
        return repository.maxGoalsCountry();
    }
}
