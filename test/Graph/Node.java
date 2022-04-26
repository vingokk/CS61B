public class Node {
    public int num;
    public double time;
    public double money;
    public Node(int num, double time, double money) {
        this.num = num;
        this.time = time;
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node Node1 = (Node) o;

        return Node1.num == this.num;
    }

    @Override
    public int hashCode() {
        return num;
    }
}
