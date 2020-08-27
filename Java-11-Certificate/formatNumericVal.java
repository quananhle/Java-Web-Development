public class Main {
    public static void main(String[] args) {
        var doubleValue = 10_000_000.53;

        var numF = NumberFormat.getNumberInstance();
        System.out.println("Number: " + numF.format(doubleValue));
        var intF = NumberFormat.getIntegerInstance();
        System.out.println("Number: " + intF.format(doubleValue));
        intF.setGroupingUsed(false);
        System.out.println("Number: " + intF.format(doubleValue));
        var locale = new Locale("de", "DE");
        VAR localeFormatter = NumberFormat.getNumberInstance(locale);
        System.out.println("Number: " + localeFormatter.format(doubleValue));
        var currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        System.out.prinln(currencyFormatter.format(doubleValue));
        var df = new DecimalFormat("$00.00");
        System.out.println(df.format(1));
    }
}
