import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Student {
    // Поля класса
    String name;
    int studentId;
    List<String> courses; // Список курсов студента

    // Конструктор по умолчанию
    public Student() {
        this.name = "Неизвестный студент";
        this.studentId = 0;
        this.courses = new ArrayList<>();
    }

    // Параметризованный конструктор
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    // Метод для добавления курса
    public void addCourse(String course) {
        if (course != null && !course.trim().isEmpty()) {
            courses.add(course);
            System.out.println("Курс '" + course + "' добавлен для студента " + name);
        } else {
            System.out.println("Ошибка: название курса не может быть пустым");
        }
    }

    // Метод для вывода списка курсов (с переменным числом аргументов)
    public void listCourses(String... newCourses) {
        // Добавляем новые курсы если они переданы
        if (newCourses.length > 0) {
            System.out.println("Добавление новых курсов:");
            for (String course : newCourses) {
                addCourse(course);
            }
        }

        // Вывод всех курсов
        System.out.println("\n=== Список курсов студента " + name + " ===");
        if (courses.isEmpty()) {
            System.out.println("Студент не записан ни на один курс");
        } else {
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ". " + courses.get(i));
            }
        }
        System.out.println("Всего курсов: " + courses.size());
        System.out.println("================================");

        // Сохранение списка курсов в файл
        saveCoursesToFile("courses.txt");
    }

    // Метод для сохранения списка курсов в файл
    private void saveCoursesToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("[" + new java.util.Date() + "]");
            writer.println("Студент: " + name + " (ID: " + studentId + ")");
            writer.println("Курсы:");

            if (courses.isEmpty()) {
                writer.println("  Нет курсов");
            } else {
                for (int i = 0; i < courses.size(); i++) {
                    writer.println("  " + (i + 1) + ". " + courses.get(i));
                }
            }
            writer.println("Всего курсов: " + courses.size());
            writer.println("-------------------------");

            System.out.println("Список курсов сохранен в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи курсов в файл: " + e.getMessage());
        }
    }

    // Метод для вывода информации о студенте
    public void printInfo() {
        System.out.println("=== Информация о студенте ===");
        System.out.println("Имя: " + name);
        System.out.println("ID: " + studentId);

        if (!courses.isEmpty()) {
            System.out.println("Курсы: " + String.join(", ", courses));
        }
        System.out.println("=============================");
    }

    // Метод для изменения имени студента
    public void updateName(String newName) {
        String oldName = this.name;
        this.name = newName;

        try (PrintWriter writer = new PrintWriter(new FileWriter("update_log.txt", true))) {
            writer.println("[" + new java.util.Date() + "]");
            writer.println("Старое имя: " + oldName);
            writer.println("Новое имя: " + newName);
            writer.println("ID студента: " + studentId);
            writer.println("-------------------------");
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