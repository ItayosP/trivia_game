import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class JsonReader {
        public static void readJson(String file_path) {
        try {
            
            String json = new String(Files.readAllBytes(Paths.get(file_path)));

            String[] idk = Divider.DivideQuestions(json);

            idk[0] = idk[0].substring(30); //first
            idk[idk.length-1] = idk[idk.length-1].substring(0, idk[idk.length-1].length()-3); //last


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
                


                System.out.println(subQuestions);
                System.out.println(subAnswer);
                // System.out.println(subIncAns.replaceAll("\"", ""));
                System.out.println(Arrays.toString(arr2));


                // System.out.println(idk[i].substring(indexQuestion));
                // System.out.println(idk[i].substring(indexCorrect));
                // System.out.println(idk[i].substring(indexIncorrect));
                

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
