public class SexException extends Exception {
    public SexException() {
    }

    public void sexException(String i) {
        System.out.println("Exception: SexFormatError");
        System.out.printf("Некорректный формат: %s", i);
        System.out.println();
    }
}