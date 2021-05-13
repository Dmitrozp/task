
import java.util.Arrays;

public class MyHashMap {
    private final int DEFAULT_SIZE = 16;

    private int [] key = new int[DEFAULT_SIZE];
    private long [] value = new long[DEFAULT_SIZE];
    private int capacity = DEFAULT_SIZE;
    private double loadFactor = 0.75;
    private int countOfKeys = 0;

    public long get(int k) throws Exception {
        if(k == 0){
            throw new Exception("Key is not can be 0");
        }
        int index = k % capacity;
        for(int i=index; ; i=(i+1)% capacity){
            if(key[i] == k){
                return value[i];
            } else if (key[i] == 0){
                    return 0;
                }
        }
    }

    public void put(int k, long v) throws Exception {
        if(k == 0){
            throw new Exception("Key is not can be 0");
        }
        int index = k % capacity;
        for(int i=index; ; i=(i+1)% capacity){
            if (key[i] == k){
                value[i] = v;
                break;
            } else if (key[i] == 0){
                key[i] = k;
                value[i] = v;
                countOfKeys++;
                break;
            }
        }
        if(countOfKeys >= loadFactor* capacity){
            this.createNewLargerArray();
        }
    }

    public int size(){ return countOfKeys; }

    private void createNewLargerArray() throws Exception {
        int oldCapacity = capacity;
        int [] oldArrayKey = Arrays.copyOf(key, capacity);
        long [] oldArrayValue = Arrays.copyOf(value, capacity);

        capacity = capacity *2;
        countOfKeys = 0;
        key = new int[capacity];
        value = new long[capacity];

        for(int i=0; i<oldCapacity; i++){
            if(oldArrayKey[i] != 0){
                put(oldArrayKey[i], oldArrayValue[i]);
            }
        }
    }

    public int getDEFAULT_SIZE() {
        return DEFAULT_SIZE;
    }

    public int[] getKey() {
        return key;
    }

    public void setKey(int[] key) {
        this.key = key;
    }

    public long[] getValue() {
        return value;
    }

    public void setValue(long[] value) {
        this.value = value;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public void setCountOfKeys(int countOfKeys) {
        this.countOfKeys = countOfKeys;
    }
}

