package com.github.nclsbayona.hexarchitecturedemo.adapters.output.plain;

import com.github.nclsbayona.common.annotations.Adapter;
import com.github.nclsbayona.common.entities.Person;
import com.github.nclsbayona.hexarchitecturedemo.application.port.out.WelcomeOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Adapter("plainOutputAdapter")
public class MyService implements WelcomeOutputPort{
    @Override
    public Person retornarPersona(Integer id) {
        log.info("En retornarPersona");
        Person person = null;
        try {
            person = new Person("First".repeat(id), "Last".repeat(id), "First@last.io",
                    "31332561752", String.valueOf(id));
        } catch (Exception e) {
        }
        return person;
    }
}
