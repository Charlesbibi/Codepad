import java.util.HashMap;
import java.util.Map;

/**
 *  存放key value的节点，是一个双向链表，用于维护插入的关系
 */
class LNode {
    LNode prev;
    LNode next;
    int key;  // 键值
    int val;  // 结果值

    public LNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 *  LRU 缓存核心实现  map + 双向链表
 */
public class LRUCache {
    // dummy结点，更好的维护双向队列
    LNode dummy = new LNode(-1, -1);

    // 存储key - node节点的映射
    Map<Integer, LNode> keyToNode = new HashMap<>();

    // 容量，超过多少则需要置换
    int capacity = 0;

    public LRUCache(int capacity) {
        // 初始化指向自己
        dummy.prev = dummy;
        dummy.next = dummy;

        this.capacity = capacity;
    }

    /**
     *  每次访问时候都会将key所对应的LNode节点提前，符合最近访问过的特性
     * @param key 键值
     * @return LNode节点
     */
    private LNode getNode(int key){
        // 不存在key值
        if(!keyToNode.containsKey(key)){
            return null;
        }

        LNode node = keyToNode.get(key);
        remove(node);  // 抽出来
        pushFront(node);  // 放到最前面

        return node;
    }

    /**
     *  获取到key所对应的值
     * @param key 键值
     * @return  val值如果没有则返回 -1
     */
    public int get(int key) {
        LNode node = getNode(key);

        // 如果为空则没有key值
        return node != null ? node.val : -1;
    }

    /**
     *  存放新的键值对，注意考量超出上限需要置换掉最久未使用的元素，即是dummy.prev
     * @param key  键值
     * @param value  值
     */
    public void put(int key, int value) {
        LNode node = getNode(key);

        // 如果之前插入过该键
        if(node != null){
            node.val = value;
            return;
        }

        node = new LNode(key, value);
        keyToNode.put(key, node);
        pushFront(node); // 放在最前面

        // 超出上限了
        if(keyToNode.size() > capacity){
            // 最久没有访问的节点
            LNode last = dummy.prev;

            keyToNode.remove(last.key);
            remove(last);
        }
    }

    /**
     *  双向链表头插法，有dummy node的情况
     * @param node 待操作节点
     */
    private void pushFront(LNode node){
        node.prev = dummy;
        node.next = dummy.next;
        node.next.prev = node;
        dummy.next = node;
    }

    /**
     *  双向链表删除节点断链操作
     * @param node 待操作节点
     */
    private void remove(LNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    //TEST
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}