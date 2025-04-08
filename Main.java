import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static int num;
    public static int category;
    public static String difficulty;

    public static void main(String[] args) throws IOException, InterruptedException {

        String file_path = "data.json";
        
        Scanner s = new Scanner(System.in);



        System.out.print("Enter number of questions: ");
        num = s.nextInt();
        num = Math.max(10, num);


        Questions.listCategories();
        System.out.print("Enter number of category: ");
        category = s.nextInt();



        System.out.println("Enter difficulty (easy, medium, hard): ");
        difficulty = s.next();
        System.out.println("NIGGER");


        Questions.properties(num, category, difficulty);

        JsonReader.readJson("data.json");

        Divider.DivideQuestions(file_path);

        

    }
}

//https://opentdb.com/api.php?amount=10
//https://opentdb.com/api.php?amount=10&category=20
//https://opentdb.com/api.php?amount=10&difficulty=medium
//https://opentdb.com/api.php?amount=10&type=multiple

//https://opentdb.com/api.php?amount=10&category=18&difficulty=hard&type=multiple