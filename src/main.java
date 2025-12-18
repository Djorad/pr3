import java.io.*;

public class main {
    public static void main(String[] args) {
        System.out.println("=== Задание 3: Методы ===");

        // Очищаем лог-файл перед записью
        try {
            new PrintWriter("update_log.txt").close();
            System.out.println("Файл update_log.txt очищен");
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось очистить файл: " + e.getMessage());
        }

        // Создание объекта Student
        System.out.println("\nСоздание объекта Student:");
        Student student = new Student("Ольга Николаева", 3001);

        // Вызов метода printInfo()
        System.out.println("\nВызов метода printInfo():");
        student.printInfo();

        // Вызов метода updateName()
        System.out.println("\nИзменение имени студента:");
        student.updateName("Ольга Смирнова");

        // Проверка изменений
        System.out.println("\nПроверка изменений:");
        student.printInfo();

        // Еще одно изменение для демонстрации логгирования
        System.out.println("\nЕще одно изменение имени:");
        student.updateName("Ольга Петрова-Смирнова");

        System.out.println("\nФинальная информация о студенте:");
        student.printInfo();

        System.out.println("\nВсе изменения записаны в файл update_log.txt");
        System.out.println("Проверьте содержимое файла.");
    }
}