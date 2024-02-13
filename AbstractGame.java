package Seminar3;

import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    private String word;
    Integer tryCount;
    GameStatus gameStatus;
    History history;

    public AbstractGame() {
        this.gameStatus = GameStatus.INIT;
        history = new History();
    }

    abstract List<String> generateCharList();

    public void start(Integer sizeWord, Integer tryCount) {
        this.word = this.generateWord(sizeWord);
        this.tryCount = tryCount;
        this.gameStatus = GameStatus.START;
    }

    private String generateWord(Integer sizeWord) {
        List<String> alphabet = this.generateCharList();
        Random rnd = new Random();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < sizeWord; ++i) {
            int randomIndex = rnd.nextInt(alphabet.size());
            res.append(alphabet.get(randomIndex));
            alphabet.remove(randomIndex);
        }

        return res.toString();
    }

    public Answer inputValue(String value) {
        if (!this.getGameStatus().equals(GameStatus.START)) {
            throw new RuntimeException("Игра не запустилась");
        } else {
            int cowCount = 0;
            int bullCount = 0;

            for(int i = 0; i < this.word.length(); ++i) {
                if (value.charAt(i) == this.word.charAt(i)) {
                    ++cowCount;
                    ++bullCount;
                } else if (this.word.contains(String.valueOf(value.charAt(i)))) {
                    ++cowCount;
                }
            }

            this.tryCount--;
            if (this.tryCount == 0) {
                this.gameStatus = GameStatus.LOSE;
            }

            if (bullCount == this.word.length()) {
                this.gameStatus = GameStatus.WIN;
            }


            history.addActions("Попытка: " + value + ", результат: " + cowCount + " коровы, " + bullCount + " быка");


            return new Answer(cowCount, bullCount, this.tryCount);
        }
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public History getHistory(){
        return history;
    }

    public String getWord() {
        return word;
    }
}