package org.example.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    private final Foo foo;
    private final Foo fooA;
    private final HeavyService heavyService;

    public BusinessService(
            Foo foo, // will inject @Primary (FooImplB)
            @Qualifier("fooA") Foo fooA,
            @Lazy HeavyService heavyService
    ) {
        this.foo = foo;
        this.fooA = fooA;
        this.heavyService = heavyService;
    }

    public void run() {
        System.out.println(foo.process());
        System.out.println(fooA.process());

        System.out.println("About to call heavy service...");
        heavyService.execute();
    }
}
