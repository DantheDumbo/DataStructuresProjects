public class Player implements Comparable<Player> {
    private int age;
    private String name;
    private int overAll;

    public Player() {
        this.age = 18;
        this.name = "Adam Tuma";
        this.overAll = 90;
    }

    public Player(int age, String name, int overAll) {
        this.age = age;
        this.name = name;
        this.overAll = overAll;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getOverAll() {
        return overAll;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOverAll(int overAll) {
        this.overAll = overAll;
    }

    @Override
    public String toString() {
        return "Player{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", overAll=" + overAll +
                '}';
    }

    @Override
    public int compareTo(Player playerTwo) {
        return playerTwo.getOverAll() - this.overAll;
    }
}
