package rooms;
/**
 *  A room including one queenbed, twinbed and sofa. 
 */
public class juniorSuite extends Room{
    private final String QUEEN_BED=  "This room includes 1 Queen bed";   // queen bed final string method 
    private final String TWIN_BED = "this room includes 1 Twin bed ";   // twin bed string final method 
    private final String SOFA = "This room also includes 1 Sofa";   // sofa string final method 


// constructor 
public juniorSuite(){
                 super("Junior Suite",350);
                 
}

// bed getter method 
public String getBeds() {
    return QUEEN_BED + "\n" + "and " + TWIN_BED;
}

// sofa getter method 
public String getSofa() {
    return SOFA;
}







}
