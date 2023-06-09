package com.github.nclsbayona.hexarchitecturedemo.adapters.output.grpc.server.services;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import messages.PersonRequest;
import messages.PersonResponse;
import net.devh.boot.grpc.server.service.GrpcService;
import services.person.PersonServiceGrpc.PersonServiceImplBase;

@Slf4j
@GrpcService
public class GrpcPersonService extends PersonServiceImplBase {

    public void salute(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        log.info("In GRPC salute method");
        String[] firstNames = { "Juan", "Carlos", "Lucas", "Camilo" };
        String[] lastNames = { "Gomez", "Casas", "Ceron", "Cardenas" };
        try {
            String firstName = firstNames[request.getId() - 1];
            String lastName = lastNames[request.getId() - 1];
            PersonResponse response = PersonResponse.newBuilder().setFirstName(firstName).setLastName(lastName)
                    .setAge(20).setEmail(firstName.toLowerCase() + '@' + lastName.toLowerCase() + ".io")
                    .setPhone("7779998880").build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            log.warn("OK");
        } catch (Exception e) {
            log.error(e.getMessage());
            String firstName = "The person with ID (" + request.getId() + ") does not exist!";
            String lastName = "";
            PersonResponse response = PersonResponse.newBuilder().setFirstName(firstName).setLastName(lastName)
                    .setAge(-1).setEmail(firstName.toLowerCase() + '@' + lastName.toLowerCase() + ".io")
                    .setPhone("0").build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            log.info("Done GRPC salute method");
        }

    }
}
