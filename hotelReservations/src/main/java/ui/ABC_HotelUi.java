package ui;
import javax.swing.JOptionPane;
import hotelReservations.src.main.java.makeReservation;
import rooms.Room;
import rooms.deluxeRoom;
import rooms.juniorSuite;
import rooms.regularRoom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ABC_HotelUi {

    public static void main(String[] args) {
      // while loop to loop processes.
        while (true) {
                // welcome dialog box 
            int reserve = JOptionPane.showConfirmDialog(null, "                   Welcome!" + "\n" + " Would you like to reserve a room?", "makeReservation", JOptionPane.YES_NO_OPTION);
            if (reserve != JOptionPane.YES_OPTION) {
                break; // Exit the loop if the user chooses not to reserve another room
            }

        // Input dialog to get customer name
        String customerName = JOptionPane.showInputDialog(null, "Enter customer name:");

        // Selection dialog to choose room type
        String[] roomTypes = {"Junior Suite", "Deluxe Room", "Regular Room"};
      
        Room roomType = null;
        boolean roomAvailable = false;
        // room type while loop 
        while (!roomAvailable) {
            String roomTypeString = (String) JOptionPane.showInputDialog(null, "Choose room type:",
                    "Room Type", JOptionPane.QUESTION_MESSAGE, null, roomTypes, roomTypes[0]);
            // switch case for different room types checking avliable , calls the room type and shwos error message if not valid. 
        switch (roomTypeString) {
            case "Junior Suite":
                if (makeReservation.getAvailableJuniorSuiteRooms() > 0) {
                    roomType = new juniorSuite();
                    roomAvailable = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, Junior Suites are sold out.");
                }
                break;
            case "Deluxe Room":
                if (makeReservation.getAvailableDeluxeRooms() > 0) {
                    roomType = new deluxeRoom();
                    roomAvailable = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, Deluxe Rooms are sold out.");
                }
                break;
            case "Regular Room":
                if (makeReservation.getAvailableRegularRooms() > 0) {
                    roomType = new regularRoom();
                    roomAvailable = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, Regular Rooms are sold out.");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid room type.");
        }
    }
      
  
        // Input dialog to get arrival date
        String arrivalDateString = JOptionPane.showInputDialog(null, "Enter arrival date (yyyy-mm-dd):");
        Date arrivalDate = parseDate(arrivalDateString);

        // Input dialog to get departure date
        String departureDateString = JOptionPane.showInputDialog(null, "Enter departure date (yyyy-mm-dd):");
        Date departureDate = parseDate(departureDateString);

   // Create reservation object
      
        final makeReservation Reservation = new makeReservation(customerName, roomType, arrivalDate,  departureDate, 0);

        // Calculate total charge
        Reservation.calculateTotalCharge();

        // Display reservation details
        JOptionPane.showMessageDialog(null, "Reservation Details:\n" +
                "Customer Name: " + Reservation.getCustomer_name() + "\n" +
                "Room Type: " + Reservation.getRoomType().getRoomType() + "\n" +
                "Room Number: " + Reservation.getRoomNumber() +  "\n" + 
                "Arrival Date: " + Reservation.getArrivalDate() + "\n" +
                "Departure Date: " + Reservation.getdepartureDate() + "\n" +
                "Beds: " + Reservation.getRoomType().getBeds() + "\n" + 
                "Sofa: " + Reservation.getRoomType().getSofa() + "\n" +
                "Total Charge: $" + Reservation.totalCharge);
                
           // decrement available rooms count
           makeReservation.decrementAvailableRooms(roomType); ;
           // Show number of rooms available left
           JOptionPane.showMessageDialog(null, "Number of the Junior Rooms left is: " + makeReservation.getAvailableJuniorSuiteRooms() + "\n" +
           "Number of the Deluxe Rooms left is: " + makeReservation.availableDeluxeRooms +  "\n" + "Number of the Regular Rooms left is: " + makeReservation.availableRegularRooms);

           JOptionPane.showMessageDialog(null, "Thank you for making a reservation!" + "\n" + "                  Enjoy Your Stay!");


 // Option to reserve another room
 int reserveAnother = JOptionPane.showConfirmDialog(null, "Do you want to reserve another room?", "makeReservation", JOptionPane.YES_NO_OPTION);
 if (reserveAnother != JOptionPane.YES_OPTION) {
     break; // Exit the loop if the user chooses not to reserve another room
 }
}
    }
// date formatter and check
   private static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle parsing exception
            return null;
        }
    }
}

    

