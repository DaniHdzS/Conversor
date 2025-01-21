import com.google.gson.Gson;
import java.util.Map;

public class ExchangeRateParser {
    static class ExchangeRateData {
        String base;
        Map<String, Double> rates;
    }

    public double getExchangeRate(String jsonResponse, String targetCurrency) {
        Gson gson = new Gson();
        ExchangeRateData exchangeRateData = gson.fromJson(jsonResponse, ExchangeRateData.class);

        if (exchangeRateData.rates == null || !exchangeRateData.rates.containsKey(targetCurrency)) {
            throw new IllegalArgumentException("No se encontraron tasas de cambio para la moneda: " + targetCurrency);
        }

        return exchangeRateData.rates.get(targetCurrency);
    }
}