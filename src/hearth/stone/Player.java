package hearth.stone;

public class Player {

    private String name;
    private final int id;


    public Player(String name){
        this.name = name;
        this.id = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }
}
