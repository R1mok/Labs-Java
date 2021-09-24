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
        for (int i = 0; i < this.size(); ++i) {
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
        Node curNode = new Node(key, curValue);
        if (this.nodes.remove(this.nodes.indexOF(curNode)) != null)
        {
            return curNode;
        }
        else {
            System.out.println("Can`t remove element by key: " + key);
            return null;
        }
    }
    public boolean keyContains(Object key){
        return this.get(key) != null;
    }
    public MyList getEntries(){
        MyList entriesList = new MyList();
        for (int i = 0; i < this.size(); ++i){
            Node curNode = (Node) this.nodes.list[i];
            entriesList.add(curNode);
        }
        return entriesList;
    }
    public MyList getKeys() {
        MyList keysList = new MyList();
        for (int i = 0; i < this.size(); ++i){
            Node curNode = (Node) this.nodes.list[i];
            keysList.add(curNode.getKey());
        }
        return keysList;
    }
    public MyList getValues(){
        MyList valuesList = new MyList();
        for (int i = 0; i < this.size(); ++i){
            Node curNode = (Node) this.nodes.list[i];
            valuesList.add(curNode.getValue());
        }
        return valuesList;
    }

    @Override
    public String toString() {
        String out = "Size: " + this.size() + "\nMyMap: \n";
        for (int i = 0; i < this.size(); ++i){
            Node curNode = (Node) this.nodes.get(i);
            out += curNode.toString() + '\n';
        }
        return out;
    }
    public int size() { return this.nodes.getSize(); }
    public boolean isEmpty(){ return this.size() == 0; }
    public static void main(String[] args) {
        MyMap m = new MyMap(1, "str");
        m.put(2, "num");
        m.put(null, null);
        System.out.println(m);
        m.remove(5);
        System.out.println(m);
    }
}