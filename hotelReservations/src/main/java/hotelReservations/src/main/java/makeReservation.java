package hotelReservations.src.main.java;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import rooms.Room;
import rooms.deluxeRoom;
import rooms.juniorSuite;
import rooms.regularRoom;
/**
 * reservation class information.
 * @author Kenny Howard
 */
public class makeReservation {
public int roomNumber; // room number integer 
public String customer_name; // customer name variable 
public Room roomType;  //room type variable 
public double totalCharge;  // total charge variable 
public Date arrivalDate;  // arrivale date variable 
public Date departureDate; // departure sate avriable 
public static int availableJuniorSuiteRooms = 3; // Number of available Junior Suite rooms
public static int availableDeluxeRooms = 3; // Number of available Deluxe rooms
public static int availableRegularRooms = 3; // Number of available Regular rooms
private static int lastAssignedRoomNumber = 0; // Initialize lastAssignedRoomNumber to 0



/**
 *  make reservation constructor. 
 */
public makeReservation(String customer_name ,Room roomType,Date arrivalDate,Date departureDate,double totalCharge){
                this.customer_name = customer_name; 
                this.roomType = roomType;
                this.arrivalDate = arrivalDate;
                this.departureDate = departureDate; 
                calculateTotalCharge();
                this.roomNumber = ++lastAssignedRoomNumber; // Increment room number counter and assign
              // Update available rooms count based on room type
}

/**
 * calculates the total charge in relation to the date and cost per night for a room. 
 */
public  void calculateTotalCharge() {
    long differenceInMilliseconds = departureDate.getTime() - arrivalDate.getTime();
        long differenceInDays = TimeUnit.DAYS.convert(differenceInMilliseconds, TimeUnit.MILLISECONDS);
        double costPerNight = roomType.getCostPerNight();
        totalCharge = differenceInDays * costPerNight;

}

/**
 * set room number
 */
public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
}

/**
 * gets customer name
 */
public String getCustomer_name(){
    return customer_name; 
}

/**
 * gets room type 
 */
public Room getRoomType(){
    return roomType; 
}

/**
 * gets arrival date. 
 */
public Date getArrivalDate(){
    return arrivalDate; 
}

/**
 * gets the depature date 
 */
public Date getdepartureDate(){
    return departureDate; 
}

  /**
   *gets the room number preset to 0. 
   */
  public int getRoomNumber() {
    return roomNumber;
}

/**
 * gets avliable room numbers for junior suites set at 3 avaliable. 
 */
public static int getAvailableJuniorSuiteRooms() {
    return availableJuniorSuiteRooms;
}

/**
 * gets avliable room numbers for Deluxe rooms set at 3 avlaiable. 
 */
public static int getAvailableDeluxeRooms() {
    return availableDeluxeRooms;
}

/**
 * gets avliable room numbers for Regular rooms set at 3 avaliable. 
 */
public static int getAvailableRegularRooms() {
    return availableRegularRooms;
}


/**
 * gets the last assigned room number.
 */
public static int getLastAssignedRoomNumber() {
    return lastAssignedRoomNumber;
}

    /**
     * method made to decrement each room when called depending on the room selected to help the gui update the amount of rooms left avaliable.
     */
    public static void decrementAvailableRooms(Room roomType) {
        if (roomType instanceof juniorSuite) {
            availableJuniorSuiteRooms--;
        } else if (roomType instanceof deluxeRoom) {
            availableDeluxeRooms--;
        } else if (roomType instanceof regularRoom) {
            availableRegularRooms--;
        }
    }

}
