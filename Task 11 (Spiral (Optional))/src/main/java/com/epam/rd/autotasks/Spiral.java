package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] array = new int[rows][columns];
        int s = 1;
        for (int i = 0; i < columns; i++) {
            array[0][i] = s;
            s++;
        }
        if (rows > 1) {
            for (int i = 1; i < rows; i++) {
                array[i][columns - 1] = s;
                s++;
            }
            for (int i = columns - 2; i >= 0; i--) {
                array[rows - 1][i] = s;
                s++;
            }
            for (int i = rows - 2; i > 0; i--) {
                array[i][0] = s;
                s++;
            }
            int a = 1;
            int b = 1;
            while (s < rows * columns) {
                while (array[a][b + 1] == 0) {
                    array[a][b] = s;
                    s++;
                    b++;
                }
                while (array[a + 1][b] == 0) {
                    array[a][b] = s;
                    s++;
                    a++;
                }
                while (array[a][b - 1] == 0) {
                    array[a][b] = s;
                    s++;
                    b--;
                }
                while (array[a - 1][b] == 0) {
                    array[a][b] = s;
                    s++;
                    a--;
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (array[i][j] == 0) {
                        array[i][j] = s;
                    }
                }
            }
        }
        return array;
    }
}
