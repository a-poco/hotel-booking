package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import src.Hotel;

public class HotelTest {

    @Test
    public void available_rooms_are_the_same_as_construstor() {
        Hotel testHotel = new Hotel(20);

        long availableRooms = testHotel.getNumberOfAvailableRooms();

        assertEquals(20, availableRooms);
    }

    @Test
    public void available_rooms_will_be_less_if_there_is_a_booking() {
        Hotel testHotel = new Hotel(20);
        testHotel.bookNextAvailableRoom();

        long availableRooms = testHotel.getNumberOfAvailableRooms();

        assertEquals(19, availableRooms);
    }

    @Test
    public void cannot_book_if_no_available_room() {
        Hotel testHotel = new Hotel(2);
        testHotel.bookNextAvailableRoom();
        testHotel.bookNextAvailableRoom();

        int lastBooking = testHotel.bookNextAvailableRoom();

        assertEquals(-1, lastBooking);
    }

    @Test
    public void can_book_if_available_room() {
        Hotel testHotel = new Hotel(2);
        testHotel.bookNextAvailableRoom();

        int lastBooking = testHotel.bookNextAvailableRoom();

        assertEquals(2, lastBooking);
    }

    @Test
    public void cannot_checkout_if_no_booked_room() {
        Hotel testHotel = new Hotel(2);

        boolean checkoutResult = testHotel.checkoutRoom(1);

        assertEquals(false, checkoutResult);
    }

    @Test
    public void can_checkout_if_there_is_booked_room() {
        Hotel testHotel = new Hotel(2);
        testHotel.bookNextAvailableRoom();

        boolean checkoutResult = testHotel.checkoutRoom(1);

        assertEquals(true, checkoutResult);
    }
}
