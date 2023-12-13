import java.util.Scanner;

public class InputData {

    private Scanner scanner;

    public InputData() {
        scanner = new Scanner(System.in);
    }

    public String[] enterData() {
        while (true) {
            System.out.println("Введите строку через ПРОБЕЛ");
            System.out.println("Строка должна содержать:");
            System.out.println("                             фамилия, имя, отчество - строки, ");
            System.out.println("                             дату рождения - dd.mm.yyyy, ");
            System.out.println("                             номер телефона - цифры, ");
            System.out.println("                             пол: женщина - f или мужчина - m");
            String data = scanner.nextLine();
            String[] arrayData = data.split(" ");
            if (arrayData.length == 6) {
                return arrayData;
            } else if (arrayData.length < 6){
                System.out.println("Вы ввели не все данные! Попробуйте снова ;)");
            } else System.out.println("Вы ввели лишние данные! Попробуйте снова ;)");
        }
    }
}
