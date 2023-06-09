package com.github.nclsbayona.hexarchitecturedemo.adapters.output.grpc.client.services;

import org.springframework.stereotype.Service;

import messages.PersonRequest;
import messages.PersonResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;

import com.github.nclsbayona.common.entities.Person;

import services.person.PersonServiceGrpc.PersonServiceBlockingStub;

@Service
public class GrpcPersonClientService {
    @GrpcClient("my-grpc-server")
    private PersonServiceBlockingStub personServiceBlockingStub;

    public Person salute(int id) {
        PersonRequest personRequest = PersonRequest.newBuilder().setId(id).build();
        PersonResponse personResponse = this.personServiceBlockingStub.salute(personRequest);
        Person person = null;
        try {
            person = new Person(personResponse.getFirstName(), personResponse.getLastName(), personResponse.getEmail(),
                    personResponse.getPhone(), String.valueOf(personResponse.getAge()));
        } catch (Exception e) {
        }
        return person;
    }
}
