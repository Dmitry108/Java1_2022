package homework6;

public abstract class Animal implements Runnable, Swimmable {

    protected final String name;
    protected int limitRun;
    protected int limitSwim;

    private static int count = 0;

    public Animal(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.limitRun = (int) (Math.random() * maxRun);
        this.limitSwim = (int) (Math.random() * maxSwim);
        count++;
    }

    public abstract String info();

    public final String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

    protected void finalize() {
        count--;
    }
}