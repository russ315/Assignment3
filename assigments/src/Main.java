public class Main {
    public static void main(String[] args) {
        var table = new MyHashTable<Integer,String>();
        table.put(1,"one");
        table.put(2,"two");
        table.put(3,"three");
        table.put(4,"four");
        table.put(5,"five");
        table.put(6,"six");
        table.put(7,"seven");
        table.put(8,"eight");

        System.out.println(table.getKey("three"));

        System.out.println(table.contains(12));
        System.out.println(table.get(6));


    }
}