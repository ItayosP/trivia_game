
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Questions {
    public static void properties(int num, int category, String difficulty) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        
            .uri(URI.create("https://opentdb.com/api.php?amount="+(Math.max(10, num))+"&category="+(category==0?0:category+8)+"&difficulty="+difficulty+"&type=multiple"))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response code: "+response.statusCode());
        String json = response.body();
        SaveTo.saveJson(json);

    }

    public static void listCategories() throws IOException, InterruptedException {
        System.out.println("""
                           0. Any Category
                           1. General Knowledge
                           2. Entertainment: Books
                           3. Entertainment: Film
                           4. Entertainment: Music
                           5. Entertainment: Musicals & Theatres
                           6. Entertainment: Television
                           7. Entertainment: Video Games
                           8. Entertainment: Board Games
                           9. Science & Nature
                           10. Science: Computers
                           11. Science: Mathematics
                           12. Mythology
                           13. Sports
                           14. Geography
                           15. History
                           16. Politics
                           17. Art
                           18. Celebrities
                           19. Animals
                           20. Vehicles
                           21. Entertainment: Comics
                           22. Science: Gadgets
                           23. Entertainment: Japanese Anime & Manga
                           24. Entertainment: Cartoon & Animations
                           """);
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
