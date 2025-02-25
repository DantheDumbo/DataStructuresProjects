public class Computer {
    private int ram;
    private int storage;
    private String brand;
    private double cost;

    public Computer() {
        this.ram = 16;
        this.storage = 256;
        this.brand = "Unknown brand";
        this.cost = 1000.00;
    }
    public Computer(int ram, int storage, String brand, double cost) {
        this.ram = ram;
        this.storage = storage;
        this.brand = brand;
        this.cost = cost;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", storage=" + storage +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                '}';
    }
}
