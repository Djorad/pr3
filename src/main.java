import java.io.*;

public class main {
    public static void main(String[] args) {
        System.out.println("=== Задание 2: Конструкторы ===");

        // Очищаем файл перед записью
        try {
            new PrintWriter("constructors.txt").close();
            System.out.println("Файл constructors.txt очищен");
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось очистить файл: " + e.getMessage());
        }

        // Создание объектов с использованием параметризованного конструктора
        System.out.println("\nСоздание объектов с параметризованным конструктором:");
        Student student1 = new Student("Алексей Сидоров", 2001);
        Student student2 = new Student("Елена Кузнецова", 2002);
        Student student3 = new Student("Дмитрий Васильев", 2003);

        // Создание объекта с использованием конструктора по умолчанию
        System.out.println("\nСоздание объекта с конструктором по умолчанию:");
        Student student4 = new Student();

        // Вывод информации о всех студентах в консоль
        System.out.println("\nИнформация о всех студентах:");
        System.out.println("1. " + student1.getInfo());
        System.out.println("2. " + student2.getInfo());
        System.out.println("3. " + student3.getInfo());
        System.out.println("4. " + student4.getInfo());

        // Сохранение информации в файл
        System.out.println("\nСохранение информации в файл constructors.txt...");
        student1.saveToFile("constructors.txt");
        student2.saveToFile("constructors.txt");
        student3.saveToFile("constructors.txt");
        student4.saveToFile("constructors.txt");

        System.out.println("\nИнформация сохранена в файл constructors.txt");
        System.out.println("Проверьте содержимое файла.");
    }
}