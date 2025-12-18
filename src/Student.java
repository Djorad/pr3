import java.io.*;

public class Student {
    // Поля класса
    String name;
    int studentId;

    // Конструктор по умолчанию
    public Student() {
        this.name = "Неизвестный студент";
        this.studentId = 0;
    }

    // Параметризованный конструктор
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    // Метод для вывода информации о студенте
    public void printInfo() {
        System.out.println("=== Информация о студенте ===");
        System.out.println("Имя: " + name);
        System.out.println("ID: " + studentId);
        System.out.println("=============================");
    }

    // Метод для изменения имени студента
    public void updateName(String newName) {
        String oldName = this.name;
        this.name = newName;

        // Логирование изменения в файл
        try (PrintWriter writer = new PrintWriter(new FileWriter("update_log.txt", true))) {
            writer.println("[" + new java.util.Date() + "]");
            writer.println("Старое имя: " + oldName);
            writer.println("Новое имя: " + newName);
            writer.println("ID студента: " + studentId);
            writer.println("-------------------------");

            System.out.println("Имя успешно изменено с '" + oldName + "' на '" + newName + "'");
            System.out.println("Изменение записано в update_log.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в лог: " + e.getMessage());
        }
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