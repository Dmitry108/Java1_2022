package homework6;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Барсик"),
                new Dog("Дружок"),
                new Cat("Мурзик"),
                new Dog("Кузя"),
                new Cat("Бонифаций")
        };

        System.out.printf("Всего животных %d, котов %d, собак %d%n", Animal.getCount(), Cat.getCount(), Dog.getCount());

        for (Animal animal : animals) {
            System.out.println(animal.info());
        }

        competition(animals.clone(), "забег", 100, 600, 100,
                (animal, distance) -> animal.run(distance));

        competition(animals.clone(), "заплыв", 2, 12, 2, Animal::swim);
    }

    public static void competition(Animal[] animals, String type, int startDistance, int endDistance, int step, Racer racer) {
        System.out.printf("--- %s ---%n", type.toUpperCase());
        for (int distance = startDistance; distance <= endDistance; distance += step) {
            System.out.printf("--- %d м ---%n", distance);
            for (int i = 0; i < animals.length; i++) {
                if (animals[i] != null) {
                    if (!racer.race(animals[i], distance)) {
                        System.out.printf("%s выбывает из гонки!!!%n", animals[i].getName());
                        animals[i] = null;
                    }
                }
            }
        }
    }

    private interface Racer {
        Boolean race(Animal animal, int distance);
    }
}