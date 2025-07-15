import java.util.*;

public class HashmapCode {

    static class HashMapCustom<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // total number of key-value pairs
        private int bucketCount;
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMapCustom() {
            this.bucketCount = 4;
            this.buckets = (LinkedList<Node>[]) new LinkedList[bucketCount];
            for (int i = 0; i < bucketCount; i++) {
                buckets[i] = new LinkedList<>();
            }
            this.size = 0;
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % bucketCount;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            bucketCount = 2 * bucketCount;
            buckets = (LinkedList<Node>[]) new LinkedList[bucketCount];

            for (int i = 0; i < bucketCount; i++) {
                buckets[i] = new LinkedList<>();
            }

            size = 0; // reset size and reinsert all nodes
            for (LinkedList<Node> ll : oldBuckets) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                size++;
            }

            double loadFactor = (double) size / bucketCount;
            if (loadFactor > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key){
          int bi=hashFunction(key);
          LinkedList<Node> ll=buckets[bi];
          for (int i = 0; i < ll.size(); i++) {
              Node n= ll.get(i);
              if (n.key.equals(key))
              {
                return true;
              }
          }
          return false;
        }

        public V get(K key){
              int bi = hashFunction(key);
            int di = searchInLL(key, bi);
         V value;
            if (di != -1) {
               value=buckets[bi].get(di).value;
          
                return value;
            } else {
              System.out.println("Not found");
               return null;
            }
        }

        public V remove(K key){
           int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
           
               size--;
             Node n= buckets[bi].remove(di);
             return n.value;
             
               
            } else {
               System.out.println("Key does not exist");
               return null;
            }
        }
        
        public Set<K> keySet() {
            Set<K> keys = new HashSet<>();
            for (LinkedList<Node> ll : buckets) {
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }


    
    }

    public static void main(String[] args) {
        HashMapCustom<String, Integer> map = new HashMapCustom<>();

        map.put("Apple", 3);
        map.put("Banana", 5);
        map.put("Mango", 7);
        map.put("Apple", 10); 

        Set<String> keys= map.keySet();
        for (String string : keys) {
          System.out.println(string+"--"+ map.get(string));
        }

        
    }
}
