import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ParseRecords {
    public static void main(String[] args) throws IOException {
        Stream<String> db = Files.lines(Paths.get("file1.txt"));

        db
                .filter(x -> x.split(",").length == 3)
                .forEach(System.out::println);
        db.close();
    }
}
