package another.solution.ex;

import org.junit.Test;

import java.util.Date;
import java.util.TreeMap;

import static java.lang.System.currentTimeMillis;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class DurationTest {
    public static final long MILLIS_PER_MIN = 1000L * 60;
    public static final long MILLIS_PER_HOUR = MILLIS_PER_MIN * 60;
    private static final long MILLIS_PER_DAY = MILLIS_PER_HOUR * 24;
    private final Duration duration = new Duration(new TreeMap<>(){{
        put(MILLIS_PER_MIN, "mins");
        put(MILLIS_PER_HOUR, "hours");
        put(MILLIS_PER_DAY, "days");
    }});

    @Test
    public void shouldReportLastSeenInMinutes() {
        Date twoMinsAgo = timeAgo(2 * MILLIS_PER_MIN);
        assertEquals("2 mins ago", duration.lastSeen(twoMinsAgo));
    }
    @Test
    public void shouldReportLastSeenInHours() {
        Date fiveHoursAgo = timeAgo(5 * MILLIS_PER_HOUR);
        assertEquals("5 hours ago", duration.lastSeen(fiveHoursAgo));
    }

    @Test
    public void shouldReportLastSeenInDays() {
        Date fourDaysAgo = timeAgo(4 * MILLIS_PER_DAY);
        assertEquals("4 days ago", duration.lastSeen(fourDaysAgo));
    }

    @Test
    public void shouldBeAbleToRegisterNewDurationsOnTheFly(){
        Date fifteenDaysAgo = timeAgo(15 * MILLIS_PER_DAY);
        assertEquals("15 days ago", duration.lastSeen(fifteenDaysAgo));
        duration.register("weeks", 7 * MILLIS_PER_DAY);
        assertEquals("2 weeks ago", duration.lastSeen(fifteenDaysAgo));

    }
    @Test
    public void shouldNotAllowToOverwriteExistingDurations(){
        try {
            duration.register("weeks", MILLIS_PER_DAY);
            fail("should never reach here");
        } catch (RuntimeException e){
            assertEquals(MILLIS_PER_DAY + " is already register for days", e.getMessage());
        }
    }

    private Date timeAgo(long delta) {
        return new Date(currentTimeMillis() - delta);
    }
}
