package cs_algo_theory_and_practice_methods.task3_2;

/**
 * Created by rurik on 11.08.2016.
 */
 class Item {
    private String value;
    private Integer f;

    private Item left;
    private Item right;
    private Item parent;

    public Item(String value, Integer f) {
        this.value = value;
        this.f = f;
    }

    public Item(Integer f, Item left, Item right) {
        this.f = f;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public Integer getF() {
        return f;
    }

    public Item getLeft() {
        return left;
    }

    public Item getRight() {
        return right;
    }

    public Item getParent() {
        return parent;
    }

    public void setParent(Item parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        return left != null && right != null;
    }
}