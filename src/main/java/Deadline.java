import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    private LocalDate byDate = null;
    private LocalTime byTime = null;

    public Deadline(String description, String byDate) {
        super(description);
        String[] rawDateTime = byDate.split(" ");
        String[] date = rawDateTime[0].split("/");
        if (date[0].length() < 2) {
            date[0] = "0" + date[0];
        }
        if (date[1].length() < 2) {
            date[1] = "0" + date[1];
        }
        String formattedDate = date[2] + "-" + date[1] + "-"
                + date[0];
        String formattedTime = "" + rawDateTime[1].charAt(0)
                + rawDateTime[1].charAt(1) + ":" + rawDateTime[1].charAt(2)
                + rawDateTime[1].charAt(3) + ":00";
        this.byDate = LocalDate.parse(formattedDate);
        this.byTime = LocalTime.parse(formattedTime);
    }

    @Override
    public String toString() {
        return String.format("[%s][%s] %s (by: %s, %s)", "D", (getIsDone() ? "\u2713" : "\u2718"), getDescription()
                , byDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                , byTime.format(DateTimeFormatter.ofPattern("h:mma")));
    }
}