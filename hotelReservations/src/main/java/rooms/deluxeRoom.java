package rooms;

/**
 *  class for a deluxe room including a queen bed and a twin.
 * 
 */
public class deluxeRoom extends Room {
    private final String QUEEN_BED=  "This room includes 1 Queen bed";
    private final String TWIN_BED = "this room also includes 1 Twin bed ";


    // constructor 
    public deluxeRoom() {
        super("Deluxe Room", 300); // Assuming $300 per night for a deluxe room
    }
    // bed string getter method 
    public String getBeds() {
        return QUEEN_BED + "\n"+ "and " + TWIN_BED;
    }
    
    // sofa string getter method 
    public String getSofa() {
        return "n/a";
    }
    
}
