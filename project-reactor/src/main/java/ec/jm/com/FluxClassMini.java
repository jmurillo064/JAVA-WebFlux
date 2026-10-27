package ec.jm.com;

import reactor.core.publisher.Flux;

public class FluxClassMini {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);

        flux.subscribe(
                n -> System.out.println("on netx -> " + n), // onNetxt
                error -> System.out.println("Ocurió un error"), // onError
                () -> System.out.println("Flujo completado")
        );
    }

}
