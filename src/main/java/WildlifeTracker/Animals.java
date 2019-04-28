package WildlifeTracker;

import org.sql2o.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;


public class Animals {
    public String name;
    public int id;
    public String type;

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
    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof Animals)) {
            return false;
        } else {
            Animals newAnimal = (Animals) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }

    public List<Sightings> getSightings() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where animalId=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sightings.class);
        }
    }
//    public static Animals find(int id){
//        try(Connection con = DB.sql2o.open()){
//            String sql = "SELECT * FROM animals where id=:id";
//            Animals animal = con.createQuery(sql)
//                    .addParameter("id", id)
//                    .executeAndFetchFirst(Animals.class);
//            return animal;
//        }
//    }

//    public Timestamp getSighting(){
//        return sighting;
//    }


}
