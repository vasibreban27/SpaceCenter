import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class SpaceCenter {
    private List<Aircraft> aircrafts;
    private List<Employee> employees;

    public SpaceCenter() {
        this.aircrafts = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircrafts.add(aircraft);
    }
    public List<Aircraft> getAircrafts() {
        return this.aircrafts;
    }
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
    public void displayAircrafts(){
        aircrafts.sort(Comparator.comparing(Aircraft::getName));

        for(Aircraft aircraft : aircrafts){
            System.out.println(aircraft);
        }
        System.out.println("Number of aircrafts in the SpaceCenter is " + aircrafts.size());
    }

    public void simulateEmployeesActivities(){
        for(Employee employee : employees){
            employee.performActivity();
        }
    }

    public void launchApollo(String name,Planet planet,String launchDate)
    {
        for(Aircraft aircraft : aircrafts){
            if(aircraft instanceof ApolloRocket && aircraft.getName().equals(name))
            {
                ((ApolloRocket) aircraft).launchRocket(planet);
                ((ApolloRocket)aircraft).setLaunchDate(launchDate);
                return;
            }
        }
        throw new RuntimeException("No apollo rocket found");
    }
    public void launchedRocketAfterDate(String date) throws NoRocketsLaunchedException{
        List<ApolloRocket> launchedRockets = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(Aircraft aircraft : aircrafts){
            if(aircraft instanceof ApolloRocket)
            {
                ApolloRocket rocket = (ApolloRocket) aircraft;
                try{
                    if(rocket.getLaunchDate()!= null && sdf.parse(rocket.getLaunchDate()).after(sdf.parse(date)))
                    {
                        launchedRockets.add(rocket);
                    }

                }catch(ParseException e){
                    throw new RuntimeException("Error parsing date");
                }

            }
        }

        if(launchedRockets.isEmpty())
        {
            throw new NoRocketsLaunchedException("No apollo rocket launched after date " + date);
        }
        for(ApolloRocket rocket : launchedRockets)
        {
            System.out.println(rocket);
        }
    }
}
