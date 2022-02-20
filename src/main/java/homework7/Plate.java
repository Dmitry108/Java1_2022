package homework7;

import java.util.LinkedHashSet;
import java.util.Set;

public class Plate implements EatObservable {

    private final int volume;
    private int food;
    private final Set<PlateObserver> queue;

    public Plate(int volume) {
        this.volume = volume;
        this.food = 0;
        queue = new LinkedHashSet<>();
    }

    public int getVolume() {
        return this.volume;
    }

    public void fillWhole() {
        food = volume;
        System.out.println("Тарелка наплнена до краев");
        info();
        callAll(new LinkedHashSet<>(queue));
    }

    public void addSomeFood(int amount) {
        if (food + amount > volume) {
            System.out.printf("%d в тарелке не поместится!%n", amount);
        } else {
            food += amount;
            System.out.printf("В тарелку добавлено %d еды%n", amount);
            info();
            callAll(new LinkedHashSet<>(queue));
        }
    }

    @Override
    public boolean decreaseFood(int amount) {
        boolean isPossible = food >= amount;
        if (isPossible) {
            food -= amount;
        }
        return isPossible;
    }

    private void info() {
        System.out.printf("В тарелке %d еды%n", food);
    }

    @Override
    public void subscribe(PlateObserver observer) {
        queue.add(observer);
    }

    @Override
    public void unsubscribe(PlateObserver observer) {
        queue.remove(observer);
    }

    @Override
    public void callAll(Set<PlateObserver> all) {
        all.forEach(it -> it.call(Plate.this));
    }
}