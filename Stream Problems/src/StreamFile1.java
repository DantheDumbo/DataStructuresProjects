import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFile1 {
    public static void main(String[] args) throws IOException {
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands
                .sorted()
                .filter(n -> n.length() > 1) // sort the bands
                .forEach(System.out::println);


        bands.close();
    }
}
