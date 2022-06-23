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
    public int[] decryptData(int[] price, int discount, int offset, int readLength){
        //TODO реализовать метод
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        if (readLength > price.length || readLength < 0) {
            System.out.println("Неверная длина массива");
        }
        if (offset < 0 || offset > price.length-1) {
            System.out.println("Неверный номер позиции");
        }
        if (readLength == 0) {
            return result.stream().mapToInt(i -> i).toArray();
        }
        if (discount <= 99 && discount>= 1) {
            for (int i = offset; i < price.length; i++) {
                if (price[i] > 0) {
                    result.add(price[i] - (int) (Math.floor(price[i] * discount / 100)));
                    count++;
                    if (count == readLength) {
                        break;
                    }
                } else {
                    System.out.println("Что-то пошло не так с ценой с индексом" + price[i]);
                    result.add(price[i]);
                }
            }
        } else {
            System.out.println("Неверна задана скидка");
        }
        return (result.stream().mapToInt(i -> i).toArray());
    }
}
