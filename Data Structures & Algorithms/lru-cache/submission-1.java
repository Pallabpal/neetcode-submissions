class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
            this.next = null;

        }
    }

    Map<Integer, Node> map = new HashMap<>();
    int k;
    Node head, tail;
    public LRUCache(int capacity) {
        this.k = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){

            Node node = map.get(key);
            // remove node
            remove(node);
            // move to first
            moveToFirst(node);

            return node.value;
        }
        return -1;
    }

    public void remove(Node node){
       Node prevNode = node.prev;
       Node nextNode = node.next;
       prevNode.next = nextNode;
       nextNode.prev = prevNode;

       map.remove(node.key);
    }

    public void moveToFirst(Node node){
        
        //head --->node1 --->+---->tail
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        map.put(node.key, node);
    }
    
    public void put(int key, int value) {
        
        // check if it existing key or not
        if(!map.containsKey(key)){
            Node temp = new Node(key, value);
            map.put(key, temp);

            if(map.size() >k){
                remove(tail.prev);
            }
            moveToFirst(temp);
        }else{
            Node node = map.get(key);
            node.value = value;
            remove(node);
            moveToFirst(node);
        }
    }
}
