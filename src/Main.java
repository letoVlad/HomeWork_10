public class Main {
    //Задание 1
    static void checkYears(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + " номер года — високосный год");
        } else {
            System.out.println(year + " номер года — не високосный год");
        }
    }

    //Задание 2
    static void phoneCheck(int os, int years) {
        if (os == 1 && years < 2015) {
            System.out.println("«Установите облегченную версию приложения для Android по ссылке».");
        } else if (os == 0 && years < 2015) {
            System.out.println("«Установите облегченную версию приложения для iOS по ссылке».");
        } else if (os == 1 && years > 2015 || os == 0 && years > 2015) {
            System.out.println("Установите обычное приложение");
        }
    }

    //Задание 3
    static void deliveryDays(int distance) {
        int dayDelivery = 1;
        if (distance > 20 && distance < 60) {
            dayDelivery++;
        } else if (distance > 60 && distance < 100) {
            dayDelivery += 2;
        }
        System.out.println("Потребуется дней: " + dayDelivery);
    }

    public static void main(String[] args) {
        //Задание 1
        checkYears(1972);
        //Задание 2
        phoneCheck(1, 2018);
        //Задание 2
        deliveryDays(15);
    }
}