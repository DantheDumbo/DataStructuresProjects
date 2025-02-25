import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        System.out.println("Comparable");

        Player[] team = new Player[3];
        team[0] = new Player();
        team[1] = new Player(28, "Pasternak", 95);
        team[2] = new Player(36, "Marchy", 89);

        for (Player a : team) {
            System.out.println(a);
        }

        Arrays.sort(team);
        System.out.println();

        for (Player a : team) {
            System.out.println(a);
        }
        System.out.println("----------------------------");
        System.out.println("Now with comparator");


        OtherPlayer[] otherTeam = new OtherPlayer[3];
        otherTeam[0] = new OtherPlayer();
        otherTeam[1] = new OtherPlayer(28, "Pasternak", 95);
        otherTeam[2] = new OtherPlayer(36, "Marchy", 89);

        for (OtherPlayer a : otherTeam) {
            System.out.println(a);
        }
        System.out.println();

        Comparator<OtherPlayer> com = new Comparator<OtherPlayer>() {
            public int compare(OtherPlayer p1, OtherPlayer p2) {
                if (p1.getOverAll() < p2.getOverAll()) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
        Arrays.sort(otherTeam, com);

        for (OtherPlayer a : otherTeam) {
            System.out.println(a);
        }

    }
}