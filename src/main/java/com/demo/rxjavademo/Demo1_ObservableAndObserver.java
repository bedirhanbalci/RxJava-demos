package com.demo.rxjavademo;

import io.reactivex.rxjava3.core.Observable;

import java.util.Random;

public class Demo1_ObservableAndObserver {

    public static void main(String[] args) {

        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onNext("World!");
            emitter.onNext("Java \uFE0F Spring");

            String stringInObservable = "Hello";
            System.out.println(stringInObservable);

            Random rnd = new Random();
            int r = rnd.nextInt(0, 10);
            if (r % 2 == 0) {
                emitter.onError(new Exception("Error"));
            }
            emitter.onComplete();
        });

        observable.subscribe(System.out::println,
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Completed"));

    }
}
