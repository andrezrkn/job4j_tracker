package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int rst = -1;

        for (int index = 0; index < products.length; index++) {
           Product pro = products[index];
            if (pro == null) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
