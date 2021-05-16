
import java.util.Arrays;

public class MyHashMap {
    private final int DEFAULT_SIZE = 16;

    private Node [] nodes = new Node[DEFAULT_SIZE];
    private int capacity = DEFAULT_SIZE;
    private double loadFactor = 0.75;
    private int countOfKeys = 0;


    public long get(int k){
        int index = Math.abs(k) % capacity;
        for(int i=index; ; i=(i+1)%capacity){
            if(nodes[i] != null && nodes[i].getKey() == k){
                return nodes[i].value;
            } else if (nodes[i] == null){
                return 0;
            }
        }
    }

    public boolean remove(int k){
        int index = Math.abs(k) % capacity;
        for(int i=index; ; i=(i+1)%capacity){
            if(nodes[i] != null && nodes[i].getKey() == k){
                nodes[i].setEmptyAfterRemove(true);
                countOfKeys--;
                return true;
            } else if (nodes[i] == null){
                return false;
            }
        }
    }

    public void put(int k, long v){
        int index = Math.abs(k) % capacity;
        for(int i=index; ; i=(i+1)%capacity){
            if(nodes[i] == null){
                nodes[i] = new Node(k,v);
                countOfKeys++;
                break;
            } else if(nodes[i].isEmptyAfterRemove() == true){
                nodes[i] = new Node(k,v);
                countOfKeys++;
                break;
            }
        }
        if(countOfKeys >= loadFactor*capacity){
            this.createNewLargerArray();
        }
    }

    public int size(){ return countOfKeys; }

    private void createNewLargerArray(){
        int oldCapacity = capacity;

        Node [] oldNodes = Arrays.copyOf(nodes, capacity);

        capacity = capacity*2;
        countOfKeys = 0;
        nodes = new Node[capacity];

        for(int i=0; i<oldCapacity; i++){
            if(oldNodes[i] != null){
                put(oldNodes[i].getKey(), oldNodes[i].getValue());
            }
        }
    }

    public int getDEFAULT_SIZE() {
        return DEFAULT_SIZE;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(double loadFactor) {
        this.loadFactor = loadFactor;
    }

    public int getCountOfKeys() {
        return countOfKeys;
    }


    public Node[] getNodes() {
        return nodes;
    }

    public class Node {
        private int key;
        private long value;

        private boolean emptyAfterRemove;

        public int getKey() {
            return key;
        }

        public Node(int key, long value) {
            this.key = key;
            this.value = value;
        }

        public Node(boolean emptyAfterRemove) {
            this.emptyAfterRemove = emptyAfterRemove;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public boolean isEmptyAfterRemove() {
            return emptyAfterRemove;
        }

        public void setEmptyAfterRemove(boolean emptyAfterRemove) {
            this.emptyAfterRemove = emptyAfterRemove;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", emptyAfterRemove=" + emptyAfterRemove +
                    '}';
        }
    }
}

