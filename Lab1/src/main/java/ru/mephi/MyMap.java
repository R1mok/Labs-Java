package ru.mephi;
import java.util.Objects;

/**
 * > Класс который реализует ячейку в MyMap
 * @param <K> ключ
 * @param <V> параметр
 */
class Node<K, V>{ // класс для элемента map
    private K key; // ключ
    private V value; // значение
    /**
     * Конструктор принимающий ключи и значение
     * @param key инициализируемый ключ
     * @param value инициализируемое значение
     */
    public Node(K key, V value){
        this.value = value;
        this.key = key;
    }

    @Override
    public boolean equals(Object o) { // сравнение равенства элементов
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
    public MyList nodes; // список элементов map

    public MyMap() {
        this.nodes = new MyList();
    }
    public MyMap(Object key, Object value) {
        this.nodes = new MyList();
        this.nodes.add(new Node(key, value));
    }
    public MyMap(Node[] nodes){ // конструктор по массиву Nodes
        this.nodes = new MyList();
        for (Node node : nodes) {
            this.nodes.add(node);
        }
    }
    public void put (Object key, Object value){ // положить в map значение по ключу
        if (!this.getValues().contains(value))
            this.nodes.add(new Node(key, value));
        else {
            System.out.println("This value already exist in MyMap!");
        }
    }
    public Object get(Object key) { // получить значение по ключу
        for (int i = 0; i < this.size(); ++i) {
            Node curNode = (Node) this.nodes.get(i);
            if (curNode.getKey() == key)
                return curNode.getValue();
        }
        return null;
    }
    public Object get(Object key, Object bydefault){ // получить значение по ключу, вставить bydefault
        if (key != null){
            Object curValue = this.get(key);
            this.put(key, bydefault);
            return curValue;
        } else {
            return bydefault;
        }
    }
    
    public Object remove(Object key){ // удалить пару по ключу
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
    public boolean keyContains(Object key){ // проверить существует ли значение по ключу
        return this.get(key) != null;
    }
    public MyList getEntries(){ // список пар
        MyList entriesList = new MyList();
        for (int i = 0; i < this.size(); ++i){
            Node curNode = (Node) this.nodes.list[i];
            entriesList.add(curNode);
        }
        return entriesList;
    }
    public MyList getKeys() { // список ключей
        MyList keysList = new MyList();
        for (int i = 0; i < this.size(); ++i){
            Node curNode = (Node) this.nodes.list[i];
            keysList.add(curNode.getKey());
        }
        return keysList;
    }
    public MyList getValues(){ // список значений
        MyList valuesList = new MyList();
        for (int i = 0; i < this.size(); ++i){
            Node curNode = (Node) this.nodes.list[i];
            valuesList.add(curNode.getValue());
        }
        return valuesList;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Size: " + this.size() + "\nMyMap: \n");
        for (int i = 0; i < this.size(); ++i){
            Node curNode = (Node) this.nodes.get(i);
            out.append(curNode.toString()).append('\n');
        }
        return out.toString();
    }
    public int size() { return this.nodes.getSize(); } // размер map
    public boolean isEmpty(){ return this.size() == 0; } // проверка пустой ли map

    public static void main(String[] args) {
        MyMap m1 = new MyMap();
        m1.put(1, "abc");
        m1.put(2, "abc");
        System.out.println(m1.remove(1));
        MyMap m2 = new MyMap(1, "abc");
        m2.put(4, "bca");
        System.out.println(m2.keyContains(1));
        m2.remove(1);
        System.out.println(m2.isEmpty());
        m2.remove(4);
        System.out.println(m2.isEmpty());
        System.out.println(m2.keyContains(1));
        Node[] nodes = new Node[5];
        for (int i = 0; i < 5; ++i){
            Node curNode = new Node(i, i + 13);
            nodes[i] = curNode;
        }
        MyMap m3 = new MyMap(nodes);
        System.out.println(m3);
        m3.remove(3);
        System.out.println(m3.get(2));
        System.out.println(m3.getEntries());
        System.out.println(m3.getValues());
        System.out.println(m3.getKeys());
        System.out.println(m3.get(null, 3));
    }
}