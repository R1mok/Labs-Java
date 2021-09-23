class Node<K, V>{
    private K key;
    private V value;

    public Node(){
        this.key = null;
        this.value = null;
    }
    public Node(K key, V value){
        this.value = value;
        this.key = key;
    }

    @Override
    public String toString() {
        return key + ":"+ value;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public void setValue(V value){
        this.value = value;
    }

    public V getValue() { return value; }
    public K getKey() { return key; }
}
public class MyMap {
    public Node[] nodes;
    private int size;
    private int cap = 10;

    public MyMap() {
        this.nodes = new Node[this.cap];
        this.size = 0;
    }
    public MyMap(Object key, Object value) {
        this.nodes = new Node[this.cap];
        this.nodes[0] = new Node(key, value);
        this.size = 1;
    }
    public void put (Object key, Object value){
        if (this.size >= this.cap) {
            this.cap *= 2;
            Node[] newNodes = new Node[this.cap];
            System.arraycopy(this.nodes, 0, newNodes, 0, this.size);
            this.nodes = newNodes;
        }
        this.nodes[this.size] = new Node(key, value);
        this.size += 1;
    }
    public Object get(Object key) {
        for (int i = 0; i < this.size; ++i) {
            if (this.nodes[i].getKey() == key)
                return this.nodes[i].getValue();
        }
        return null;
    }
    public Object get(Object key, Object bydefault){
        if (key != null){
            return this.get(key);
        } else {
            return bydefault;
        }
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < this.size; ++i){
            out += this.nodes[i] + " ";
        }
        return  "size=" + size + "\n" + out + '\n';
    }

    public int getSize() { return size; }
    public int getCap() { return cap; }
    public static void main(String[] args) {
        MyMap m = new MyMap(1, "str");
        System.out.println(m);
        m.put(3, "get");
        System.out.println(m);
        m.put(4, "sda");
    }
}