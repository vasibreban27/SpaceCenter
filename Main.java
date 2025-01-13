import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SpaceCenter center = new SpaceCenter();

        center.addEmployee(new HumanEmployee("John"));
        center.addEmployee(new RobotEmployee("Samsung - rx45"));

        center.addAircraft(new BoeingAircraft("Boeing 747", 15000, "Blue", 2010, new Pilot("John", "Travolta", 35, "veteran"), 230));
        center.addAircraft(new ApolloRocket("Apollo 11", 25000, "Black", 1985));

        center.displayAircrafts();
        center.simulateEmployeesActivities();

        Planet jupiter = new Planet("Jupiter");
        center.launchApollo("Apollo 11", jupiter,"01/01/2025");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date (dd/MM/yyyy) to filter rockets launched after this date:");
        String date = sc.nextLine();


            try {
                center.launchedRocketAfterDate(date);
            } catch (NoRocketsLaunchedException e) {
                System.out.println(e.getMessage());
            }catch(RuntimeException e) {
                System.out.println("Invalid date format error " + e.getMessage());
        }

    }
}