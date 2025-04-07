import java.io.FileWriter;
import java.io.IOException;

public class SaveTo {

    private static final String file_path = "data.json";

    public static void saveJson(String json) {
        //System.out.println(json);
        try (FileWriter fw = new FileWriter(file_path)) {
            fw.write(json);
            fw.flush();
            System.out.println("done");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}