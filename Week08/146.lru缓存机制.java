import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
    }

    private HashMap<Integer, DLinkNode> cache;

    DLinkNode head;
    DLinkNode tail;
    private int capacity = 0;
    private int size = 0;

    public LRUCache(int capacity) {
        // 初始化
        this.capacity = capacity;// 容量
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
       // println("bget",key,key);
        // TODO 将最新访问的节点移动至链表头.
        moveHead(node);
       // println("fget",key,key);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveHead(node);
        } else {
            DLinkNode nnode = new DLinkNode();
            nnode.key = key;
            nnode.value = value;
            cache.put(key, nnode);
            addtoHead(nnode);
            size++;
            if (size > capacity) {
                removeTail();
                --size;
            }
        }
       // println("put",key,value);
    }

    private void println(String method,int key,int value){
        DLinkNode node = head.next;
        System.out.print(method+"("+key+","+value+")");
        while(node != null && node != tail){
            System.out.print("node("+node.key+","+node.value+")-->");
            node = node.next;
        }
        System.out.println("\n");
    }

    private void moveHead(DLinkNode node) {
        //删除节点node
        node.prev.next = node.next;
        node.next.prev = node.prev;

       

        node.prev = head;
        node.next = this.head.next;
        //println("moveHead->prev",node.prev.key,node.prev.value);
       // println("moveHead->next",node.next.key,node.next.value);

        this.head.next.prev = node;
        this.head.next = node;
        
    }

    private void addtoHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeTail() {
        DLinkNode tailNode = tail.prev;
        if(tailNode == null || tailNode == head){
            return;
        }
        Integer key = tailNode.key;
        cache.remove(key);
        tail.prev = tailNode.prev;
        tailNode.prev.next = tail;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
