package WildlifeTracker;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true(){
        EndangeredAnimal testAnimal = new EndangeredAnimal ("Cheetahs","Healthy","Young");
        assertEquals(true, testAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void endangeredAnimal_getHealthInstantiatesCorrectly_String(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Cheetahs","Healthy","Young");
        assertEquals("Healthy", testAnimal.getHealth());
    }

    @Test
    public void endangeredAnimal_getAgeInstantiatesCorrectly_String(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Cheetahs","Healthy","Young");
        assertEquals("Young", testAnimal.getAge());
    }

    @Test
    public void save_InsertsObjectIntoDatabase_animal(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Cheetahs","Healthy","Young");
        testAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfAnimals_true(){
        EndangeredAnimal firstAnimal = new EndangeredAnimal("Cheetahs","Healthy","Young");
        firstAnimal.save();
        EndangeredAnimal secondAnimal = new EndangeredAnimal ("Cheetahs","Healthy","Young");
        secondAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondAnimal));
    }
    @Test
    public void save_assignsIdToObject() {
        EndangeredAnimal testAnimal = new EndangeredAnimal ("Cheetahs","Healthy","Young");
        testAnimal.save();
        EndangeredAnimal savedAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }
    @Test
    public void find_returnsAnimalsWithSameId_secondAnimal() {
        EndangeredAnimal firstAnimal = new EndangeredAnimal("Cheetahs","Healthy","Young");
        firstAnimal.save();
        EndangeredAnimal secondAnimal = new EndangeredAnimal ("Cheetahs","Healthy","Young");
        secondAnimal.save();
        assertEquals(EndangeredAnimal.find(secondAnimal.getId()), secondAnimal);
    }
}
