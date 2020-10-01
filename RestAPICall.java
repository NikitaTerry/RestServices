import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
//import java.util.stream.Collectors.joining;
//import java.util.stream.Collectors.toList;
import java.net.*;



class Result {

    /*
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     */

    public static int getTotalGoals(String team, int year) throws IOException {
        URL urlForGetRequest = new URL("https://jsonmock.hackerrank.com/api/football_matches");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("year", "2011");
        connection.addRequestProperty("team", "Barcelona");
        connection.addRequestProperty("page", "2");
        
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        
        if(responseCode == HttpURLConnection.HTTP_OK)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while((readLine = in.readLine()) !=null)
            {
                response.append(readLine);
            }
            in.close();
            System.out.println(response.toString());
        }
        return 1;
    }

}

public class RestAPICall{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String team = bufferedReader.readLine();

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getTotalGoals(team, year);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
