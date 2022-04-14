package imperative;


import java.util.ArrayList;
import java.util.List;

import static imperative.Main.Gender.*;

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
        people.stream()
                .filter(person -> person.gender.equals(FEMALE))
                .forEach(System.out::println);
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



    enum Gender{
        MALE, FEMALE
    }
}
