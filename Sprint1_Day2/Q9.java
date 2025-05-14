import java.util.*;

class Event {
    String title;
    String time;
    String desc;

    Event(String title, String time, String desc) {
        this.title = title;
        this.time = time;
        this.desc = desc;
    }

    public String toString() {
        return time + " - " + title + " (" + desc + ")";
    }
}

public class Q9 {
    public static void main(String[] args) {
        TreeMap<String, ArrayList<Event>> calendar = new TreeMap<>();

        ArrayList<Event> eventsOn15 = new ArrayList<>();
        Event event1 = new Event("Meeting", "10AM", "Project discussion");
        eventsOn15.add(event1);
        calendar.put("2025-05-15", eventsOn15);

        ArrayList<Event> eventsOn17 = new ArrayList<>();
        Event event2 = new Event("Hackathon", "9AM", "Coding challenge");
        eventsOn17.add(event2);
        calendar.put("2025-05-17", eventsOn17);

        Set<String> dates = calendar.keySet();
        for (String date : dates) {
            System.out.println("Date: " + date);

            ArrayList<Event> events = calendar.get(date);
            for (Event e : events) {
                System.out.println(e);
            }
        }
    }
}
