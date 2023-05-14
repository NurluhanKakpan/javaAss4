public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];

        while (node !=null) {
            if (node.key.equals(key)) {
                node.value=value;
                return;
            }
            node=node.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next=chainArray[index];
        chainArray[index]=newNode;
        size++;
    }
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];

        while (node !=null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node=node.next;
        }
        return null;
    }
}