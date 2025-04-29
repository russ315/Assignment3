import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BST<String,Integer> tree = new BST<>();
        tree.put("c", 3);
        tree.put("a", 1);
        tree.put("b", 2);
        tree.put("d", 4);

        System.out.println("Tree size = " + tree.size());
        // → Tree size = 4

        for (BST<String,Integer>.Node node : tree) {
            System.out.printf("key = %s, value = %d%n",
                    node.getKey(), node.getValue());
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