package family;

public class Phone {
    private String brand;
    private String model;
    private String color;
    private int storage;

    public Phone(final String brand, final String model, final String color, final int storage) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.storage = storage;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

    public String getModel() { return this.model; }

    public void setModel(final String model) { this.model = model; }

    public String getColor() {
        return this.color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public int getStorage() { return this.storage; }

    public void setStorage(final int storage) { this.storage = storage; }
}