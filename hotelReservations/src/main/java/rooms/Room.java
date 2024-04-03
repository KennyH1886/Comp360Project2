package rooms;
/**
 * class of rooms availiable. 
 */
public abstract class Room {
    private String roomType;  // room type string variable 
    private double costPerNight; // cost per night double variable


    // constructor method to set the room 
    public  Room(String roomType, double costPerNight) {
        this.roomType = roomType;
        this.costPerNight = costPerNight; 
    }

    // Getter method to retrieve the room type
    public String getRoomType() {
        return roomType;
    }
// getter cost per night method
public double getCostPerNight() {

    return costPerNight; 
}

  // Abstract methods for room beds and sofas 
  public abstract String getBeds();

  public abstract String getSofa();

}
