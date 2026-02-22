package bg.sofia.uni.fmi.mjt.order.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public record Order(String id, LocalDate date, String product, Category category,
                    double price, int quantity, double totalSales,
                    String customerName, String customerLocation,
                    PaymentMethod paymentMethod, Status status) {

    private static final int ID_INDEX = 0;
    private static final int DATE_INDEX = 1;
    private static final int PRODUCT_INDEX = 2;
    private static final int CATEGORY_INDEX = 3;
    private static final int PRICE_INDEX = 4;
    private static final int QUANTITY_INDEX = 5;
    private static final int TOTAL_SCALES_INDEX = 6;
    private static final int CUSTOMER_NAME_INDEX = 7;
    private static final int CUSTOMER_LOCATION_INDEX = 8;
    private static final int PAYMENT_METHOD_INDEX = 9;
    private static final int STATUS_INDEX = 10;

    public static Order of(String line) {
        final String[] fields = line.split(",");
        return new Order(fields[ID_INDEX],
                LocalDate.parse(fields[DATE_INDEX], DateTimeFormatter.ofPattern("dd-MM-yy")),
                fields[PRODUCT_INDEX],
                Category.valueOf(fields[CATEGORY_INDEX].trim().replace(" ", "_").toUpperCase()),
                Double.parseDouble(fields[PRICE_INDEX]),
                Integer.parseInt(fields[QUANTITY_INDEX]),
                Double.parseDouble(fields[TOTAL_SCALES_INDEX]),
                fields[CUSTOMER_NAME_INDEX],
                fields[CUSTOMER_LOCATION_INDEX],
                PaymentMethod.valueOf(fields[PAYMENT_METHOD_INDEX].trim().replace(" ", "_").toUpperCase()),
                Status.valueOf(fields[STATUS_INDEX].trim().replace(" ", "_").toUpperCase()));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
