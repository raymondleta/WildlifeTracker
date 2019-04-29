package WildlifeTracker;

import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animals {
    private String health;
    private String age;

    public static final String DATABASE_TYPE = "endangered";

    public static final String HEALTH = "healthy";
    public static final String ILL = "ill";
    public static final String OKAY = "okay";
    public static final String NEWBORN = "newborn";
    public static final String YOUNG = "young";
    public static final String ADULT = "adult";


    public EndangeredAnimal(String name, String health, String age) {
        super(name);
        this.health = health;
        this.age = age;
        type = DATABASE_TYPE;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }


    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='endangered';";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }

    }

    public static EndangeredAnimal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return animal;
        }
    }

}
