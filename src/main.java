import java.io.*;

public class main {
    public static void main(String[] args) {
        System.out.println("=== Задание 4: Параметры методов ===");

        // Очищаем файл курсов перед записью
        try {
            new PrintWriter("courses.txt").close();
            System.out.println("Файл courses.txt очищен");
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось очистить файл: " + e.getMessage());
        }

        // Создание объекта Student
        System.out.println("\nСоздание студента:");
        Student student = new Student("Андрей Козлов", 4001);

        // Добавление курсов с помощью метода addCourse()
        System.out.println("\nДобавление курсов через addCourse():");
        student.addCourse("Java Programming");
        student.addCourse("Database Systems");
        student.addCourse("Algorithms and Data Structures");

        // Вывод списка курсов
        System.out.println("\nВызов listCourses() для отображения курсов:");
        student.listCourses();

        // Добавление курсов через переменное число аргументов
        System.out.println("\nДобавление курсов через listCourses() с параметрами:");
        student.listCourses("Web Development", "Software Engineering", "Computer Networks");

        // Еще один вызов для проверки накопленных курсов
        System.out.println("\nИтоговый список курсов:");
        student.listCourses();

        // Вывод полной информации о студенте
        System.out.println("\nПолная информация о студенте:");
        student.printInfo();

        System.out.println("\nВсе данные о курсах сохранены в файл courses.txt");
        System.out.println("Проверьте содержимое файла.");
    }
}