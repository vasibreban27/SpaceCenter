public class BoeingAircraft extends Aircraft{
    private Pilot pilot;
    private int passengers;

    public BoeingAircraft(String name,int maxDistance,String color,int year,Pilot pilot,int passengers){
        super(name,maxDistance,color,year);
        this.pilot = pilot;
        this.passengers = passengers;
    }
    public String toString(){
        return super.toString()+" with number of passengers of "+this.passengers + ". " +this.pilot.toString();
    }

}
