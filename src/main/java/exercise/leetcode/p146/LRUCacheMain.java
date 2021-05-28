package exercise.leetcode.p146;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Least recently used (LRU)
 * 한정된 저장공간에서 가장 오랫동안 참조되지 않은 자료를 교체하는 캐시 알고리즘
 * ex) 숫자를 저장하는 저장공간의 사이즈가 2일때, 1->2->3 을 차례대로 사용 했다면 최근에 사용한 2,3만이 저장된다.
 * 만약 2를 다시 사용 한다면, 3이 다음번에 교체되는 1순위가 된다. (3, 2)
 */

class LRUCache {
    static class CacheItem {
        int key;
        int value;
        CacheItem prev;
        CacheItem next;

        CacheItem() {
        }

        CacheItem(int key, int value) {
            this.key = key;
            this.value = value;
        }

        /**
         * A - B - C로 연결 되어 있을때, B의 링크를 제거하면 A - C에 구조되도록 만든다.
         */
        void removeLinks() {
            prev.next = next;
            next.prev = prev;
        }

        void insertNext(CacheItem cacheItem) {
            next.prev = cacheItem;
            cacheItem.prev = this;
            cacheItem.next = next;
            next = cacheItem;
        }

        @Override
        public String toString() {
            return "CacheItem{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Map<Integer, CacheItem> cacheItemMap = new HashMap<>();
    private CacheItem head = new CacheItem();
    private CacheItem tail = new CacheItem();
    private int currSize;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cacheItemMap.containsKey(key)) {
            final CacheItem cacheItem = cacheItemMap.get(key);
            cacheItem.removeLinks();
            head.insertNext(cacheItem);
            return cacheItemMap.get(key).value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cacheItemMap.containsKey(key)) {
            final CacheItem cacheItem = cacheItemMap.get(key);
            cacheItem.value = value;
            cacheItem.removeLinks();
            head.insertNext(cacheItem);
        } else {
            final CacheItem cacheItem = new CacheItem(key, value);
            head.insertNext(cacheItem);
            cacheItemMap.put(key, cacheItem);
            currSize++;

            if (currSize > capacity) {
                cacheItemMap.remove(tail.prev.key);
                tail.prev.removeLinks();
                currSize--;
            }
        }
    }
}

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1)).isEqualTo(1);
        cache.put(3, 3);
        assertThat(cache.get(2)).isEqualTo(-1);
//        assertThat(cache.get(2)).isEqualTo(2);
        cache.put(4, 4);
        assertThat(cache.get(1)).isEqualTo(-1);
//        assertThat(cache.get(1)).isEqualTo(1);
        assertThat(cache.get(3)).isEqualTo(3);
        assertThat(cache.get(4)).isEqualTo(4);
        assertThat(cache.get(5)).isEqualTo(-1);
    }
}
