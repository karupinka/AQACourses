import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkGame {
    private char[][] gameMap;
    private final int SIZE;
    private final int DOTS_TO_WIN;
    private final char DOT_EMPTY = '•';
    private final char DOT_X = 'X';
    private final char DOT_O = 'O';
    public Scanner scanner;
    private Random random;
    private boolean needToBlock = false;
    private int xForBlock = 0;
    private int yForBlock = 0;

    public HomeWorkGame(int size, int dotsOfWin) {
        SIZE = size;
        DOTS_TO_WIN = dotsOfWin;
        gameMap = new char[SIZE][SIZE];
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                gameMap[i][j] = DOT_EMPTY;
            }
        }

        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void gamePlay() {
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (isWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            needToBlock = false;
            printMap();
            if (isWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    private void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < gameMap.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < gameMap[i].length; j++) {
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        gameMap[y][x] = DOT_X;
    }

    private boolean isCellValid(int x, int y) {
        boolean isCellValid = true;
        if(x < 0 || x > SIZE || y < 0 || y > SIZE)
            isCellValid = false;
        if (gameMap[y][x] != DOT_EMPTY)
            isCellValid = false;
        return isCellValid;
    }

    public boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameMap[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    private void aiTurn() {
        int x, y;
        do {
            if (needToBlock) {
                x = xForBlock;
                y = yForBlock;
            } else {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        gameMap[y][x] = DOT_O;
    }

    private boolean isWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            if (checkHorizontalLine(i, symb) || checkVerticalLine(i, symb)
                    || checkHorizontalDiagonalLine(i, symb) || checkVerticalDiagonalLine(i, symb)) {
                return true;
            }
            checkRevertHorizontalLine(i, symb);
            checkRevertVerticalLine(i, symb);
        }

        return false;
    }

    private boolean checkHorizontalLine(int indexOfLine, char symb) {
        int countOfSymbol = 0;

        if (indexOfLine >= 0 && indexOfLine < SIZE) {

            for (int i = 0; i < SIZE; i++) {
                if (gameMap[indexOfLine][i] == symb) {
                    countOfSymbol++;
                    if (countOfSymbol == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    if (countOfSymbol > 1 && gameMap[i][indexOfLine] == DOT_EMPTY) {
                        needToBlock = true;
                        xForBlock = i;
                        yForBlock = indexOfLine;
                    }

                    countOfSymbol = 0;
                }
            }

        }
        return false;
    }

    private void checkRevertHorizontalLine(int indexOfLine, char symb) {
        int countOfSymbol = 0;

        if (indexOfLine >= 0 && indexOfLine < SIZE) {

            for (int i = SIZE - 1; i >= 0; i--) {
                if (gameMap[indexOfLine][i] == symb) {
                    countOfSymbol++;
                } else {
                    if (countOfSymbol > 1 && gameMap[i][indexOfLine] == DOT_EMPTY) {
                        needToBlock = true;
                        xForBlock = i;
                        yForBlock = indexOfLine;
                    }
                    countOfSymbol = 0;
                }
            }

        }
    }

    private boolean checkVerticalLine(int indexOfLine, char symb) {
        int countOfSymbol = 0;

        if (indexOfLine >= 0 && indexOfLine < SIZE) {

            for (int i = 0; i < SIZE; i++) {
                if (gameMap[i][indexOfLine] == symb) {
                    countOfSymbol++;
                    if (countOfSymbol == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    if (countOfSymbol > 1 && gameMap[i][indexOfLine] == DOT_EMPTY) {
                        needToBlock = true;
                        xForBlock = indexOfLine;
                        yForBlock = i;
                    }
                    countOfSymbol = 0;
                }
            }

        }
        return false;
    }

    private void checkRevertVerticalLine(int indexOfLine, char symb) {
        int countOfSymbol = 0;

        if (indexOfLine >= 0 && indexOfLine < SIZE) {

            for (int i = SIZE - 1; i >= 0; i--) {
                if (gameMap[i][indexOfLine] == symb) {
                    countOfSymbol++;
                } else {
                    if (countOfSymbol > 1 && gameMap[i][indexOfLine] == DOT_EMPTY) {
                        needToBlock = true;
                        xForBlock = indexOfLine;
                        yForBlock = i;
                    }
                    countOfSymbol = 0;
                }
            }

        }
    }

    private boolean checkVerticalDiagonalLine(int indexOfLineVertical, char symb) {
        int countOfSymbol = 0;

        if (indexOfLineVertical >= 0 && indexOfLineVertical < SIZE) {

            for (int i = 0; i < SIZE; i++) {
                if ((indexOfLineVertical + i) < SIZE && gameMap[indexOfLineVertical + i][i] == symb) {
                    countOfSymbol++;
                    if (countOfSymbol == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    if ((indexOfLineVertical + i) < SIZE && countOfSymbol > 1 && gameMap[indexOfLineVertical + i][i] == DOT_EMPTY) {
                        needToBlock = true;
                        xForBlock = i;
                        yForBlock = indexOfLineVertical + i;
                    }
                    countOfSymbol = 0;
                }
            }
            countOfSymbol = 0;
            int j = 0;

            for (int i = indexOfLineVertical; i >= 0; i--) {
                    if (gameMap[i][j] == symb) {
                        countOfSymbol++;
                        j++;
                        if (countOfSymbol == DOTS_TO_WIN) {
                            return true;
                        }
                    } else {
                        if (countOfSymbol > 1 && gameMap[i][j] == DOT_EMPTY) {
                            needToBlock = true;
                            xForBlock = j;
                            yForBlock = i;
                        }
                        countOfSymbol = 0;
                    }
                }

            }

        return false;
    }

    private boolean checkHorizontalDiagonalLine(int indexOfLineHorizont, char symb) {
        int countOfSymbol = 0;

        if (indexOfLineHorizont >= 0 && indexOfLineHorizont < SIZE) {

            for (int i = 0; i < SIZE; i++) {
                if ((indexOfLineHorizont + i) < SIZE && gameMap[i][indexOfLineHorizont + i] == symb) {
                    countOfSymbol++;
                    if (countOfSymbol == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    if ((indexOfLineHorizont + i) < SIZE && countOfSymbol > 1 && gameMap[i][indexOfLineHorizont + i] == DOT_EMPTY) {
                        needToBlock = true;
                        xForBlock = indexOfLineHorizont + i;
                        yForBlock = i;
                    }
                    countOfSymbol = 0;
                }
            }

            countOfSymbol = 0;

            int j = 0;
            for (int i = indexOfLineHorizont; i >= 0; i--) {
                    if (gameMap[j][i] == symb) {
                        countOfSymbol++;
                        if (countOfSymbol == DOTS_TO_WIN) {
                            return true;
                        }
                    } else {
                        if (countOfSymbol > 2 && gameMap[j][i] == DOT_EMPTY) {
                            needToBlock = true;
                            xForBlock = i;
                            yForBlock = j;
                        }
                        countOfSymbol = 0;
                    }
                j++;
            }
        }
        return false;
    }
}
