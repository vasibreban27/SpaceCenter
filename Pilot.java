public class Pilot {
    private String firstName;
    private String lastName;
    private int age;
    private String rank;

    public Pilot(String firstName, String lastName, int age, String rank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.rank = rank;
    }
    public String toString(){
        return "Pilot " + firstName + " " + lastName + ", aged " + age + " with rank " + rank;
    }
}
