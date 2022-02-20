package homework7;

import java.util.Set;

public interface EatObservable {
    void subscribe(PlateObserver somebody);
    void unsubscribe(PlateObserver somebody);
    void callAll(Set<PlateObserver> all);
    boolean decreaseFood(int amount);
}