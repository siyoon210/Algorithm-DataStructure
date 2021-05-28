package codingTest.c0llbus.p1;

import java.util.*;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class C0llBus {
    public boolean isServiceTime(int day, int hourOfDay) {
        final DayOfWeek dayOfWeek = DayOfWeek.getByIntValue(day);
        return dayOfWeek.isServiceTime(hourOfDay);
    }
}

enum DayOfWeek {
    MON(23),
    TUE(0, 1, 2, 3, 23),
    WED(0, 1, 2, 3, 22, 23),
    THU(0, 1, 2, 3, 23),
    FRI(0, 1, 2, 3, 23),
    SAT(0, 1, 2, 3, 23),
    SUN(0, 1, 2, 3);

    private static final Map<Integer, DayOfWeek> dayOfWeeks = new HashMap<>();

    static {
        dayOfWeeks.put(0, MON);
        dayOfWeeks.put(1, TUE);
        dayOfWeeks.put(2, WED);
        dayOfWeeks.put(3, THU);
        dayOfWeeks.put(4, FRI);
        dayOfWeeks.put(5, SAT);
        dayOfWeeks.put(6, SUN);
    }

    private final Set<Integer> serviceTime;

    DayOfWeek(Integer... serviceTime) {
        this.serviceTime = new HashSet<>(Arrays.asList(serviceTime));
    }

    public static DayOfWeek getByIntValue(int intDay) {
        if (intDay < 0 || intDay > 6) {
            throw new IllegalArgumentException("Argument 'day' Expected 0 ~ 6 but was" + intDay);
        }

        return dayOfWeeks.get(intDay);
    }

    public boolean isServiceTime(int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            throw new IllegalArgumentException("Argument 'hourOfDay' value Expected 0 ~ 23 but was" + hourOfDay);
        }

        return serviceTime.contains(hourOfDay);
    }
}

public class P1 {
    public static void main(String[] args) {
        C0llBus c0llBus = new C0llBus();

        assertThat(c0llBus.isServiceTime(0, 23)).isEqualTo(true);
        assertThat(c0llBus.isServiceTime(0, 22)).isEqualTo(false);
        assertThat(c0llBus.isServiceTime(6, 23)).isEqualTo(false);
        assertThat(c0llBus.isServiceTime(0, 1)).isEqualTo(false);
        assertThat(c0llBus.isServiceTime(2, 22)).isEqualTo(true);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> c0llBus.isServiceTime(-1, 22));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> c0llBus.isServiceTime(0, 30));

        out.println("callbus p1" + " success!");
    }
}
