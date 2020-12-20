package Lesson1;

import Lesson1.Polymorphism.Circle;
import Lesson1.Polymorphism.Square;
import Lesson1.Polymorphism.Triangle;

public class Main1 {
    public static void main(String[] args) {
        //Задание 1
        Person person = Person.newBuilder()
                .firstName("Иван")
                .lastName("Иванов")
                .middleName("Иваныч")
                .country("Царицын")
                .address("ул. программистов 13")
                .phone("8-777-131-01-02")
                .age(13)
                .gender("Мужик")
                .build();

        //Задание 3
        Square square = new Square();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        square.draw();
        circle.draw();
        triangle.draw();
    }
}
