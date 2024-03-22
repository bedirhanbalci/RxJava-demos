package com.demo.rxjavademo;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static java.lang.Thread.sleep;

public class Demo5_Flowable {

    public static void main(String[] args) {

        Flowable<String> flowable = Flowable.just("Hello", "World!", "Java \uFE0F Spring");
//        flowable.subscribe(System.out::println);
//        syncObservableExample();
//        asyncObservableExample();

        asyncFlowableExample();

    }

    public static void syncObservableExample() {

        Observable.range(1, 1000000)
                .map(i -> new Item(i))
                .subscribe(item -> {
                    sleep(1000);
                    System.out.println("Received item: " + item);
                });
    }


    public static void asyncObservableExample() {

        Observable.range(1, 1000000)
                .map(i -> new Item(i))
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    sleep(1000);
                    System.out.println("Received item: " + item.i);
                });

        try {
            sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void asyncFlowableExample() {

        Flowable.range(1, 1000000)
                .onBackpressureBuffer()
                .map(i -> new Item(i))
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    sleep(500);
                    System.out.println("Received item: " + item.i);
                });

        try {
            sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Item {
    int i;

    public Item(int i) {
        this.i = i;
        System.out.println("Created item: " + i);
    }
}
