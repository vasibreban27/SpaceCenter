public class HumanEmployee implements Employee{
    private String name;
    public HumanEmployee(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void eat(){
        System.out.println("Employee " + this.name + " is eating");
    }
    public void sleep(){
        System.out.println("Employee " + this.name + " is sleeping");
    }
    public void performActivity()
    {
        System.out.println("Employee "+this.name + " is working");
        eat();
        sleep();
    }
    public String toString(){
        return "Human Employee " + this.name + ".";
    }
}
