package homework6;

public class Dog extends Animal {

    private static int count = 0;

    public Dog(String name) {
        super(name, 500, 10);
        count++;
    }

    @Override
    public boolean run(int distance) {
        boolean isSuccess = distance <= limitRun;
        System.out.printf("Собака %s %s %d м%n", name, isSuccess ? "пробежала" : "не смогла пробежать", distance);
        return isSuccess;
    }

    @Override
    public boolean swim(int distance) {
        boolean isSuccess = distance <= limitSwim;
        System.out.printf("Собака %s %s %d м%n", name, isSuccess ? "проплыла" : "не смогла проплыть", distance);
        return isSuccess;
    }

    @Override
    public String info() {
        return String.format("Собака %s бегает %d м, плавает %d м", name, limitRun, limitSwim);
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