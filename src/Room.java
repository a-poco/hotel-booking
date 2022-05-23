package src;
public class Room {
    private int number;
    private boolean available;

    public Room(int number) {
        this.number = number;
        this.available = true;
    }

    public int getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return available;
    }

    public int setAvailable(boolean available) {
        this.available = available;
        return this.number;
    }
}
