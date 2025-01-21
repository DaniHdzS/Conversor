import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/5c3c4c9f67d2a124143285db/latest/";

    public static double convert(String baseCurrency, String targetCurrency, double amount) throws Exception {
        String url = API_URL + baseCurrency;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ExchangeRateParser parser = new ExchangeRateParser();
            double rate = parser.getExchangeRate(response.body(), targetCurrency);
            return amount * rate;
        } else {
            throw new RuntimeException("Error al obtener los datos. Código de respuesta: " + response.statusCode());
        }
    }
}
