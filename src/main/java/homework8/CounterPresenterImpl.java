package homework8;

public class CounterPresenterImpl implements CounterPresenter {

    private int value = 0;
    private final CounterView view;

    public CounterPresenterImpl(CounterView view) {
        this.view = view;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void increment() {
        view.showValue(++value);
    }

    @Override
    public void decrement() {
        view.showValue(--value);
    }
}