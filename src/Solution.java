import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] prices = new int[] {5,100,20,66,16};
        int discount = 50;
        int offset = 1;
        int readLength = 3;

        GetDiscount getDiscount = new GetDiscount(prices, discount, offset, readLength);

        try {
            Arrays.stream(getDiscount.decryptData(getDiscount.getPrice(),
                                                getDiscount.getDiscount(),
                                                getDiscount.getOffset(),
                                                getDiscount.getReadLength())).forEach(System.out::println);
        } catch (WrongLengthForReadException e) {
            e.printStackTrace();
        } catch (WrongPositionException e) {
            e.printStackTrace();
        }
    }
}
