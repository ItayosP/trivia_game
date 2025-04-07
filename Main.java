import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String file_path = "data.json";
        
        Scanner s = new Scanner(System.in);

        JsonReader.readJson("data.json");

        Divider.DivideQuestions(file_path);

    }
}

//https://opentdb.com/api.php?amount=10
//https://opentdb.com/api.php?amount=10&category=20
//https://opentdb.com/api.php?amount=10&difficulty=medium
//https://opentdb.com/api.php?amount=10&type=multiple

//https://opentdb.com/api.php?amount=10&category=18&difficulty=hard&type=multiple