public class EdgeWithTotalCost implements Comparable<EdgeWithTotalCost> {

    int from;
    int to;
    int totalCost;

    public EdgeWithTotalCost(int from, int to, int totalCost) {
        this.from = from;
        this.to = to;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "(" + (char)('A' + this.from) + ", " + (char)('A' + this.to) + ", " +  mk'A' + this.totalCost) + ")";
    }

    @Override
    public int compareTo(EdgeWithTotalCost other) {
        return this.totalCost - other.totalCost;
    }
}
