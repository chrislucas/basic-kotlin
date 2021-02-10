package com.study.rx.samples;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class HelloWorld {

    private static void observableSample() {
        Disposable disposable = Observable.create(emitter -> {
            long time = System.currentTimeMillis();
            emitter.onNext(time);
            if ((time & 1) == 0) {
                String message = String.format("%d: timestamp impar", time);
                emitter.onError(new IllegalStateException(message));
            }
        }).subscribe(System.err::println, Throwable::printStackTrace);

        disposable.dispose();
    }
    public static void main(String[] args) {
        observableSample();
    }
}
