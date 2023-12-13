public class DataException extends Exception {
    public DataException() {
    }

    public void dataException(String i) {
        System.out.println("Exception: DataFormatError");
        System.out.printf("Некорректный формат: %s", i);
        System.out.println();
    }    
}
