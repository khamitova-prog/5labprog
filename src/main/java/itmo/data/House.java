package itmo.data;

import java.util.Objects;
import java.util.Scanner;

/**
 * Класс предоставляет жилое здание.
 */
public class House {
    /**
     * Строка, содержащая название улицы и номер дома через пробел.
     * Поле не может быть null
     */
    private String name;
    /**
     * Полное количество лет эксплуатации здания.
     * Значение поля должно быть больше 0
     */
    private Integer year;
    /**
     * Число этажей здания.
     * Значение поля должно быть больше 0
     */
    private long numberOfLifts;

    public House() {
    }

    public House(String name, Integer year, long numberOfLifts) {
        this.name = name;
        this.year = year;
        this.numberOfLifts = numberOfLifts;
    }

    /**
     * Инициализирует поле name.
     * @param sc объект сканера пользовательского ввода.
     */
    private void initName(Scanner sc) {
        System.out.println("Введите улицу и номер дома через пробел  house: ");
        name = sc.nextLine();
    }

    /**
     * Проверяет валидность поля name.
     * @param name строка пользовательского ввода.
     * @return true при успешной валидации, иначе false.
     */
    public boolean checkName(String name) {
        if (Objects.isNull(name)) {
            System.out.println("Ошибка. Поле name не может быть NULL.");
            return false;
        }
        if (name.trim().isEmpty()) {
            System.out.println("Ошибка. Имя не может быть пустым. Повторите ввод.");
        return false;
        }
        return true;
    }

    /**
     * Инициализация поля year.
     * Null, если введена пустая строка.
     * @param sc объект пользовательского ввода.
     */
    private void initYear(Scanner sc) {
        boolean flag = true;
        do {
            System.out.println("Введите целое число лет эксплуатации здания year: ");
            try {
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    year = null;
                    return;
                }
                year = Integer.parseInt(str);
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введено не целое число. Повторите ввод.");
            }
        } while (flag);
    }

    /**
     * Проверяет валидность поля year.
     * @param year проверяемый объект, полученный из пользовательского ввода.
     * @return true при успешной проверке, иначе false.
     */
    public boolean checkYear(Integer year) {
        if (Objects.isNull(year)) return true;
        if (year < 1) {
            System.out.println("Ошибка. Введенное число должно  быть больше нуля. Повторите ввод.");
        return false;
        }
        return true;
    }

    /**
     * Инициализация поля numberOfLifts.
     * @param sc объект пользовательского ввода.
     */
    private void initNumberOfLifts(Scanner sc) {
        boolean flag = true;
        do {
            System.out.println("Введите целое число этажей дома initNumberOfLifts(sc)numberOfLifts: ");
            try {
                numberOfLifts = Long.parseLong(sc.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введено не целое число. Повторите ввод.");
            }
        } while (flag);
    }

    /**
     * Проверяет валидность поля numberOfLifts.
     * @param numberOfLifts значение, полученное из пользовательского ввода.
     * @return true при успешной проверке, иначе false.
     */
    public boolean checkNumberOfLifts(long numberOfLifts) {
        if (numberOfLifts < 1) {
            System.out.println("Ошибка. Введенное число должно  быть больше нуля. Повторите ввод.");
        return false;
        }
        return true;
    }

    /**
     * Создает объект House
     * используя значения, полученные из пользовательского ввода
     * с валидацией полей.
     * @param sc объект пользовательского ввода.
     * @return объект House.
     */
    public House createHouse(Scanner sc) {
        do {
            initName(sc);
        } while (!checkName(name));
        do {
            initYear(sc);
        } while (!checkYear(year));
        do {
            initNumberOfLifts(sc);
        }while (!checkNumberOfLifts(numberOfLifts));
        return this;
    }


    /**
     * Создает строковое представление объекта House.
     * @return созданную строку.
     */
    @Override
    public String toString() {
        return "House: name='" + name + "', year=" + year + ", numberOfLifts=" + numberOfLifts + ";";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println((new House()).createHouse(sc));
    }
}

