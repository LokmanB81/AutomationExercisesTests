package TestExercises;

import com.github.javafaker.Faker;

public class FakerExample {
    public static void main(String[] args) {

        Faker fake=new Faker();

        for (int i = 0; i < 5; i++) {
            System.out.println(fake.name());
            System.out.println(fake.address().fullAddress());
            System.out.println(fake.name().fullName());
            System.out.println(fake.name().firstName());
            System.out.println(fake.name().lastName());
            System.out.println(fake.name().prefix());
            System.out.println(fake.internet().password());
            System.out.println(fake.date().birthday());
            System.out.println(fake.internet().emailAddress());
            System.out.println();

        }
    }
}
