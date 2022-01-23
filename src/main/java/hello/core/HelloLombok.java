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
       helloLombok.setName("hello lombok");
       helloLombok.setAge(10);

       String name_ = helloLombok.getName();
       int age_ = helloLombok.getAge();
       System.out.println("name = "+name_+" age = "+age_);
        System.out.println(helloLombok);

    }
}
