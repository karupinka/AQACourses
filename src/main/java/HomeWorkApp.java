public class HomeWorkApp {
    public static void main(String[] args) {
        // Task - 12 + * + **
        HomeWorkGame game = new HomeWorkGame(3, 3);
        game.gamePlay();
        // Task - 6
        int[] binaryArray = new int[]{ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < binaryArray.length; i++) {
            binaryArray[i] = (binaryArray[i] == 1) ? 0 : 1;
        }

        // Task - 7
        int[] emptyArr = new int[100];

        for (int i = 0; i < emptyArr.length; i++) {
            emptyArr[i] = (i + 1);
        }

        // Task - 8
        int[] taskEightArray = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < taskEightArray.length; i++) {
            if (taskEightArray[i] < 6) {
                taskEightArray[i] *= 2;
            }
        }

        // Task - 9
        int[][] taskNineArray = {{ 1, 5, 3 }, {1, 5, 3}};
        int diagonalSum = 0;

        for (int i = 0; i < taskNineArray.length; i++) {
            for (int j = 0; j < taskNineArray[i].length; j++) {
                if (i == j) {
                    diagonalSum += taskNineArray[i][j];
                }
            }
        }

        // Task - 10 *
        int[] taskElevenArray = new int[]{ 1, 5, 39, 2, 11, -4, 5, 2, 4, 8, 9, 1 };
        int min = minElement(taskElevenArray);
        int max = maxElement(taskElevenArray);

        //check methods for debug
        System.out.println(isSumBetweenTenAndTwenty(10, 10));

        printNegativeOrPositiveNumber(-100);
        printNegativeOrPositiveNumber(0);

        System.out.println(isNegativeNumber(-12));

        System.out.println(isLeapYear(2000));

        int[] arr2 = fillArray(6, 3);

        printStringNTimes("text", 5);

        int[] arr = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(isRigthSumEqualsLeft(arr));

        displacesArrayIndex(arr, 3);
    }

    // Task - 1
    public static boolean isSumBetweenTenAndTwenty(int firstNumber, int secondNumber) {
        return ((firstNumber + secondNumber) >= 10 && (firstNumber + secondNumber) <= 20);
    }

    // Task - 2
    public static void printNegativeOrPositiveNumber(int number) {
        String resultString = number >= 0 ? "положительное" : "отрицательное";
        System.out.println(resultString);
    }

    // Task - 3
    public static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    // Task - 4
    public static void printStringNTimes(String string, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(string);
        }
    }

    // Task - 4 *
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    // Task - 10
    public static int[] fillArray(int len, int initialValue) {
        int[] tmpArray;
        if (len < 1) return new int[0];

        tmpArray = new int[len];
        for (int i = 0; i < tmpArray.length; i++) {
            tmpArray[i] = initialValue;
        }
        return tmpArray;
    }

    // Task - 10 *. First method
    public static int maxElement(int[] array) {
        int maxElement = Integer.MIN_VALUE;
        for (int elementNumber : array) {
            if (maxElement < elementNumber) {
                maxElement = elementNumber;
            }
        }
        return maxElement;
    }

    // Task - 10 *. Second method
    public static int minElement(int[] array) {
        int minElement = Integer.MAX_VALUE;
        for (int elementNumber : array) {
            if (minElement > elementNumber) {
                minElement = elementNumber;
            }
        }
        return minElement;
    }

    // Task - 10 **
    public static boolean isRigthSumEqualsLeft(int[] array) {
        if (array.length == 0)
            return false;
        int totalSum = 0;
        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }

        for (int i = 0; i < array.length; i++) {
            leftSum += array[i];
            if ((totalSum - leftSum) == leftSum)
                return true;
        }
        return false;
    }

    // Task - 12 ***
    public static void displacesArrayIndex(int[] array, int index) {
        boolean left = index < 0 ? true : false;
        int indexPositive = Math.abs(index);
        for (int i = 0; i < indexPositive; i++) {
            int tmp = 0;
            int tmpSecond = 0;
            if (left) {
                for (int j = array.length - 1; j >= 0; j--) {
                    if (j == 0) {
                        array[array.length - 1] = tmp;
                    } else if(j == array.length - 1) {
                        tmp = array[j-1];
                        array[j-1] = array[j];
                    } else {
                        tmpSecond = array[j-1];
                        array[j-1] = tmp;
                        tmp = tmpSecond;
                    }
                }
            } else {
                for (int j = 0; j < array.length; j++) {
                    if (j == array.length - 1) {
                        array[0] = tmp;
                    } else if(j == 0) {
                        tmp = array[j+1];
                        array[j+1] = array[j];
                    } else {
                        tmpSecond = array[j+1];
                        array[j+1] = tmp;
                        tmp = tmpSecond;
                    }
                }
            }
        }
    }
}
