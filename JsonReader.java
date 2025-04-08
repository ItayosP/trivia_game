import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JsonReader {
        public static void readJson(String file_path) {
        try {
            
            String json = new String(Files.readAllBytes(Paths.get(file_path)));

            String[] idk = Divider.DivideQuestions(json);

            idk[0] = idk[0].substring(30); //first
            idk[idk.length-1] = idk[idk.length-1].substring(0, idk[idk.length-1].length()-3); //last

            Scanner s = new Scanner(System.in);
            Random r = new Random();
            int score=0;


            for (int i=0; i<idk.length; i++) {
                int indexQuestion = idk[i].indexOf("question");
                int indexCorrect = idk[i].lastIndexOf("correct_answer\":");
                int indexIncorrect = idk[i].lastIndexOf("[");
                
                String subQuestions = idk[i].substring(indexQuestion+11, indexCorrect-3); //prints the questions
                String subAnswer = idk[i].substring(indexCorrect+17, indexIncorrect-22); //prints the correct answer
                String subIncAns = idk[i].substring(indexIncorrect+2, idk[i].length()-1).replace("\"", ""); //prints the inc answers
    
                String[] arr;
                String[] arr2 = new String[4];

                arr = (subIncAns.split(","));

                for (int j=0; j<arr.length; j++) {
                    arr2[j] = arr[j];
                }

                arr2[3] = subAnswer;

                String correctAns = subAnswer;
                
                

                
                for (int k=0; k<arr2.length; k++) {
                    int rand = r.nextInt(arr2.length);
                    String temp = arr2[rand];
                    arr2[rand] = arr2[k];
                    arr2[k] = temp;
                }




                System.out.println(subQuestions);

                System.out.println(Arrays.toString(arr2));

                System.out.println("Enter Answer: ");
                int inputAns = s.nextInt()-1;

                if (arr2[inputAns] == subAnswer) {
                    System.out.println("Correct");
                    score++;
                } else {
                    System.out.println("Incorrect, The correct answer was: "+subAnswer);
                }
            }

            System.out.println("Your score is: "+score+", Out of: "+Main.num);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
