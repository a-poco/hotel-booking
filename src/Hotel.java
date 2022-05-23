package src;

import java.util.ArrayList;
import java.util.Optional;

public class Hotel {
    private ArrayList<Room> rooms;

    public Hotel(int numRooms) {
        this.rooms = new ArrayList<Room>();

        for (int i = 0; i < numRooms; i++) {
            this.rooms.add(new Room(i + 1));
        }
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public long getNumberOfAvailableRooms() {
        return this.rooms.stream().filter(room -> room.isAvailable()).count();
    }

    public int bookNextAvailableRoom() {
        Optional<Room> optionalRoom = this.rooms.stream()
                .filter(room -> room.isAvailable())
                .findFirst();

        if (optionalRoom.isPresent()) {
            return optionalRoom.get().setAvailable(false);
        }

        return -1;
    }

    public boolean checkoutRoom(int roomNumber) {
        Room selectedRoom = this.rooms.get(roomNumber - 1);

        if (selectedRoom.isAvailable()) {
            return false;
        }

        this.rooms.stream().filter(room -> room.getNumber() == roomNumber).findFirst().get().setAvailable(true);
        return true;
    }
}
