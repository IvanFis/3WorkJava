package Seminar3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Игра Коровы и БЫКИ!");
            System.out.println("Доступные режимы игры:\n1. Числа\n2. Русский алфавит\n3. Английский алфавит\nВведи" +
                    " число: ");
            int modeGame = scanner.nextInt();
            AbstractGame ag;

            switch (modeGame) {
                case 1:
                    ag = new NumberGame();
                    break;
                case 2:
                    ag = new RuGame();
                    break;
                case 3:
                    ag = new EngGame();
                    break;
                default:
                    System.out.println("Неверный некорректный ввод!");
                    continue;
            }
            System.out.println("Выберите размер загаданного слова!");
            System.out.println("Введите значение: ");
            int sizeWordChoice = scanner.nextInt();
            System.out.println("Укажите свое кол-во попыток: ");
            int countLifeChoice = scanner.nextInt();
            ag.start(sizeWordChoice, countLifeChoice);
            System.out.println("Введите значение: ");
            Scanner value = new Scanner(System.in);

            while (ag.getGameStatus().equals(GameStatus.START)) {
                Answer answer = ag.inputValue(value.nextLine().toLowerCase());
                System.out.println(answer);
            }

            if (ag.getGameStatus().equals(GameStatus.WIN)) {
                System.out.println("Слово отгадано!");
            }


            if (ag.getGameStatus().equals(GameStatus.LOSE)) {
                System.out.println("Вы проиграли!");
                System.out.println("Загаданое слово: " + ag.getWord());
            }

            System.out.println("Посмотреть историю своей игры? (Да/Нет)");
            String printHistoryChoice = scanner.next();
            if(printHistoryChoice.equalsIgnoreCase("Да")){
                History history = ag.getHistory();
                for (String action: history.getActions()) {
                    System.out.println(action);
                }
            }
        }
    }
}


