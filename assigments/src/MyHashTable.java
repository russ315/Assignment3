public class MyHashTable<K,V> {
    private class HashNode<K,V>
    {
        private final K key;
        private V value;
        private HashNode<K,V> next;


        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "{" + key + ", " + value + '}';
        }
    }

    private final HashNode[] chainArray;
    public HashNode[] getChainArray() {
        return chainArray;
    }
    public int getBucketSize(HashNode<K,V> node) {
        int buckerSize = 0;
        while(node != null){
            node = node.next;
            buckerSize++;
        }
        return buckerSize;
    }
    private int M = 11;
    private int size = 0;
    public MyHashTable()
    {
        chainArray = new HashNode[M];
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];

    }
    public void put(K key,V value){
        var index = hash(key);
        var head = chainArray[index];
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        var newNode = new HashNode<>(key,value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;

    }
    public V get(K key){
        var index = hash(key);
        var head = chainArray[index];
        while (head != null){
            if(head.key.equals(key)){
                return (V) head.value;
            }
            head = head.next;
        }
        return null;
    }
    public void remove(K key){
        var index = hash(key);
        HashNode<K,V> head = chainArray[index];
        HashNode<K,V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    chainArray[index] = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
    public boolean contains(K key){
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    public K getKey(V value){
        for (HashNode<K, V> kvHashNode : chainArray) {
            if (kvHashNode != null && kvHashNode.value == value)
                return kvHashNode.key;
        }
        return null;
    }
    private int hash(K key){
        return Math.abs(key.hashCode() % M);
    }
}
