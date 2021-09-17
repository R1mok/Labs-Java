public class MyList{ // hw Для map put(value, key), get(key), remove(key) старый объект,
    private int size;

    private Object[] list;

    private int cap = 10;
    public int getSize() {
        return size;
    }
    public MyList() {
        this.list = new Object[0];
        this.size = 0;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; ++i){
            s += list[i];
            s+= " ";
        }
        return "size : " + size + "\nlist : " + s;
    }

    public MyList(Object[] arr){
        this.list = new Object[arr.length];
        System.arraycopy(arr, 0, this.list, 0, arr.length);
        this.size = arr.length;
        this.cap = arr.length * 2;
    }
    public void add(Object value) {
        if (this.size >= this.cap) {
            this.cap = this.cap * 2;
        }
        this.list[this.size] = value;
        this.size += 1;
    }
    public Object remove(int index){
        if (index < this.size - 1 && this.size != 0) {
            Object curElem = this.list[index];
            for (int i = index; i < size - 1; ++i){
                this.list[i] = this.list[i + 1];
                this.size -= 1;
            }
            return curElem;
        } else if (this.size == 1 && index == 0){
            Object curElem = this.list[0];
            this.list[0] = null;
            return curElem;
        } else {
            return null;
        }
    }
    public Object get(int index){
        if (index < size)
            return this.list[index];
        else
            return null;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size != 0;
    }
    public static void main(String[] args){
        Object[] b = {1, 4, 2, 1, 5};
        MyList li = new MyList(b);
        System.out.println(li.size);
        System.out.println(li);
        MyList li2 = new MyList();
        System.out.println(li2);
    }
}

