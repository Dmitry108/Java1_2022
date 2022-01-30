package homework3;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public class HomeworkApp {
    private static final Random random = new Random();

    public static void main(String[] args) {
        //task 1
        int[] a = {1, 0, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(a));
        revertValuesInBinaryArray(a);
        System.out.println(Arrays.toString(a));
        //task 2
        int[] b = createNaturalNumbersArray(100);
        System.out.println(Arrays.toString(b));
        //task 3
        int[] c = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(c));
        doDoubleSmallNumbers(c, 6);
        System.out.println(Arrays.toString(c));
        //task 4
        int[][] d = getArrayWithDiagonalsFilledByNumber(random.nextInt(18) + 3, 1);
        System.out.print(getString(d));
        //task 5
        int n = random.nextInt(18) + 3;
        int[] e = createIntArrayWithInitialValue(n, n);
        System.out.println(Arrays.toString(e));
        //task 6
        int[] f = c;
        int[] minMax = findMinMax(f);
        System.out.printf("В массиве %s минимальное значение %d, максимальное %d\n",
                Arrays.toString(f), minMax[0], minMax[1]);
        //task 7
        int[][] g = {{2, 2, 2, 1, 2, 2, 10, 1},
                {1, 1, 1, 2, 1},
                {1, 2, 3, 4, 5, 10, 8},
                {1, 2, 6, 4, 5, 10, 8}};
        for (int[] gi : g) {
            System.out.printf("Массив %s %sсбалансированный\n",
                    Arrays.toString(gi), checkBalance(gi) ? "" : "не");
        }
        //task 8
        for (int i = 1; i < 5; i++) {
            int[] h = {1, 2, 3, 4, 5, 6, 7};
            shiftArray(h, i);
            System.out.println(i + " - " + Arrays.toString(h));
        }
        for (int i = -1; i > -5; i--) {
            int[] h = {1, 2, 3, 4, 5};
            shiftArray(h, i);
            System.out.println(i + " - " + Arrays.toString(h));
        }
    }

    /**
     * Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void revertValuesInBinaryArray(int[] array) {
        for (int i = 0; i < array.length; array[i++] ^= 1);
    }

    /**
     * Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
     */
    public static int[] createNaturalNumbersArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; array[i++] = i);
        return array;
    }

    /**
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static void doDoubleSmallNumbers(int[] array, int bigNumber) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < bigNumber) array[i] *= 2;
        }
    }

    /**
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами.
     */
    public static int[][] getArrayWithDiagonalsFilledByNumber(int size, int num) {
        int[][] array = new int[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                array[i][j] = i == j || i + j == size - 1 ? 1 : 0;
//            }
//        } //сложность O(n^2)
        for (int i = 0; i < size; i++) {
            array[i][i] = num;
            array[i][size - i - 1] = num;
        } //сложность O(n)
        return array;
    }

    public static String getString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int[] arr : array) {
            for (int a : arr) {
                sb.append(a).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     * Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
     * типа int длиной len, каждая ячейка которого равна initialValue;
     */
    public static int[] createIntArrayWithInitialValue(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; array[i++] = initialValue);
        return array;
    }

    /**
     * Задать одномерный массив и найти в нем минимальный и максимальный элементы
     *
     * @return возвращает массив, где минимальный элемент с индексом 0, максимальный - с индексом 1
     */
    public static int[] findMinMax(int[] array) {
        int[] stat = {array[0], array[0]};
        for (int i = 1; i < array.length; i++) {
            if (stat[0] > array[i]) stat[0] = array[i];
            if (stat[1] < array[i]) stat[1] = array[i];
        }
        return stat;
    }

    /**
     * Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
     * если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
     * checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
     */
    public static boolean checkBalance(int[] array) {
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        int half = 0;
        for (int i = 0; i < array.length; i++) {
            half += array[i];
            sum -= array[i];
            if (half == sum) {
                return true;
            }
        }
        return false;
    }

    /**
     * Написать метод, которому на вход подается одномерный массив
     * и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива
     * на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
     * при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
     */
    public static void shiftArray(int[] array, int shift) {
        if (shift % array.length == 0) return;
        for (int k = 0; k < abs(shift); k++) {
            for (int i = 0; i < array.length; i++) {
                int next = (array.length + (shift > 0 ? 1 : -1) * (i + 1)) % array.length;
                int temp = array[next];
                array[next] = array[0];
                array[0] = temp;
            }
        }
    }
}