package com.demo.rxjavademo;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Demo2_ObservableFactoryMethods {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Observable<String> observable = Observable.just("Hello", "World!", "Java \uFE0F Spring");

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };


//        observable.subscribe(observer);

//        observableFromExample();

        futureExample();

    }

    public static void observableFromExample() {

        List<String> list = Arrays.asList("Hello", "World!", "Java \uFE0F Spring");
        Observable<String> observable = Observable.fromIterable(list);

        observable.subscribe(System.out::println);
    }

    public static void futureExample() {

        Future<List<String>> future = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .map(i ->
                        "value " + i)
                .doOnSubscribe(s -> {
                    LocalTime time = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(
                            ZoneId.systemDefault()).toLocalTime();
                    System.out.println("Subscribed " + time);
                })
                .doOnComplete(() -> {
                    LocalTime time = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(
                            ZoneId.systemDefault()).toLocalTime();
                    System.out.println("Completed " + time);
                })
                .doOnNext(i -> {
                    LocalTime time = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(
                            ZoneId.systemDefault()).toLocalTime();
                    System.out.println("Next " + time + " " + i);
                })
                .toList()
                .toFuture();

        while (!future.isDone()) {
            try {
                Thread.sleep(1000);
                System.out.println(future.state());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(future.state());
        System.out.println(future.resultNow());
    }

}
