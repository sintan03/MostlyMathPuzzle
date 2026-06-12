import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Utils {

    public static void out(Object... texts) {
        for (Object text : texts) {
            System.out.println(text);
        }
    }

    public static List<String> getAllFiles(String path) throws IOException {
        Path stagesDir = Path.of(path);
        try (Stream<Path> files = Files.list(stagesDir)) {
            return files.map(p -> p.getFileName().toString()).toList();
        }
    }

    public static String[] cutString(int min, int max, String... str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].substring(min, str[i].length() - max);
        }
        return str;
    }

}
