package Calculator;

import java.util.ArrayList;
import java.util.Scanner;


public class List {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть перше ціле число:  ");
        String x = in.next();
        System.out.println("Введіть потрібну операцію з переліку: PLUS, MINUS, MULTIPLICATION, DIVISION, REMAIDER");
        String operation = in.next();
        Operations operations = Operations.valueOf(operation);
        System.out.println("Введіть друге ціле число:  ");
        String y = in.next();
        java.util.List<String> integerList = new ArrayList<>();
        integerList.add(x);
        integerList.add(operation);
        integerList.add(y);
        System.out.println("Ваш приклад:    " + x + "  " + operations + "  " + y);
        String result = String.valueOf(calculate(integerList));
        System.out.println("Ваш результат:  " + result);
        in.close();
    }

    public static Integer calculate(java.util.List<String> list) {
        Integer x, y;
        Operations operation;
        x = Integer.valueOf(list.get(0));
        operation = Operations.valueOf(list.get(1));
        y = Integer.valueOf(list.get(2));
        Integer result = null;
        switch (operation) {
            case PLUS:
                result = x + y;
                break;
            case MINUS:
                result = x - y;
                break;
            case MULTIPLICATION:
                result = x * y;
                break;
            case DIVISION:
                if (y != 0) {
                    result = x / y;
                    break;
                } else {
                    System.out.println("Ділення на 0 не можливе!");
                    return result;
                }
            case REMAIDER:
                if (y != 0) {
                    result = x / y;
                    break;
                } else {
                    System.out.println("Ділення на 0 не можливе!");
                    return result;
                }
        }
        return result;
    }
}



