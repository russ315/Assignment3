import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(100); // 100 бакетов

        Random random = new Random();

        // Добавляем 10000 случайных элементов
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000);
            String name = generateRandomName(random);
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student("Student_" + i, random.nextInt(18, 30));
            table.put(key, value);
        }

        // Выводим размер каждой цепочки
        System.out.println("Bucket sizes:");
        for (int i = 0; i < 100; i++) {

            System.out.println("Bucket " + i + ": " + table.getBucketSize(table.getChainArray()[i]) + " elements");
        }


    }

    private static String generateRandomName(Random random) {
        int length = random.nextInt(5, 10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + random.nextInt(26));
            sb.append(c);
        }
        return sb.toString();
    }

}