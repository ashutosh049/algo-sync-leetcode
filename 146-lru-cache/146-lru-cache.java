import java.util.HashMap;
import java.util.Map;

class LRUCache {

  private static final int MIN_CAPACITY = 1;
  private static final int DEFAULT_CAPACITY = 1 << 4;
  private static final int MAX_CAPACITY = 3000;

  private int capacity;
  private Map<Integer, CacheEntry> cacheEntryMap;
  private CacheEntry head;
  private CacheEntry tail;

  public LRUCache(int capacity) {
    initCapacity(capacity);
    this.cacheEntryMap = new HashMap<>(this.capacity);
  }

  /**
   * Return the value of the key if the key exists, otherwise return -1.
   * <p>
   * TC: O(1)
   *
   * @param key
   * @return
   */
  public int get(Integer key) {

    if (key == null) {
      return -1;
    }

    if (cacheEntryMap.containsKey(key)) {
      CacheEntry n = cacheEntryMap.get(key);
      removeEntry(n);
      updateHead(n);
      return n.value;
    }

    return -1;
  }


  /**
   * Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
   * If the number of keys exceeds the capacity from this operation, evict the least recently used
   * key.
   * <p>
   * TC: O(1)
   *
   * @param key
   * @param value
   */
  public void put(int key, int value) {
    if (cacheEntryMap.containsKey(key)) {
      // Cache hit: update value
      CacheEntry entry = cacheEntryMap.get(key);
      entry.value = value;
      removeEntry(entry);
      updateHead(entry);
    } else {
      // Cache miss: insert new
      CacheEntry entry = new CacheEntry(key, value);

      if (cacheEntryMap.size() >= capacity) {
        cacheEntryMap.remove(tail.key);
        removeEntry(tail);
      }

      updateHead(entry);
      cacheEntryMap.put(key, entry);
    }
  }

  // -------------------------------------------------
  //  Private utilities
  // -------------------------------------------------

  /**
   * Performs validation for initial cache capacity
   *
   * @param capacity
   */
  private void initCapacity(int capacity) {
    if (capacity >= MIN_CAPACITY && capacity <= MAX_CAPACITY) {
      this.capacity = capacity;
    }
    if (capacity < MIN_CAPACITY || capacity > MAX_CAPACITY) {
      this.capacity = DEFAULT_CAPACITY;
    }
  }

  /**
   * Removing the node from head/centre/tail:
   * <p>
   * If the current entry is somewhere in centre, remove the entry by updating: 1. next pointer of
   * it's prev entry and 2. prev pointer of it's next entry
   * <p>
   * If current entry is head, set head to curr's next
   * <p>
   * If current entry is tail, set tail to curr's prev
   *
   * @param entry
   */
  private void removeEntry(CacheEntry entry) {
    if (entry.prev == null) {
      head = entry.next;
    } else {
      entry.prev.next = entry.next;
    }

    if (entry.next == null) {
      tail = entry.prev;
    } else {
      entry.next.prev = entry.prev;
    }

  }

  /**
   * @param node
   */
  private void updateHead(CacheEntry node) {
    node.next = head;
    node.prev = null;

    if (head != null) {
      head.prev = node;
    }

    head = node;

    if (tail == null) {
      tail = head;
    }
  }

}

class CacheEntry {

  int key;
  int value;
  CacheEntry prev;
  CacheEntry next;

  public CacheEntry(int key, int value) {
    this.key = key;
    this.value = value;
  }

}
