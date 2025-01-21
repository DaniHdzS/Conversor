import java.util.Scanner;

public class CurrencyConvertApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("Seleccione la moneda de destino:");
            System.out.println("1. USD (Dólar estadounidense)");
            System.out.println("2. EUR (Euro)");
            System.out.println("3. MXN (Peso mexicano)");
            System.out.println("4. ARS (Peso argentino)");
            System.out.println("5. CAD (Dólar canadiense)");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (option == 6) {
                System.out.println("Saliendo del programa. ¡Hasta luego!");
                exit = true;
                continue;
            }

            String[] currencies = {"USD", "EUR", "MXN", "ARS", "CAD"};
            if (option < 1 || option > 5) {
                System.out.println("Opción inválida. Intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese la cantidad en su moneda base (USD): ");
            double amount = scanner.nextDouble();

            try {
                String targetCurrency = currencies[option - 1];
                double convertedAmount = CurrencyConverter.convert("USD", targetCurrency, amount);
                System.out.printf("Resultado: %.2f USD son %.2f %s%n", amount, convertedAmount, targetCurrency);
            } catch (Exception e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

