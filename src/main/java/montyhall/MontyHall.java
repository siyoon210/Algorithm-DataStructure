package montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MontyHall {
    private final int prizeMoney = 100;
    private final Random random = new Random();
    private final List<Door> doors;

    public MontyHall() {
        this.doors = new ArrayList<>(3);
        int i = random.nextInt(3);
        this.doors.add(new Door(i == 0));
        this.doors.add(new Door(i == 1));
        this.doors.add(new Door(i == 2));
    }

    public boolean hasPrizeOfDoor(int index) {
        return doors.get(index - 1).isWin;
    }

    private static class Door {
        private boolean isWin = false;

        public Door(boolean isWin) {
            this.isWin = isWin;
        }
    }
}
