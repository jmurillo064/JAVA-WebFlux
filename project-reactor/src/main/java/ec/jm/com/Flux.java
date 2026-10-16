package ec.jm.com;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Flux {

    public static void main(String[] args) {

        reactor.core.publisher.Flux<Integer> flux = reactor.core.publisher.Flux.just(1, 2, 3, 4, 5);

        Subscriber<Integer> integerSubscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("Suscrito al publicador");
                s.request(Long.MAX_VALUE); // Solicitar un elemento
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Elemento recibido: " + integer);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completado");
            }
        };

        flux.subscribe(integerSubscriber);
    }

}
