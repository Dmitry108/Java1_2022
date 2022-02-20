package homework7;

public class Cat implements PlateObserver {

    private static final int minClassAppetite = 3;
    private static final int maxClassAppetite = 10;

    private final String name;
    private final int appetite;
    private int satiety;
    private EatObservable foodPlace;

    public Cat(String name) {
        this.name = "Кот " + name;
        this.appetite = (int) (Math.random() * (maxClassAppetite - minClassAppetite) + minClassAppetite);
        this.satiety = 0;
        foodPlace = null;
    }

    private boolean isSatiated() {
        return satiety > 0;
    }

    public void tryToEat(EatObservable plate) {
        if (foodPlace == null) foodPlace = plate;
        if (plate.decreaseFood(appetite)) {
            satiety = appetite;
            System.out.printf("%s съел %d и стал сытым)%n", name, appetite);
            plate.unsubscribe(this);
        } else {
            System.out.printf("%s остался голодным, еды не хватило!%n", name);
            plate.subscribe(this);
        }
    }

    public void call(EatObservable plate) {
        tryToEat(plate);
    }

    @Override
    public String toString() {
        return String.format("%s с аппетитом %d %s (сытость %d)%n", name, appetite, isSatiated() ? "сытое" : "голодное", satiety);
    }

    public void decrementSatiety() {
        int value = satiety - 1;
        if (value >= 0) {
            satiety = value;
            if (value == 0) {
                System.out.printf("%s проголодался!%n", name);
                if (foodPlace != null) {
                    tryToEat(foodPlace);
                } else {
                    System.out.printf("%s: \"Мяу! МяяЯЯЯЯЯн!!!\"", name);
                }
            }
        } else satiety = 0;
    }
}