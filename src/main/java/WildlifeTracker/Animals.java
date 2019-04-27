package WildlifeTracker;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;


public class Animals {
    private String name;
    private int id;

    public Animals(String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animals)) {
            return false;
        } else {
            Animals newAnimal = (Animals) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animals> all(){
        String sql = "SELECT * FROM animals";
        try (Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }

    }

}
