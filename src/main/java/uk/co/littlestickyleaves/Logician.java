package uk.co.littlestickyleaves;

/**
 * Gets scores, does some logic, maybe persists
 */
public class Logician {

    private ScoreProvider myScoreProvider;

    private Persister myPersister;

    public Logician(ScoreProvider scoreProvider, Persister persister) {
        myScoreProvider = scoreProvider;
        myPersister = persister;
    }

    public void handleString(String input) {
        int score;
        try {
            score = myScoreProvider.fetchScore(input);
        } catch (IllegalArgumentException e) {
            throw new LogicianException("Input '" + input + "' cannot produce score", e);
        }
        if (score > 20) {
            myPersister.store(input);
        }
    }
}
