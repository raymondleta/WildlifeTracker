package WildlifeTracker;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
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
//   @Test
//    public void getId_InstantiatesCorrectly_int(){
//       Animals testAnimal = new Animals("Cheetahs",1);
//       assertEquals(1, testAnimal.getId());
//   }

    @Test
    public void equals_returnsTrueIfNameIsSame_true() {
        Animals firstAnimal = new Animals("Lion");
        Animals anotherAnimal = new Animals("Lion");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

   @Test
    public void save_InsertsObjectIntoDatabase_animal(){
       Animals testAnimal = new Animals("Lion");
       testAnimal.save();
       assertTrue(Animals.all().get(0).equals(testAnimal));
   }

   @Test
   public void all_returnsAllInstancesOfAnimals_true(){
       Animals firstAnimal = new Animals("Lion");
       firstAnimal.save();
       Animals secondAnimal = new Animals ("Cheetah");
       secondAnimal.save();
       assertEquals(true, Animals.all().get(0).equals(firstAnimal));
       assertEquals(true, Animals.all().get(0).equals(secondAnimal));
   }
}

