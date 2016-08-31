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

        Integer[] res = new CsAlgo5_5__6().process(items, m);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    List<Integer> process(ArrayList<Integer> aArr, ArrayList<Integer> bArr, ArrayList<Integer> points) {
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < aArr.size(); i++) {
            items.add(new Item(aArr.get(i), i, Item.START));
        }
        for (int i = 0; i < bArr.size(); i++) {
            items.add(new Item(bArr.get(i), i, Item.END));
        }
        for (int i = 0; i < points.size(); i++) {
            items.add(new Item(points.get(i), i, Item.POINT));
        }

        Integer[] res = process(items, points.size());
        return Arrays.asList(res);
    }

    Integer[] process(ArrayList<Item> items, int m) {
        Integer[] res = new Integer[m];
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
        switchToRandomItem(arr, l, r);

        Item x = arr.get(l);
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            Item current = arr.get(i);
            if (current.lessOrEquals(x)) {
                switchItems(arr, i, j + 1);
                j++;
            }
        }
        switchItems(arr, l, j);
        return j;
    }

    private void switchToRandomItem(List<Item> arr, int l, int r) {
        Random random = new Random();
        int randomIndex = l + 1 + random.nextInt(r - l);
        switchItems(arr, l, randomIndex);
    }

    private void switchItems(List<Item> arr, int i, int j) {
        Item x = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, x);
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
