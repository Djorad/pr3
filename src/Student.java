import java.io.*;

public class Student {
    // Поля класса
    String name;
    int studentId;

    // Метод для записи информации о студенте в файл
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("Студент: " + name);
            writer.println("ID: " + studentId);
            writer.println("-------------------------");
            System.out.println("Информация о студенте сохранена в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}