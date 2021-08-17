import model.AppData;

import java.io.*;

public class HomeMainApp {
    public static void main(String[] args) {
        String[] headerArray = {"Value 1","Value 4","Value 3"};
        int[][] dataArray = {{300, 400, 500}, {300, 400, 500}};
        AppData appData = new AppData(headerArray, dataArray);
        System.out.println(appData);

        writeObject("test", appData);

        AppData appData1 = readObject("test");
        System.out.println(appData1);
    }

    public static void writeObject(String fileName, AppData appData) {
        //File file = new File(fileName + ".csv");
        File file = new File(fileName + ".csv");
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(appData);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException exception) {
            System.out.println("Problems with writing object");
        }
    }

    public static AppData readObject(String fileName) {
        File file = new File(fileName + ".csv");
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        AppData appData = null;
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            appData = (AppData) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Problems with casting object");
        } catch (IOException exception) {
            System.out.println("Problems with reading object");
        }

        return appData;
    }
}
