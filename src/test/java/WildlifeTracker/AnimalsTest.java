package WildlifeTracker;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Date;
import org.sql2o.*;

public class AnimalsTest {

   @Rule
    public DatabaseRule database = new DatabaseRule();

   @Test
    public void animal_instantiatesCorrectly_true(){
       Animals testAnimal = new Animals ("Cheetahs");
       assertEquals(true, testAnimal instanceof Animals);
   }
   @Test
    public void getName_instantiatesWithName_String(){
       Animals testAnimal = new Animals("Cheetahs");
       assertEquals("Cheetahs", testAnimal.getName());
   }

    @Test
    public void equals_returnsTrueIfNameIsSame_true() {
        Animals firstAnimal = new Animals("Lion");
        Animals anotherAnimal = new Animals("Lion");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }
    @Test
    public void getSightings_retrievesALlSightingsFromDatabase_sightingsList() {
        Animals myAnimal = new Animals("Lion");
        myAnimal.save();
        Sightings firstSighting = new Sightings("John","By the river", myAnimal.getId());
        firstSighting.save();
        Sightings secondSighting = new Sightings("Peter","By the pond", myAnimal.getId());
        secondSighting.save();
        Sightings[] sightings = new Sightings[] { firstSighting, secondSighting };
        assertTrue(myAnimal.getSightings().containsAll(Arrays.asList(sightings)));
    }


//   @Test
//    public void save_InsertsObjectIntoDatabase_animal(){
//       Animals testAnimal = new Animals("Lion");
//       testAnimal.save();
//       assertTrue(Animals.all().get(0).equals(testAnimal));
//   }
//
//   @Test
//   public void all_returnsAllInstancesOfAnimals_true(){
//       Animals firstAnimal = new Animals("Lion");
//       firstAnimal.save();
//       Animals secondAnimal = new Animals ("Cheetah");
//       secondAnimal.save();
//       assertEquals(true, Animals.all().get(0).equals(firstAnimal));
//       assertEquals(true, Animals.all().get(1).equals(secondAnimal));
//   }
//    @Test
//    public void save_assignsIdToObject() {
//        Animals testAnimal = new Animals ("Giraffe");
//        testAnimal.save();
//        Animals savedAnimal = Animals.all().get(0);
//        assertEquals(testAnimal.getId(), savedAnimal.getId());
//    }
//    @Test
//    public void find_returnsAnimalsWithSameId_secondAnimal() {
//        Animals firstAnimal = new Animals("Lion");
//        firstAnimal.save();
//        Animals secondAnimal = new Animals ("Leopard");
//        secondAnimal.save();
//        assertEquals(Animals.find(secondAnimal.getId()), secondAnimal);
//    }
}

