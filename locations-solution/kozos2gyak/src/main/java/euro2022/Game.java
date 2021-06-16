package euro2022;

public class Game {

    private final String firstCountry;
    private final String secondCountry;
    private final int firstCountryScore;
    private final int secondCountryScore;

    public Game(String firstCountry, String secondCountry, int firstCountryScore, int secondCountryScore) {
        this.firstCountry = firstCountry;
        this.secondCountry = secondCountry;
        this.firstCountryScore = firstCountryScore;
        this.secondCountryScore = secondCountryScore;
    }

    public String winner() {
        if (firstCountryScore > secondCountryScore) {
            return firstCountry;
        } else return (secondCountryScore > firstCountryScore) ? secondCountry : "-draw-";
    }

    public String getFirstCountry() {
        return firstCountry;
    }

    public String getSecondCountry() {
        return secondCountry;
    }

    public int getFirstCountryScore() {
        return firstCountryScore;
    }

    public int getSecondCountryScore() {
        return secondCountryScore;
    }

    @Override
    public String toString() {
        return firstCountry + " : " + secondCountry + " --> " + firstCountryScore + " : " + secondCountryScore;
    }
}
