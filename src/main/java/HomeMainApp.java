import sun.jvm.hotspot.debugger.NoSuchSymbolException;

public class HomeMainApp {

    public static void main(String[] args) {
        String array1[][] = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String array2[][] = {{"1", "2", "Test", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String array3[][] = {{"1", "4"}, {"1", "2"}};;

        try {
            System.out.println(sumOfArrayDataAndCheckSizeArray(array1));
            System.out.println(sumOfArrayDataAndCheckSizeArray(array2));
            System.out.println(sumOfArrayDataAndCheckSizeArray(array3));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Custom size Exception");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Custom data Exception");
        } catch (Exception e) {
            System.out.println("Not custom Exception");
        }
    }

    public static int sumOfArrayDataAndCheckSizeArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        checkSizeArray(array);
        int sum = sumOfArrayData(array);
        return sum;
    }

    public static void checkSizeArray(String[][] array) throws MyArraySizeException {
        if (!(array.length == 4 && array[0].length == 4)) {
            throw new MyArraySizeException("Массив размером 4х4");
        }
    }


    public static int sumOfArrayData(String[][] array) throws MyArrayDataException {
        int sum = 0;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        int tmp = Integer.parseInt(array[i][j]);
                        sum += tmp;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("MyArrayDataException", i, j);
                    } catch (Exception e) {
                        System.out.println("Something went wrong");
                    }
                }
            }
        return sum;
    }
}

class MyArraySizeException extends Exception {

    public MyArraySizeException(String errorMessage) {
        super(errorMessage);
    }
}

class MyArrayDataException extends Exception {

    public MyArrayDataException(String errorMessage, int row, int column) {
        super(String.format("%s. Row - %d, column - %d", errorMessage, row, column));
    }
}
