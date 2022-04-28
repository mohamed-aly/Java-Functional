package ai.amigos;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static ai.amigos.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("ahmed", MALE),
                new Person("maha", FEMALE),
                new Person("soha", FEMALE),
                new Person("rabha", FEMALE),
                new Person("mohamed", MALE)
        );

        //imperative programming
        List<Person> females = new ArrayList<>();

        for(Person person : people){
            if(person.gender.equals(FEMALE)){
                females.add(person);
            }
        }

        for(Person female : females){
            System.out.println(female);
        }

        //declarative programming

        //predicate is boolean-valued function with one argument
        Predicate<Person> personPredicate = person -> person.gender.equals(FEMALE);

        people.stream()
                .filter(personPredicate)
                .forEach(System.out::println);
    }

    enum Gender{
        MALE, FEMALE
    }

    static class Person{
        private String name;
        private Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

}


