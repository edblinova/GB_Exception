public class DateException extends Exception {
    public DateException() {
    }

    public void dateException(String i) {
        System.out.println("Exception: DateFormatError");
        System.out.printf("Некорректный формат даты: %s", i);
        System.out.println();
    }
}