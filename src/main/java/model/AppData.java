package model;

import java.io.Serializable;

public class AppData implements Serializable {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public String[] getHeader() {
        return header;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < header.length; i++) {
            builder.append(header[i]);
            if (i != header.length - 1)
                builder.append(";");
            else
                builder.append("\n");
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                builder.append(data[i][j]);
                if (j != data[i].length - 1)
                    builder.append(";");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
