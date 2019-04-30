package WildlifeTracker;
import java.util.List;
import org.sql2o.*;

public class Sightings {
    private String ranger;
    private String location;
    private int id;
    private int animalId;
    private String health;
    private String age;


    public Sightings(String ranger, String location, int animalId, String health, String age) {
        this.ranger = ranger;
        this.location = location;
        this.animalId = animalId;
        this.health = health;
        this.age = age;


    }



    public String getRanger() {
        return ranger;
    }

    public String getLocation() {
        return location;
    }
    public int getId() {
        return id;
    }
    public int getAnimalId() {
        return animalId;
    }
    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public static List<Sightings> all() {
        String sql = "SELECT id, ranger, location, animalId, health, age FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }
    @Override
    public boolean equals(Object otherSighting) {
        if (!(otherSighting instanceof Sightings)) {
            return false;
        } else {
            Sightings newSighting = (Sightings) otherSighting;
            return this.getRanger().equals(newSighting.getRanger()) &&
                    this.getLocation().equals(newSighting.getLocation())&&
                    this.getId() == newSighting.getId()&&
                    this.getAnimalId() == newSighting.getAnimalId()&&
                    this.getHealth().equals(newSighting.getHealth())&&
                    this.getAge().equals(newSighting.getAge());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (ranger, location, animalId, health, age ) VALUES (:ranger, :location, :animalId, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("ranger", this.ranger)
                    .addParameter("location", this.location)
                    .addParameter("animalId", this.animalId)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sightings sightings = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sightings;
        }
    }


}
