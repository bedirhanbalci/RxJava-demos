package com.demo.rxjavademo;


import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class Demo4_SingleVsMaybe {

    public static void main(String[] args) {

        Single<String> single = Single.just("Hello World");
        single.subscribe(System.out::println);

        Maybe<String> maybe = Maybe.fromSingle(single);
        maybe.subscribe(
                data -> System.out.println("Received data: " + data),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Completed")
        );
    }

    public static String getById(int id) {
        if (id % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }
}
