package another.solution.ex;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.currentTimeMillis;

public class Duration {

    private final TreeMap<Long, String> millisPerUnit;

    public Duration(TreeMap<Long, String> millisPerUnit) {
        this.millisPerUnit = millisPerUnit;
    }

    public String lastSeen(Date lastActivityTime) {
        long delta = currentTimeMillis() - lastActivityTime.getTime();
        Map.Entry<Long, String> closestMatch = millisPerUnit.floorEntry(delta);
        int units = (int) (delta / closestMatch.getKey());
        return units +" "+ closestMatch.getValue() + " ago";

    }

    public void register(String name, long unit) {
        if(millisPerUnit.containsKey(unit))
            throw new RuntimeException(unit + " is already register for " + millisPerUnit.get(unit));
        millisPerUnit.put(unit, name);
    }
}
