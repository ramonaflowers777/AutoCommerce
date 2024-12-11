package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ErrorMessageUtils {
    private static final String filePath = "src/test/resources/testdata/errorMessages.json";

    public static List<String> errorMessagesList() throws IOException {
        Gson gson = new Gson();

        try (FileReader fileReader = new FileReader(filePath)) {
            JsonObject jsonObject = gson.fromJson(fileReader, JsonObject.class);
            List<String> errorMessages = new ArrayList<>();
            jsonObject.getAsJsonArray("errorMessages").forEach(jsonElement ->
                    errorMessages.add(jsonElement.getAsString())
            );
            return errorMessages;
        }
    }
}
