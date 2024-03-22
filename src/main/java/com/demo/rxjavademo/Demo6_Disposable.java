package com.demo.rxjavademo;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Demo6_Disposable {

    public static void main(String[] args) {

        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(System.out::println);

        if (disposable.isDisposed()) {
            disposable.dispose();
        }

    }
}