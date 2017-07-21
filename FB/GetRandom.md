# 380. Insert Delete GetRandom O(1)
Design a data structure that supports all following operations in average O(1) time.

- insert(val): Inserts an item val to the set if not already present.

- remove(val): Removes an item val from the set if present.

- getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

### Java

```java
public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, val);
        }
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            map.remove(val);
            int index = list.indexOf(val);
            list.remove(index);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }
}
```
