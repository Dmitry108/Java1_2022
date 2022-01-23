package homework1;

/**
 * 1. Создать пустой проект в IntelliJ IDEA, создать класс homework1.HomeWorkApp,
 * и прописать в нем метод main().
 * 2. Создайте метод printThreeWords(),
 * который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
 * 3. Создайте метод checkSumSign(),
 * в теле которого объявите две int переменные a и b,
 * и инициализируйте их любыми значениями, которыми захотите.
 * Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
 * то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
 * 4. Создайте метод printColor() в теле которого задайте int переменную value
 * и инициализируйте ее любым значением. Если value меньше 0 (0 включительно),
 * то в консоль метод должен вывести сообщение “Красный”,
 * если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно),
 * то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
 * 5. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
 * и инициализируйте их любыми значениями, которыми захотите.
 * Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
 * в противном случае “a < b”;
 */
public class HomeWorkApp {

    public static void main(String[] args) {
        HomeWorkApp homework = new HomeWorkApp();
        homework.printThreeWords();
        homework.checkSumSign();
        homework.printColor();
        homework.compareNumbers();
    }

    private int getNumber(int size, int delta) {
        return (int)(Math.random() * size - delta);
    }

    private int getNumber(int size) {
        return getNumber(size, 0);
    }

    public void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public void checkSumSign() {
        int a = getNumber(100, 50);
        int b = getNumber(100, 50);
        System.out.printf("Сумма %d + %d %s\n", a, b,
                a + b >= 0 ? "положительная" : "отрицательная");
    }

    public void printColor() {
        int value = getNumber(300, 100);
        System.out.printf("%d %s\n", value,
                value <= 0 ? "Красный" :
                        value <= 100 ? "Желтый" : "Зеленый");
    }

    public void compareNumbers() {
        int a = getNumber(100);
        int b = getNumber(100);
        System.out.printf("a = %d b = %d\na %s b", a, b,
                a >= b ? ">=" : "<");
    }
}