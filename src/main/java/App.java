import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class App {
    private final static String GET_TIKER = "https://api.binance.com/api/v3/ticker/price?symbol=";
    private final static String BTCUSDT = "BTCUSDT";


    public static void main(String[] args) throws IOException {
        URL url = new URL(GET_TIKER + BTCUSDT);
        URLConnection urlConnection = url.openConnection();
        System.out.println("Connected to Binance API");

        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(urlConnection.getInputStream()))) {

            bufferedReader.lines().forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
