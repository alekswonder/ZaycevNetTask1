import java.util.ArrayList;

public class GetDiscount implements Discountable {
    private int[] price;
    private int discount;
    private int offset;
    private int readLength;

    public GetDiscount(int[] price, int discount, int offset, int readLength) {
        this.price = price;
        this.discount = discount;
        this.offset = offset;
        this.readLength = readLength;
    }

    public int[] getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public int getOffset() {
        return offset;
    }

    public int getReadLength() {
        return readLength;
    }

    /**
     * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции offset
     * на количество позиций readLength. Новые цены округляем “вниз”,
     * до меньшего целого числа.
     * @param price - исходные цены, цена должна быть больше нуля
     * @param discount - % скидки, должен попадать в диапазон от 1 до 99
     * @param offset - номер позиции, с которой нужно применить скидку, должен быть больше или равен нулю
     * @param readLength - количество позиций, к которым нужно применить скидку, должно быть больше нуля
     * @return - массив новых цен.
     */
    @Override
    public int[] decryptData(int[] price, int discount, int offset, int readLength) throws WrongLengthForReadException, WrongPositionException {
        //TODO реализовать метод
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        int tmp = 0;
        if (readLength > price.length || readLength < 0) {
            System.out.println("Неверная длинна массива");
            throw new WrongLengthForReadException("Wrong length for read array exception");
        }
        if (offset < 0 || offset > price.length-1) {
            System.out.println("Неверный номер позиции");
            throw new WrongPositionException("Wrong position to offset from array");
        }
        while (count < readLength) {
            for (int i = offset; i < price.length; i++) {
                result.add(price[i]*discount/100);
                if (i == price.length-1 || i == readLength) {
                    count = readLength+1;
                    break;
                }
            }
            count++;
        }
        return (result.stream().mapToInt(i -> i).toArray());
    }
}
