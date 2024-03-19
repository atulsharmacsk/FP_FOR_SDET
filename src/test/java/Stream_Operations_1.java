import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_Operations_1 {
    public static void main(String[] args) {
// Setting player data
        List<Player> players = List.of(
                new Player("Shreyas Iyer", 35.30),
                new Player("Shubman Gill", 35.50),
                new Player("Yashasvi Jaiswal", 68.50),
                new Player("Hanuma Vihari", 33.60),
                new Player("Rishabh Pant", 43.70)
        );
// Filtering players with batting average >= 35
        List<Player> topPlayers = players.stream()
                .filter(player -> player.getBattingAverage() >= 35)
                .collect(Collectors.toList());
        System.out.println("Top players with batting average >= 35:");
        topPlayers.forEach(System.out::println);

// Sorting players by batting average
        List<Player> sortedPlayers = players.stream()
                .sorted((p1, p2) -> Double.compare(p2.getBattingAverage(), p1.getBattingAverage()))
                .collect(Collectors.toList());
        System.out.println("\nSorted players by batting average (descending order):");
        sortedPlayers.forEach(System.out::println);

// Getting top 3 players average-wise
        List<Player> top3Players = sortedPlayers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("\nTop 3 players:");
        top3Players.forEach(System.out::println);

// Mapping player names to uppercase
        String playerNamesUppercase = players.stream()
                .map(Player::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));
        System.out.println("\nPlayer Name in Upper case: " + playerNamesUppercase);

// Player with maximum average
        Player playerMaxAverage = players.stream()
                .reduce((p1, p2) -> p1.getBattingAverage() > p2.getBattingAverage() ? p1 : p2)
                .get();
        System.out.println("\nMaximum batting average in the team: " + playerMaxAverage);
    }
}