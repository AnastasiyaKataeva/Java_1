
import java.io.FileWriter;
import java.util.Scanner;

public class App {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthday;
    private long phone;
    private char gender;
    private Scanner scan = new Scanner(System.in);

    private void InputFirstName() {
        do {
            System.out.print("Введите имя: ");
            firstName = scan.nextLine();
            if (firstName == "") {
                System.out.println("Поле не может быть пустым!");
            } else {
                break;
            }
        } while (true);
    }

    private void InputLastName() {
        do{
            System.out.print("Введите фамилию: ");
            lastName = scan.nextLine();
            if (lastName == "") {
                System.out.println("Поле не может быть пустым!");
            } else {
                break;
            }
        } while (true);
    }

    private void InputPatronymic() {
        do{
            System.out.print("Введите отчество: ");
            patronymic = scan.nextLine();
            if (patronymic == "") {
                System.out.println("Поле не может быть пустым!");
            } else {
                break;
            }
        } while (true);
    }

    private void InputBirthday() {
        do {
            System.out.print("Введите дату рождения: ");
            birthday = scan.nextLine();
            if (birthday == "") {
                System.out.println("Поле не может быть пустым!");
            } else {
                break;
            }
        } while (true);
    }

    private void InputPhone() {
        do {
            try {
                System.out.print("Введите телефон: ");
                String number = scan.nextLine();
                if (number == "") {
                    System.out.println("Поле не может быть пустым!");
                    continue;
                }
                phone = Long.parseLong(number);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Телефон должен содержать только цифры!");
            }
            break;
        } while (true);
    }

    private void InputGender() {
        do {
            System.out.print("Введите пол (f, m): ");
            String gen;
            String f = "f";
            String m = "m";
            gen = scan.nextLine();
            if (gen.length() == 0) {
                System.out.println("Поле не должно быть пустым!");
                continue;
            }
            if (gen.length() > 1) {
                throw new RuntimeException("Поле должно содержать один символ m или f!");
            }
            if (gen.equals(f) || gen.equals(m)) {
                gender = gen.charAt(0);
            } else {
                throw new RuntimeException("Вы ввели не тот символ!");
            }
            break;
        } while (true);
    }

    // Вывод введенных данных
    private void OutputData() {
        System.out.println("\nИмя \t- \t" + firstName + "\n" +
                "Фамилия \t- \t" + lastName + "\n" +
                "Отчество \t- \t" + patronymic + "\n" +
                "Дата рождения \t- \t" + birthday + "\n" +
                "Телефон \t- \t" + phone + "\n" +
                "Пол   \t- \t" + gender);
    }

    // Ввод пользовательских данных
    private void Input() {
        InputFirstName();
        InputLastName();
        InputPatronymic();
        InputBirthday();
        InputPhone();
        InputGender();
        OutputData();
    }

    // Сохраняем данные в файл
    public void SaveInputData() {

        Input();
        String file = lastName + ".txt";
        try (FileWriter f = new FileWriter(file, true)) {
            f.write("<" + firstName + "> " +
                    "<" + lastName + "> " +
                    "<" + patronymic + "> " +
                    "<" + birthday + "> " +
                    "<" + phone + "> " +
                    "<" + gender + ">\n");
            f.close();
        } catch (Exception e) {
            System.out.println("Не удалось сохранить данные в файл!");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public long getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }
}
