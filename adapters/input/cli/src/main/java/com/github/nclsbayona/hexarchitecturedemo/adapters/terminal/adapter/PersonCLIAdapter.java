package com.github.nclsbayona.hexarchitecturedemo.adapters.terminal.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.extern.slf4j.Slf4j;

import com.github.nclsbayona.common.annotations.Adapter;
import com.github.nclsbayona.hexarchitecturedemo.application.port.in.WelcomeInputPort;
import com.github.nclsbayona.hexarchitecturedemo.application.port.out.WelcomeOutputPort;
import com.github.nclsbayona.hexarchitecturedemo.application.usecase.WelcomeUseCase;

@Slf4j
@Adapter
public class PersonCLIAdapter {
    @Autowired
    @Qualifier("plainOutputAdapter")
    private WelcomeOutputPort plainOutputAdapter;
    @Autowired
    @Qualifier("gRPCOutputAdapter")
    private WelcomeOutputPort grpcOutputAdapter;

    private WelcomeInputPort inputPort;

    public void setOutput(String option) {
        log.info("Setting output");
        if (option.equals("GRPC"))
            this.inputPort = new WelcomeUseCase(grpcOutputAdapter);
        else if (option.equals("TEST"))
            this.inputPort = new WelcomeUseCase(plainOutputAdapter);
    }

    public void printPerson(Integer id) {
        log.info("Print person");
        System.out.println(inputPort.salute(id));
    }
}