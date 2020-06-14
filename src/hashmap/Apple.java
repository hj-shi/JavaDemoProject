package hashmap;

public class Apple implements Comparable<Apple>{
    private int size;

    public Apple(int s) {
        this.size = s;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "apple size: " + this.size;
    }


    @Override
    public int compareTo(Apple o) {
        return this.size - o.size;
    }
}
