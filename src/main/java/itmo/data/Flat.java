package itmo.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

/**
 * Класс элемента коллекции.
 */
public class Flat {
    /**
     * Поле, которое генерирует коллекция в момент добавления элемента.
     * Значение поля должно быть больше 0,
     * Значение этого поля должно быть уникальным,
     * Значение этого поля должно генерироваться автоматически
     */
    private int id;
    /**
     * Текстовое описание объекта.
     * Поле не может быть null,
     * Строка не может быть пустой
     */
    private String name;
    /**
     * Поле с координатами объекта.
     * Поле не может быть null
     */
    private Coordinates coordinates;
    /**
     * Дата создания объекта.
     * Поле не может быть null,
     * Значение этого поля должно генерироваться автоматически
     */
    private LocalDateTime creationDate;
    /**
     * Площадь объекта.
     * Значение поля должно быть больше 0
     */
    private long area;
    /**
     * Количество комнат в квартире.
     * Значение поля должно быть больше 0
     */
    private long numberOfRooms;
    /**
     * Этаж, на котором расположена квартира.
     * Значение поля должно быть больше 0
     */
    private Integer height;
    /**
     * Время до ближайшей станции метро или остановки городского транспорта в минутах.
     * Значение поля должно быть больше 0
     */
    private long timeToMetroByTransport;
    /**
     * Перечисление констант вида из окон квартиры.
     * Поле может быть null
     */
    private View view;
    /**
     * Дом в котором находится квартира.
     * Поле не может быть null
     */
    private House house;

    public Flat() {
    }

    public Flat(int id) {
        this.id = id;
    }

    /**
     * Инициализирует поле name,
     * Значение получаем из пользовательского ввода.
     * @param sc объект пользовательского ввода.
     */
    private void initName(Scanner sc) {
        System.out.println("Введите описание квартиры:");
        name = sc.nextLine();
    }

    /**
     * Проверка валидности поля name.
     * @param name проверяемая строка
     * @return true, если поле name валидно, иначе false.
     */
    private boolean checkNameFlat(String name) {
        if (Objects.isNull(name)) {
            System.out.println("Ошибка. Поле не может быть NULL.");
            return false;
        }
        if (name.trim().isEmpty()) {
            System.out.println("Ошибка. Значение поля не может быть пустой строкой.");
        return false;
        }
        return true;
    }

    /**
     * Получает число типа long из пользовательского ввода.
     * @param sc объект scanner пользовательского ввода.
     * @param ask строка с окончанием запроса ввода.
     * @return целое число, полученное от пользователя.
     */
    private long initLongValue(Scanner sc, String ask) {
        boolean flag = true;
        long number = 0;
        do {
            System.out.println("Введите целое число " + ask);
            try {
                number = Long.parseLong(sc.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введено не целое число.");
            }
        } while (flag);
        return number;
    }

    /**
     * Инициализация поля height значением, полученным из пользовательского ввода.
     * @param sc объект scanner пользовательского ввода.
     */
    private void initHeight(Scanner sc) {
        boolean flag = true;
        do {
            System.out.println("Введите целое число этаж height:");
            try {
                height = Integer.parseInt(sc.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введено не целое число. Повторите ввод.");
            }
        } while (flag);
    }

    /**
     * Проверяет, что полученное число больше нуля.
     * @param number целое число
     * @return true, если число положительное, иначе false.
     */
    private boolean checkPositive(Number number) {
        if (number.longValue() <= 0) System.out.println("ошибка. число должно быть больше 0");
        return number.longValue() > 0;
    }

    /**
     * Инициализация поля view используя пользовательский ввод.
     * Если введена пустая строка возвращает NULL.
     * @param sc объект scanner пользовательского ввода.
     */
    private void initView (Scanner sc) {
        boolean flag = true;
        do {System.out.println("Выберите константу для view из списка:");
            System.out.println(View.getListNamesOfView());
            String input = sc.nextLine().trim().toUpperCase();
            if (input.isEmpty()) return;
            if (View.contain(input)) {
                view= View.valueOf(input);
                flag=false;
            } else System.out.println("Ошибка. введено не правильное имя константы перечисления.");
        } while (flag);
    }

    /**
     * Инициализирует объект Flat используя пользовательский ввод.
     * @param sc объект пользовательского ввода.
     */
    public void createFlat(Scanner sc) {
        do {
            initName(sc);
        } while (!checkNameFlat(name));
        coordinates = (new Coordinates()).createCoordinates(sc);
        creationDate = LocalDateTime.now();
        do {
            area = initLongValue(sc, " квадратных метров:");
        } while (!checkPositive(area));
        do {
              numberOfRooms = initLongValue(sc, " комнат в квартире:");
      } while (!checkPositive(numberOfRooms));
        do {
            initHeight(sc);
        } while (!checkPositive(height));
        do {
            timeToMetroByTransport = initLongValue(sc, " минут до ближайшей остановки городского транспорта:");
        } while (!checkPositive(timeToMetroByTransport));
        initView(sc);
        house = (new House()).createHouse(sc);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");

        return "Flat{ id=" + id + ", name='" + name + "''\n" +
                coordinates +
                "creationDate=" + creationDate.format(formatter) +
                ",\n area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", height=" + height +
                ", timeToMetroByTransport=" + timeToMetroByTransport +
                ", view=" + view +
                ",\n" + house +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Flat flat = new Flat();


        flat.createFlat(sc);
        System.out.println(flat);
    }
}

