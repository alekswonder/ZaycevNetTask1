# ZaycevNetTask1
Метод "скидка". Применяет скидку discount к цене price, начиная с позиции offset \n
на количество позиций readLength. Новые цены округляем “вниз”,
до меньшего целого числа.
@param price - исходные цены, цена должна быть больше нуля
@param discount - % скидки, должен попадать в диапазон от 1 до 99
@param offset - номер позиции, с которой нужно применить скидку, должен быть больше или равен нулю
@param readLength - количество позиций, к которым нужно применить скидку, должно быть больше нуля
@return - массив новых цен.

public int[] decryptData( int[] price,
int discount,
int offset,
int readLength) {
//TODO реализовать метод
}

Пример
Входные данные
price = [5,100,20,66,16]
discount = 50
offset = 1
readLength = 3
Ожидаемый результат работы
[50,10,33]

Обратите особое внимание на правильность работы алгоритма (метод должен возвращать массив цен со скидкой) и на проверку граничных условий.
