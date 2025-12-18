import java.io.*;

public class Student {
    // Поля класса
    String name;
    int studentId;

    // Конструктор по умолчанию
    public Student() {
        this.name = "Неизвестный студент";
        this.studentId = 0;
        System.out.println("Создан студент с помощью конструктора по умолчанию");
    }

    // Параметризованный конструктор
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        System.out.println("Создан студент: " + name + " (ID: " + studentId + ")");
    }

    // Метод для записи информации о студенте в файл
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("Студент: " + name);
            writer.println("ID: " + studentId);
            writer.println("-------------------------");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    // Метод для получения информации о студенте
    public String getInfo() {
        return "Студент: " + name + ", ID: " + studentId;
    }
}