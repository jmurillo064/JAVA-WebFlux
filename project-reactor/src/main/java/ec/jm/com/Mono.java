package ec.jm.com;

import org.reactivestreams.Subscriber;

/**
 * Hello world!
 *
 */
public class Mono {

    public static void main(String[] args) {
        String fuenteDeDatos = "Hola mundo";
        reactor.core.publisher.Mono<String> mono = reactor.core.publisher.Mono.just(fuenteDeDatos); //Crear un publicador
        Subscriber<String> stringSubscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(org.reactivestreams.Subscription s) {
                System.out.println("Suscrito al publicador");
                s.request(1); // Solicitar un elemento
            }

            @Override
            public void onNext(String s) {
                System.out.println("Por aquí pasó >>> " + s);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Acabó el flujo de datos");
            }
        };
        mono.subscribe(stringSubscriber);
    }

}
