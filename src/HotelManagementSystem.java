package src;

import java.util.Scanner;

class HotelManagementSystem {
    public static void main(String[] args) {
        Hotel myHotel = new Hotel(999);

        System.out.println("Welcome to the Hotel Maangement System.");

        int selectedOption = -1;

        while (selectedOption != 0) {
            System.out.println(
                    "Pick between the following options: \n1 - Show available rooms\n2 - Book a room!\n3 - Check out\n0 - Exit");

            Scanner input = new Scanner(System.in);
            selectedOption = input.nextInt();
            switch (selectedOption) {
                case 1:
                    System.out.println("\nThe available rooms are " + myHotel.getNumberOfAvailableRooms());
                    break;
                case 2:
                    int number = myHotel.bookNextAvailableRoom();

                    if (number > 0) {
                        System.out.println("\nThank you for your booking! Your room's number is " + number);
                    } else {
                        System.out.println("\nSomething went wrong!!");
                    }
                    break;
                case 3:
                    System.out.println("\nWhat is your room's number?");
                    Scanner roomNumber = new Scanner(System.in);
                    int selectedRoomNumber = roomNumber.nextInt();
                    System.out.println("You want to checkout from room number " + selectedRoomNumber);

                    boolean result = myHotel.checkoutRoom(selectedRoomNumber);

                    if (result) {
                        System.out.println("Checked out completed!!");
                    } else {
                        System.out.println("\nSomething went wrong!!");
                    }
                    break;
                case 0:
                    System.out.println("\nGoodbye!!");
                    break;
                default:
                    System.out.println("\nunknown option, try again!");
                    break;
            }
        }
    }
}