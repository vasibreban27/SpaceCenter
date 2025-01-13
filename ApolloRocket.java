import java.util.Date;

public class ApolloRocket extends Aircraft{
    private String launchDate;
    public ApolloRocket(String name,int maxDistance,String color,int year){
        super(name,maxDistance,color,year);
    }
    public void setLaunchDate(String launchDate){
        this.launchDate = launchDate;
    }
    public String getLaunchDate(){
        return launchDate;
    }
    public void launchRocket(Planet planet){
        System.out.println(super.getName() + " is launching to " + planet.getName());
    }
}
