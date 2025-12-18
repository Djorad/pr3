import java.io.*;

public class main {
    public static void main(String[] args) {
        System.out.println("=== Задание 1: Создание классов и объектов ===");

        // Создаем файл для записи (очищаем если существует)
        try {
            new PrintWriter("students.txt").close();
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось очистить файл: " + e.getMessage());
        }

        // Создание первого объекта Student
        Student student1 = new Student();
        student1.name = "Иван Иванов";
        student1.studentId = 1001;

        // Создание второго объекта Student
        Student student2 = new Student();
        student2.name = "Мария Петрова";
        student2.studentId = 1002;

        // Вывод информации в консоль
        System.out.println("Созданы объекты Student:");
        System.out.println("1. " + student1.name + " (ID: " + student1.studentId + ")");
        System.out.println("2. " + student2.name + " (ID: " + student2.studentId + ")");

        // Сохранение информации в файл
        student1.saveToFile("students.txt");
        student2.saveToFile("students.txt");

        System.out.println("\nПроверьте файл students.txt в текущей директории.");
        System.out.println("Для разных ОС путь к файлу:");
        System.out.println("- Windows: текущая_папка\\students.txt");
        System.out.println("- Linux/Mac: текущая_папка/students.txt");

        // Проверка ОС
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("\nТекущая операционная система: " + osName);

        if (osName.contains("win")) {
            System.out.println("Вы используете Windows");
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("mac")) {
            System.out.println("Вы используете Unix-подобную систему (Linux/Mac)");
        } else {
            System.out.println("Неизвестная ОС");
        }
    }
}