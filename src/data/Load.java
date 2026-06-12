package data;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class Load {

    public static SaveData loadData(String fileName) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, SaveData.class);
        }
    }

}
