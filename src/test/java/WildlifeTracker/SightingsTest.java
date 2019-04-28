package WildlifeTracker;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sightingsInstantiates_true(){
        Sightings testSighting = new Sightings("John", "By the River",1);
        assertEquals(true, testSighting instanceof Sightings );
    }

    @Test
    public void getRangerInstantiatesCorrectly_String(){
        Sightings testSighting = new Sightings("Peter", "By the river",1);
        assertEquals("Peter", testSighting.getRanger());
    }
    @Test
    public void getLocationInstantiatesCorrectly_String(){
        Sightings testSighting = new Sightings("Peter", "By the river",1);
        assertEquals("By the river", testSighting.getLocation());
    }

    @Test
    public void equals_returnsTrueIfRangerAretheSame() {
        Sightings firstSighting = new Sightings("John","Near the river",1);
        Sightings secondSighting = new Sightings("John","Near the river",1);
        assertTrue(firstSighting.equals(secondSighting));
    }

    @Test
    public void save_savesIntoDatabase_true() {
        Sightings mySighting = new Sightings("John","Near the river",1);
        mySighting.save();
        assertTrue(Sightings.all().get(0).equals(mySighting));
    }
    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sightings firstSighting = new Sightings("John","Near the river",1);
        firstSighting.save();
        Sightings secondSighting = new Sightings("Peter", "By the well",1);
        secondSighting.save();
        assertEquals(true, Sightings.all().get(0).equals(firstSighting));
        assertEquals(true, Sightings.all().get(1).equals(secondSighting));
    }
    @Test
    public void save_assignsIdToObject() {
        Sightings mySighting = new Sightings("John","By the river",1);
        mySighting.save();
        Sightings savedSighting = Sightings.all().get(0);
        assertEquals(mySighting.getId(), savedSighting.getId());
    }
    @Test
    public void getId_sightongsInstantiateWithAnId_1() {
        Sightings testSighting = new Sightings("John","By the mountain",1);
        testSighting.save();
        assertTrue(testSighting.getId() > 0);
    }

    @Test
    public void find_returnsSightingsWithSameId_secondSighting() {
        Sightings firstSighting = new Sightings("John","By the river",1);
        firstSighting.save();
        Sightings secondSighting = new Sightings("Peter","By the mountain",1);
        secondSighting.save();
        assertEquals(Sightings.find(secondSighting.getId()), secondSighting);
    }

    @Test
    public void save_savesAnimalsIdIntoDB_true() {
        Animals myAnimal = new Animals("Lion");
        myAnimal.save();
        Sightings mySighting = new Sightings("John", "By the river", myAnimal.getId());
        mySighting.save();
        Sightings savedSighting = Sightings.find(mySighting.getId());
        assertEquals(savedSighting.getAnimalId(), myAnimal.getId());
    }

}
