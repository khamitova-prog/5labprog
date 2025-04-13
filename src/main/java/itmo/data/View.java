package itmo.data;

/**
 * Перечисление видов из окна квартиры.
 */
public enum View {
    PARK,
    GOOD,
    TERRIBLE;

    /**
     * Создает строку, содержащую список имен констант перечисления.
     * @return строку с именами констант перечисления через запятую.
     */
public static String getListNamesOfView() {
        var listNames = new StringBuilder();
        for (View view : values()) {
            listNames.append(view.name()).append(", ");
        }
        return listNames.substring(0, listNames.length() - 2) + ".";
    }

    /**
     * Проверяет соответствие полученной строки одной из констант перечисления.
     * @param str проверяемая строка
     * @return true, если строка соответствует одной из констант перечисления, иначе false.
     */
    public static boolean contain(String str) {
        for (View view : values()) {
            if (str.trim().equals(view.name())) return true;
        }
        return false;
    }
}

