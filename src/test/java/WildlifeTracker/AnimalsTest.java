package WildlifeTracker;

import org.junit.Test;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalsTest {
   @Test
    public void animal_instantiatesCorrectly_true(){
       Animals testAnimal = new Animals ("Cheetahs", 1);
       assertEquals(true, testAnimal instanceof Animals);
   }
   @Test
    public void getName_instantiatesWithName_String(){
       Animals testAnimal = new Animals("Cheetahs", 1);
       assertEquals("Cheetahs", testAnimal.getName());
   }
   @Test
    public void getId_InstantiatesCorrectly_int(){
       Animals testAnimal = new Animals("Cheetahs",1);
       assertEquals(1, testAnimal.getId());
   }

   @Test
    public void equals_returnsTrueIfNameAndIdAreSameTrue(){
      Animals firstAnimal = new Animals("Cheetahs", 1);
      Animals secondAnimal = new Animals("Cheetah",1);
      assertTrue(firstAnimal.equals(secondAnimal));
   }
}

