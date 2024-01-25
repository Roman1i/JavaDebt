public class Laptop {

    private String manufacturer;
    private String model;
    private String color;
    private String OS;
    private int hddSize;
    private int RAM;

    
    
    public Laptop(String manufacturer, String model, String color, String os, int hddSize, int ram) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.RAM = ram;
        this.hddSize = hddSize;
        this.OS = os;
        this.color = color;
        Logic.addNewItem(manufacturer, model, color, os, hddSize, ram);
    }

    @Override
    public String toString() {
        return String.format("Model: %s %s -- Color: %s -- OS: %s -- HDD size(GB): %d -- RAM(GB): %d",
        this.manufacturer, this.model, this.color, this.OS, this.hddSize, this.RAM);
    }
}