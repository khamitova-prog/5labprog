package itmo.data;

import java.util.Objects;
import java.util.Scanner;

/**
 * Класс предоставляет точку на плоскости.
 */
public class Coordinates {
    /**
     * Координата x.
     * Максимальное значение поля: 112,
     * Поле не может быть null
     */
    private Integer x;
    /**
     * Координата y.
     * Поле не может быть null
     */
    private Integer y;

    public Coordinates() {
    }

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Инициализация координаты X
     * значением, полученным из пользовательского ввода.
     * @param sc объект сканера пользовательского ввода.
     */
    private void initCoordinateX(Scanner sc) {
        boolean flag = true;
        do {
            System.out.print("Введите целое число coordinateX не более 112: ");
            try {
                x = Integer.parseInt(sc.nextLine().trim());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Необходимо ввести целое число. Повторите ввод.");
            }
        } while (flag);
    }

    /**
     * Инициализация координаты Y
     * значением полученным из пользовательского ввода.
     * @param sc объект сканера пользовательского ввода.
     */
    private void initCoordinateY(Scanner sc) {
        boolean flag = true;
        do {
            System.out.print("Введите целое число coordinateY: ");
            try {
                y = Integer.parseInt(sc.nextLine().trim());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Необходимо ввести целое число. Повторите ввод.");
            }
        } while (flag);
    }

    /**
     * Создание объекта Coordinates.
     * При создании объекта проходит валидация полученных значений полей.
     *
     * @param sc объект сканера пользовательского ввода.
     * @return объект Coordinates.
     */
    public Coordinates createCoordinates(Scanner sc) {
        do {
            initCoordinateX(sc);
        } while (!checkCoordinatesX(x));
        do {
            initCoordinateY(sc);
        } while (!checkCoordinateY(y));
        return this;
    }

    /**
     * Проверяет валидность поля X.
     * @param x объект поля X
     * @return true, если проверка прошла успешно, иначе false.
     */
    public boolean checkCoordinatesX(Integer x) {
        if (Objects.isNull(x)) {
            System.out.println("Ошибка. Координата X не может быть NULL.");
            return false;
        } else {
            if (x > 112) {
                System.out.println("Ошибка. Максимальное значение поля X: 112");
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет валидность поля Y
     * @param y объект поля Y
     * @return true, если проверка прошла успешно, иначе false.
     */
    public boolean checkCoordinateY(Integer y) {
        if (Objects.isNull(y)) {
            System.out.println("Ошибка. Поле координаты Y не может быть NULL.");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coordinates: x=" + x + ", y=" + y+ ";\n" ;
    }
}

