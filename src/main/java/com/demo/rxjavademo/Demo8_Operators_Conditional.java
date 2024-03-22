package com.demo.rxjavademo;

import io.reactivex.rxjava3.core.Observable;

public class Demo8_Operators_Conditional {

    public static void main(String[] args) {

        // takeWhile
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .takeWhile(x -> x < 5)
                .subscribe(System.out::println);

        // skipWhile
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .skipWhile(x -> x < 5)
                .subscribe(System.out::println);

        // all
        Observable.just("Hello", "World!", "Java", "Spring")
                .all(s -> s.length() >= 3)
                .subscribe(System.out::println);

        // any
        Observable.just("Hello", "World!", "Java", "Spring")
                .any(s -> s.length() > 5)
                .subscribe(System.out::println);

        // defaultIfEmpty
        Observable.just("Hello", "World!", "Java", "Spring")
                .filter(s -> s.length() > 9)
                .defaultIfEmpty("Default")
                .subscribe(System.out::println);

        // switchIfEmpty
        Observable.just("Hello", "World!", "Java", "Spring")
                .filter(s -> s.length() > 9)
                .switchIfEmpty(Observable.just("Default", "Default1", "Default2"))
                .subscribe(System.out::println);


    }
}