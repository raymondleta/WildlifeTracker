package WildlifeTracker;

public class Animals {
    private String name;
    private int id;

    public Animals(String name, int id) {
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
    public boolean equals(Object secondAnimal){
        if (!(secondAnimal instanceof Animals)){
            return false;
        }else {
            Animals newAnimal = (Animals) secondAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }
}
