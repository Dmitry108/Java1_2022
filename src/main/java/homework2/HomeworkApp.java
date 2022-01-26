package homework2;

import java.security.SecureRandom;

public class HomeworkApp {

    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        HomeworkApp homework = new HomeworkApp();
        int a1 = random.nextInt(20);
        int a2 = random.nextInt(20);
        System.out.printf("Сумма чисел %d и %d в диапазоне 10..20 это %s\n", a1, a2,
                homework.isSumBetweenTenAndTwenty(a1, a2));

        int num = random.nextInt(20) - 10;
        homework.printSignOfNumber(num);

        System.out.printf("%d isNegative %s\n", num, homework.isNegativeNumber(num));

        homework.printStrings("Java", Math.abs(num));

        for (int year = 1900; year <= 2022; year++) {
            if (homework.isLeapYear(year))
                System.out.print(year + " ");
        }
        System.out.println();
    }

    /**
     * Метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
     * от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    public boolean isSumBetweenTenAndTwenty(int num1, int num2) {
//        int sum = num1 + num2;
        return (num1 += num2) >= 10 && num1 <= 20;
    }

    /**
     * Метод, которому в качестве параметра передается целое число, метод печатет в консоль,
     * положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public void printSignOfNumber(int num) {
        System.out.printf("Число %d %s\n", num,
                isNegativeNumber(num) ? "отрицательное" : "положительное");
    }

    /**
     * Метод, которому в качестве параметра передается целое число, возвращает true,
     * если число отрицательное, false - если положительное.
     */
    public boolean isNegativeNumber(int num) {
        return num < 0;
    }

    /**
     * Метод, которому в качестве аргументов передается строка и число, метод должен отпечатать
     * в консоль указанную строку, указанное количество раз.
     */
    public void printStrings(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    /**
     * Метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}