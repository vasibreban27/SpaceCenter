public class RobotEmployee implements Employee{
    private String name;
    public RobotEmployee(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void performActivity(){
        System.out.println("Robot " + this.name + " is working all the time.");
    }
    public String toString(){
        return "Robot Employee " + this.name;
    }
}
