package com.github.nclsbayona.hexarchitecturedemo.adapters.output.grpc.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.nclsbayona.common.entities.Person;
import com.github.nclsbayona.hexarchitecturedemo.adapters.output.grpc.client.services.GrpcPersonClientService;

@RestController
public class ClientRestController {
    
    @Autowired
    private GrpcPersonClientService grpcClientService;

    @RequestMapping("/{id}")
    public Person printMessage(@PathVariable(required = true) String id) {
        return this.grpcClientService.salute(Integer.valueOf(id));
    }

}
