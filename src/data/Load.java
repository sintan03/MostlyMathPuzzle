package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;


public class Load {

    public static SaveData loadData(String fileName) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, SaveData.class);
        }
    }
    
    public static void defaultSave() throws IOException {
    
        Path saveDir = Path.of("saves");
        Path saveFile = saveDir.resolve("save1.json");

        if (!Files.exists(saveDir)) {
            Files.createDirectories(saveDir);
        }
        
        if (!Files.exists(saveFile)) {
            Files.createFile(saveFile);
        
            SaveData data = new SaveData();
        
            Files.writeString(
                    saveFile,
                    new GsonBuilder()
                            .setPrettyPrinting()
                            .create()
                            .toJson(data)
            );
        }
    }

}
