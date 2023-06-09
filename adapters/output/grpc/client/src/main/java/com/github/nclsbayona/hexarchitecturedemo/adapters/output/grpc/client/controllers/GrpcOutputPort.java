package com.github.nclsbayona.hexarchitecturedemo.adapters.output.grpc.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.nclsbayona.common.annotations.Adapter;
import com.github.nclsbayona.common.entities.Person;
import com.github.nclsbayona.hexarchitecturedemo.adapters.output.grpc.client.services.GrpcPersonClientService;
import com.github.nclsbayona.hexarchitecturedemo.application.port.out.WelcomeOutputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Adapter("gRPCOutputAdapter")
public class GrpcOutputPort implements WelcomeOutputPort{

    @Autowired
    private GrpcPersonClientService grpcClientService;

    @Override
    public Person retornarPersona(Integer id) {
        log.info("Salute on gRPC output adapter");
        return grpcClientService.salute(id);
    }
    
}
