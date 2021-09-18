import java.util.Arrays;

public class MyList{ // hw Для map put(value, key), get(key), remove(key) старый объект,
    private int size;

    private Object[] list;

    private int cap = 10;
    public int getSize() {
        return this.size;
    }
    public MyList() {
        this.list = new Object[this.cap];
        this.size = 0;
    }
    public MyList(Object[] arr){
        this.list = new Object[arr.length];
        System.arraycopy(arr, 0, this.list, 0, arr.length);
        this.size = arr.length;
        this.cap = arr.length;
    }

    private void IncreaseCap(){
        this.cap *= 2;
         Object[] newList = new Object[this.cap];
         System.arraycopy(this.list, 0, newList, 0, this.size);
         this.list = newList;
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
    public void add(Object value) {
        if (this.size >= this.cap) {
        /*    this.cap = this.cap * 2;
            Object[] curList = this.list;
            this.list = new Object[this.cap];
            System.arraycopy(curList, 0, this.list, 0, curList.length);*/
            this.IncreaseCap();
        }
        this.list[this.size] = value;
        this.size += 1;
    }
    public void add (Object value, int index){
        if (index > this.size){
            this.add(value);
            return;
        } else if (this.size == this.cap){
            this.IncreaseCap();
        }
        Object[] newList = new Object[this.cap];
        newList = this.list;
        this.size += 1;
        System.arraycopy(this.list, index , newList, index + 1, this.size - index);
        this.list[index] = value;
    }
    public Object set(Object value, int index){
        if (index < this.size) {
            Object curItem = this.list[index];
            this.list[index] = value;
            return curItem;
        } else return null;
    }
    public Object remove(int index){
        if (index < this.size && this.size != 0) {
            Object curElem = this.list[index];
            for (int i = index; i < size - 1; ++i){
                this.list[i] = this.list[i + 1];
            }
            this.size -= 1;
            if (this.size * 2 < this.cap){
                this.cap = this.size + 1;
            }
            return curElem;
        } else {
            return null;
        }
    }
    public Object get(int index){
        if (index < this.size)
            return this.list[index];
        else
            return null;
    }
    public boolean isEmpty(){
        return this.size != 0;
    }

    public int indexOf(Object value){
        int key =  Arrays.binarySearch(list, 0, this.size, value);
        if (key < 0){
            return -1;
        } else return key;
    }
    public int indexOF(Object value){
        for (int i = 0; i < this.size; ++i){
            if (list[i] == value){
                return i;
            }
        }
        return -1;
    }
    public boolean contains(Object value){
        return indexOF(value) >= 0;
    }

    public static void main(String[] args){
        Object[] b = {1, 4, 2, 6, 5};
        MyList li = new MyList(b);
        li.add(3, 1);
        System.out.println(li);
    }
}

