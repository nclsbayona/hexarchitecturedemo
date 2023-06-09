package com.github.nclsbayona.hexarchitecturedemo.application.usecase;

import org.springframework.beans.factory.annotation.Qualifier;

import com.github.nclsbayona.common.annotations.UseCase;
import com.github.nclsbayona.common.entities.Person;
import com.github.nclsbayona.hexarchitecturedemo.application.port.in.WelcomeInputPort;
import com.github.nclsbayona.hexarchitecturedemo.application.port.out.WelcomeOutputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
public class WelcomeUseCase implements WelcomeInputPort {

    private WelcomeOutputPort welcomeOutputPort;

    @Override
    public Person salute(Integer id){
        log.debug("Into salute on Application Domain");
        return welcomeOutputPort.retornarPersona(id);
    }

    @Override
    public void setOutput(WelcomeOutputPort outputPort) {
        log.debug("Into set output on Application Domain");
        this.welcomeOutputPort = outputPort;
    } 

    public WelcomeUseCase(@Qualifier("grpcOutputPort") WelcomeOutputPort outputPort){
        this.welcomeOutputPort = outputPort;
    }
    
}
