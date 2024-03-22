package com.demo.rxjavademo;

import io.reactivex.rxjava3.core.Observable;

public class Demo7_Operators_Filter {

    public static void main(String[] args) {

        // filter
        Observable.just("Hello", "World!", "Java \uFE0F Spring")
                .filter(s -> s.length() > 5)
                .subscribe(System.out::println);

        // take
        Observable.just("Hello", "World!", "Java \uFE0F Spring")
                .take(2)
                .subscribe(System.out::println);

        //skip
        Observable.just("Hello", "World!", "Java \uFE0F Spring")
                .skip(2)
                .subscribe(System.out::println);

        //distinct
        Observable.just("Hello", "World!", "Java \uFE0F Spring", "Hello", "World!", "Java \uFE0F Spring")
                .distinct()
                .subscribe(System.out::println);

        //first
        Observable.just("Hello", "World!", "Java \uFE0F Spring")
                .first("MERHABA")
                .subscribe(System.out::println);

        //last
        Observable.just("Hello", "World!", "Java \uFE0F Spring")
                .last("MERHABA")
                .subscribe(System.out::println);

    }
}