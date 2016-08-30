package cs_algo_theory_and_practice_methods.task5_5;

import java.util.*;


public class CsAlgo5_5__6 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();

        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(reader.nextInt(), i, Item.START));
            items.add(new Item(reader.nextInt(), i, Item.END));
        }

        for (int i = 0; i < m; i++) {
            items.add(new Item(reader.nextInt(), i, Item.POINT));
        }

        int[] res = new CsAlgo5_5__6().process(items, m);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    int[] process(ArrayList<Item> items, int m) {
        int[] res = new int[m];
        quickSort(items);
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.type == Item.START) {
                count++;
            }
            if (item.type == Item.END) {
                count--;
            }
            if (item.type == Item.POINT) {
                res[item.pos] = count;
            }
        }
        return res;
    }


    List<Item> quickSort(List<Item> arr) {
        quickSort(arr, 0, arr.size() - 1);
        return arr;
    }

    void quickSort(List<Item> arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        quickSort(arr, l, m - 1);
        quickSort(arr, m + 1, r);
    }


    public int partition(List<Item> arr, int l, int r) {
        Item x = arr.get(l);
        int j = l;
        int jEq = l;
        for (int i = l + 1; i <= r; i++) {
            Item current = arr.get(i);
            if (current.lessOrEquals(x)) {
                arr.set(i, arr.get(j + 1));
                arr.set(j + 1, current);
                j++;
            }
        }
        arr.set(l, arr.get(j));
        arr.set(j, x);
        return j;
    }


    private static class Item {
        public static final int START = 0;
        public static final int POINT = 1;
        public static final int END = 2;

        int x;
        int pos;
        int type;

        public Item(int x, int pos, int type) {
            this.x = x;
            this.pos = pos;
            this.type = type;
        }

        public boolean lessOrEquals(Item item) {
            return (this.x < item.x) || (this.x == item.x && this.type <= item.type);
        }
    }

}
