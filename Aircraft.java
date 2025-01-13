public class Aircraft {
    private String name;
    private int maxKm;
    private String color;
    private int year;

    public Aircraft(String name, int maxKm, String color, int year) {
        this.name = name;
        this.maxKm = maxKm;
        this.color = color;
        this.year = year;
    }
    public String getName() {
        return this.name;
    }
    public String toString(){
        return "Aircraft " + this.name + " max distance of " + this.maxKm + " have color " + this.color + " and year " + this.year;

    }
}
