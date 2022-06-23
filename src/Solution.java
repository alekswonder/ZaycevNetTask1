import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        int prices[];
        int discount;
        int offset;
        int readLength;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите список цен через запятую:");
            String line = reader.readLine();
            prices = Arrays.stream(line.split(",")).mapToInt(s -> Integer.parseInt(s.trim())).toArray();
            System.out.println("Введите желаемую скидку:");
            discount = Integer.parseInt(reader.readLine());
            System.out.println("Введите номер позиции, откуда начнем счать новые цены:");
            offset = Integer.parseInt(reader.readLine()) - 1;
            System.out.println("Введите количество цен, которые нужно посчитать:");
            readLength = Integer.parseInt(reader.readLine());
        }

        GetDiscount getDiscount = new GetDiscount(prices, discount, offset, readLength);

        System.out.println("Новые цены: ");
        Arrays.stream(getDiscount.decryptData(getDiscount.getPrice(),
                getDiscount.getDiscount(),
                getDiscount.getOffset(),
                getDiscount.getReadLength())).forEach(System.out::println);
    }
}
