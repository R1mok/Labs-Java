package ru.mephi;

public class MergeSort {
    static public MyList merge(MyList first, MyList second){
        MyList res = new MyList();
        if (first == null || second == null){
            System.out.println("List not found");
        } else {
            for (int i = 0, j = 0; (i + j < first.getSize() + second.getSize()); ) {
                if (first.getSize() == i){
                    while (second.getSize() != j){
                        res.add(second.list[j]);
                        j += 1;
                    }
                    return res;
                } else if (second.getSize() == j){
                    while (first.getSize() != i){
                        res.add(first.list[i]);
                        i += 1;
                    }
                    return res;
                }
                if (first.list[i] < second.list[j]) {
                    res.add(first.list[i]);
                    i += 1;
                } else if (first.list[i] > second.list[j]) {
                    res.add(second.list[j]);
                    j += 1;
                } else {
                    res.add(first.list[i]);
                    res.add(second.list[j]);
                    i += 1;
                    j += 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MyList m1 = new MyList();
        int[] a1 = {1, 5, 6, 9, 10, 15, 17};
        int[] a2 = {1, 2, 5, 7, 9, 11, 14};
        for (int i = 0; i < 5; ++i){
            m1.add(a1[i]);
        }
        MyList m2 = new MyList();
        for (int j = 0; j < 5; ++j){
            m2.add(a2[j]);
        }
        MyList m3 = merge(m1, m2);
        System.out.println(m3);
    }
}
