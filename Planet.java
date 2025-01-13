public class Planet {
    private String name;
    public Planet(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String toString(){
        return "Planet " + this.name;
    }
}
