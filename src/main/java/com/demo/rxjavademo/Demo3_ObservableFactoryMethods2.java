package com.demo.rxjavademo;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Demo3_ObservableFactoryMethods2 {

    public static void main(String[] args) {

        Observable<Integer> observable = Observable.range(1, 10);
//        observable.subscribe(System.out::println);

        Observable<Long> observable1 = Observable.interval(1, TimeUnit.SECONDS)
                .take(5);
//        observable1.subscribe(System.out::println);

        Observable<Long> observable2 = Observable.timer(5, TimeUnit.SECONDS);
//        observable1.subscribe(System.out::println);

        Action action = () -> {
            LocalTime time = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(
                    ZoneId.systemDefault()).toLocalTime();
            System.out.println(time);
        };

        Completable completable = Completable.fromAction(action);//.delay(2, TimeUnit.SECONDS);
        completable.subscribe(System.out::println);

//        new Scanner(System.in).next();

    }

}
