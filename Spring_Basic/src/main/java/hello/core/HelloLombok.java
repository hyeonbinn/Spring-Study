package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hahaha");

        String name = helloLombok.name;
        System.out.println("name = " + name);

        System.out.println("helloLombok = " + helloLombok);
    }
}
