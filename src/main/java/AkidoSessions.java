import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class AkidoSessions {
    private List<LocalDateTime> sessions;

    public AkidoSessions() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(LocalDateTime date) {
        this.sessions.add(date);
    }

    public int getNumberOfSessions() {
        return this.sessions.size();
    }

    public int getTotalMonths() {
        if (this.sessions.isEmpty()) {
            return 0;
        }
        LocalDateTime earliest = sessions.get(0);
        LocalDateTime latest = sessions.getLast();
        return Period.between(earliest.toLocalDate(), latest.toLocalDate()).getMonths();
    }

    public boolean isEligibleForGraduation() {
        return getNumberOfSessions() >= 100 || getTotalMonths() >= 6;
    }

    public static void main(String[] args) {
        AkidoSessions akidoSessions = new AkidoSessions();

        while (true) {
            System.out.println("\n===== Aikido Practice Tracker =====\n" +
                    "\n" +
                    "1. Add Practice Session\n" +
                    "2. View Total Practice Time\n" +
                    "3. Check Graduation Eligibility\n" +
                    "4. Exit Choose an option:");
            System.out.println("Choose an option: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("\nEnter the date in format YYYY-MM-DD: ");
                    String date = sc.nextLine();
                    akidoSessions.addSession(LocalDateTime.parse(date + "T00:00:00"));
                    break;
                case 2:
                    System.out.println("Sessions: " + akidoSessions.getNumberOfSessions());
                    System.out.println("Months: " + akidoSessions.getTotalMonths());
                    break;
                case 3:
                    System.out.println("Graduate ok?: " + (akidoSessions.isEligibleForGraduation() ? "Yes" : "No"));
                    break;
                case 4:
                    System.out.println("Exiting... Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

}
