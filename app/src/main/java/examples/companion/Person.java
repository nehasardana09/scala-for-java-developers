package examples.companion;

public class Person {
    private String name;
    private int age;

    // Private constructor to prevent direct instantiation
    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Static factory method
    public static Person createPerson(String name, int age) {
        return new Person(name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Main {
    public static void main(String[] args) {
        Person person = Person.createPerson("Alice", 30);
        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
    }
}
