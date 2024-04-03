package rooms;
/**
 * 
 * this is a class for a regular room with a queen bed. 
 * 
 */
public class regularRoom extends Room {
    private final String QUEEN_BED=  "This room includes 1 Queen bed";

// constructor
public regularRoom(){
    super("Regular Room",280);
}

// bed getter method
public String getBeds() {
    return QUEEN_BED;
}


// sofa getter method 
public String getSofa() {
    return "n/a";
}


}
