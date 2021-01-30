package Lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class MainSoket {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person ivan = new Person("Ivan", 30);
        String person = mapper.writeValueAsString(ivan);

        System.out.println("---request html---");
        SoketBuilder.builder()
                .soket("localhost", 8080)
                .request("/hello")
                .build();

        System.out.println("---request post---");
        SoketBuilder.builder()
                .soket("localhost", 8080)
                .request("/post", person)
                .contentType(SoketBuilder.Type.JSON)
                .build();

        System.out.println("---request get with parametrs---");
        SoketBuilder.builder()
                .soket("localhost",8080)
                .request("/names")
                .addRequestParam("name","Sergey")
                .addRequestParam("age","22")
                .build();
    }
}
