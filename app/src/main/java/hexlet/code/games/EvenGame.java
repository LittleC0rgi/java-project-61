package hexlet.code.games;


public final class EvenGame {

    public static void play() {
        Engine.start(EvenGame.getRule(), EvenGame::getQuestion, EvenGame::getCorrectAnswer);
    }

    public static String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static String getQuestion() {
        return String.valueOf(GameUtils.getRandomNumber());
    }

    public static String getCorrectAnswer(String question) {
        int number = Integer.parseInt(question);
        return number % 2 == 0 ? "yes" : "no";
    }
}
