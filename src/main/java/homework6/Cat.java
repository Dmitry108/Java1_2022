package homework6;

public class Cat extends Animal {

    private static int count = 0;

    public Cat(String name) {
        super(name, 200, 0);
        count++;
    }

    @Override
    public boolean run(int distance) {
        boolean isSuccess = distance <= limitRun;
        System.out.printf("Кот %s %s %d м%n", name, isSuccess ? "пробежал" : "не смогл пробежать", distance);
        return isSuccess;
    }

    @Override
    public boolean swim(int distance) {
        System.out.println("Коты не умеют плавать");
        return false;
    }

    @Override
    public String info() {
        return String.format("Кот %s бегает %d м, плавает %d м", name, limitRun, limitSwim);
    }

    public static int getCount() {
        return count;
    }

    @Override
    protected void finalize() {
        super.finalize();
        count--;
    }
}