
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Questions {
    public static void properties(int num, int category, String difficulty) throws IOException, InterruptedException {


        // ("https://opentdb.com/api.php?amount="+num+10+"&category="+category+"&difficulty="+difficulty)


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://opentdb.com/api.php?amount=10&category=20&difficulty=hard&type=multiple"))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response code: "+response.statusCode());
        String json = response.body();
        SaveTo.saveJson(json);

    }

    public static void listCategories() throws IOException, InterruptedException {

        System.out.println("""
                           1. Any Category\r
                           2. General Knowledge\r
                           3. Entertainment: Books\r
                           4. Entertainment: Film\r
                           5. Entertainment: Music\r
                           6. Entertainment: Musicals & Theatres\r
                           7. Entertainment: Television\r
                           8. Entertainment: Video Games\r
                           9. Entertainment: Board Games\r
                           10. Entertainment: Comics\r
                           11. Entertainment: Japanese Anime & Manga\r
                           12. Entertainment: Cartoon & Animations\r
                           13. Science & Nature\r
                           14. Science: Computers\r
                           15. Science: Mathematics\r
                           16. Mythology\r
                           17. Sports\r
                           18. Geography\r
                           19. History\r
                           20. Politics\r
                           21. Art\r
                           22. Celebrities\r
                           23. Animals\r
                           24. Vehicles\r
                           25. Science: Gadgets\r
                           """
        );
    }

//     public static void showCategories() throws IOException, InterruptedException {
//         HttpClient client = HttpClient.newHttpClient();
//         HttpRequest request = HttpRequest.newBuilder()
//             .uri(URI.create("https://opentdb.com/api_category.php"))
//             .GET()
//             .build();

//         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//         System.out.println("Response code: "+response.statusCode());
//         System.out.println("The list of the avaiable categories: "+response.body());
//     }
}
