import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SpaceCenterTest {
    private SpaceCenter center;
    public void setUp(){
        center = new SpaceCenter();

        ApolloRocket apollo1 = new ApolloRocket("Apollo 11",10000,"Black",1976);
        apollo1.setLaunchDate("30/12/2024");
        ApolloRocket apollo2 = new ApolloRocket("Apollo 12",10000,"Black",1979);
        apollo2.setLaunchDate("01/01/2025");
        center.addAircraft(apollo1);
        center.addAircraft(apollo2);
    }
    @Test
    public void testRocketsLaunchedAfterDate() throws ParseException {
        String testDate = "29/12/2024";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<ApolloRocket> rocketsLaunchedAfterDate = new ArrayList<>();
    if(center != null){
        for (Aircraft aircraft : center.getAircrafts()) {
        if (aircraft instanceof ApolloRocket) {
            ApolloRocket rocket = (ApolloRocket) aircraft;
            if (rocket.getLaunchDate() != null &&
                    sdf.parse(rocket.getLaunchDate()).after(sdf.parse(testDate))) {
                rocketsLaunchedAfterDate.add(rocket);
            }
        }
    }
    assertEquals(1, rocketsLaunchedAfterDate.size());
    assertEquals("Apollo 12", rocketsLaunchedAfterDate.get(0).getName());
}
}
    @Test
    public void testFirstRocketName() {
        // Assert that the first rocket's name is "Apollo 11"
        if(center != null){
            Aircraft firstRocket = center.getAircrafts().getFirst();
            assertTrue(firstRocket instanceof ApolloRocket);
            assertEquals("Apollo 11", firstRocket.getName());
        }

    }

}
