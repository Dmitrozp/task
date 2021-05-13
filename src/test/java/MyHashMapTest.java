
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MyHashMapTest {

    @Test
    void process_ShouldReturnValue_WhenInputKey() throws Exception {
        MyHashMap map = new MyHashMap();
        map.put(23424,1);
        map.put(23524,2);
        map.put(2324,3);
        map.put(224,4);
        map.put(266624,5);
        map.put(298956,6);
        map.put(23254,7);
        map.put(2248,8);
        map.put(23943524,9);
        map.put(22784,10);
        map.put(266345624,11);
        map.put(293458956,12);
        map.put(2002784,13);
        map.put(2066345624,14);
        map.put(2093458956,15);

        Assertions.assertEquals(9, map.get(23943524));
    }

    @Test
    void process_ShouldReturnValueNull_WhenInputEmptyKey() throws Exception {
        MyHashMap map = new MyHashMap();
        map.put(23424,1);
        map.put(23524,2);
        map.put(2324,3);
        map.put(224,4);
        map.put(266624,5);
        map.put(298956,6);
        map.put(23254,7);
        map.put(2248,8);
        map.put(23943524,9);
        map.put(22784,10);
        map.put(266345624,11);
        map.put(293458956,12);
        map.put(2002784,13);
        map.put(2066345624,14);
        map.put(2093458956,15);

        Assertions.assertEquals(0, map.get(111111));
    }

    @Test
    void process_ShouldThrowException_WhenGetValueByKeyEqualsNull() throws IOException {
        MyHashMap map = new MyHashMap();

        Assertions.assertThrows(Exception.class, () -> map.get(0));
    }

    @Test
    void process_ShouldPutKeyAndValueInHashMapWithRightIndex_WhenInputKeyAndValue() throws Exception {
        int key = 20;
        long value = 123L;
        int index = 4;
        MyHashMap map = new MyHashMap();
        map.put(key,value);

        Assertions.assertEquals(20, map.getKey()[index]);
        Assertions.assertEquals(123L, map.getValue()[index]);
    }

    @Test
    void process_ShouldPutKeyAndValueInHashMapInNextBasket_WhenCurrentBasketIsNotEmpty() throws Exception {
        int key = 20;
        long value = 123L;
        int index = 5;
        MyHashMap map = new MyHashMap();
        map.put(key,value);
        map.put(36,366L);

        Assertions.assertEquals(36, map.getKey()[index]);
        Assertions.assertEquals(366L, map.getValue()[index]);
    }

    @Test
    void process_ShouldReSizeArrays_WhenCountOfKeysMoreLoadFactor() throws Exception {
        MyHashMap map = new MyHashMap();
        map.put(23424,1);
        map.put(23524,2);
        map.put(2324,3);
        map.put(224,4);
        map.put(266624,5);
        map.put(298956,6);
        map.put(23254,7);
        map.put(2248,8);
        map.put(23943524,9);
        map.put(22784,10);
        map.put(266345624,11);
        map.put(293458956,12);
        map.put(2002784,13);
        map.put(2066345624,14);
        map.put(2093458956,15);

        Assertions.assertEquals(32, map.getCapacity());
    }

    @Test
    void process_ShouldThrowException_WhenInputKeyEqualsNull() throws IOException {
        MyHashMap map = new MyHashMap();

        Assertions.assertThrows(Exception.class, () -> map.put(0,123L));
    }

    @Test
    void process_ShouldReturnSizeMap() throws Exception {
        MyHashMap map = new MyHashMap();
        map.put(23424,1);
        map.put(23524,2);
        map.put(2324,3);
        map.put(224,4);
        map.put(266624,5);
        map.put(298956,6);
        map.put(23254,7);
        map.put(2248,8);
        map.put(23943524,9);
        map.put(22784,10);
        map.put(266345624,11);
        map.put(293458956,12);
        map.put(2002784,13);
        map.put(2066345624,14);
        map.put(2093458956,15);

        Assertions.assertEquals(15, map.size());
    }
}