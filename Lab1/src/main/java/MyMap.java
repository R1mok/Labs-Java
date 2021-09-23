import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(key, node.key) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
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
    public MyList nodes;

    public MyMap() {
        this.nodes = new MyList();
    }
    public MyMap(Object key, Object value) {
        this.nodes = new MyList();
        this.nodes.add(new Node(key, value));
    }
    public void put (Object key, Object value){
        this.nodes.add(new Node(key, value));
    }
    public Object get(Object key) {
        for (int i = 0; i < this.getSize(); ++i) {
            Node curNode = (Node) this.nodes.get(i);
            if (curNode.getKey() == key)
                return curNode.getValue();
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
    
    public Object remove(Object key){
        Object curValue = this.get(key);
        if (curValue != null) {
            Node curNode = new Node(key, curValue);
            this.nodes.remove(this.nodes.indexOF(curNode));
            return curNode;
        }
        System.out.println("Can`t remove element by key: " + key);
        return null;
    }
    
    @Override
    public String toString() {
        String out = "Size: " + this.getSize() + "\nMyMap: \n";
        for (int i = 0; i < this.getSize(); ++i){
            Node curNode = (Node) this.nodes.get(i);
            out += curNode.toString() + '\n';
        }
        return out;
    }
    public int getSize() { return this.nodes.getSize(); }
    public static void main(String[] args) {
        MyMap m = new MyMap(1, "str");
        System.out.println(m.get(1));
        m.remove(1);
        m.remove(2);
        System.out.println(m);
    }
}