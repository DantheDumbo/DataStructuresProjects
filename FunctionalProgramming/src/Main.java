import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fish> school = new ArrayList<>();
        school.add(new Fish("carp", 4.7));
        school.add(new Fish("mullet", 9.6));
        school.add(new Fish("albacore", 2.7));

        System.out.println(school); // unsorted

        // sort the fish
        Collections.sort(school, (f1, f2) -> f1.getSpecies().compareTo(f2.getSpecies()));

        System.out.println(school); // sorted

    }
}