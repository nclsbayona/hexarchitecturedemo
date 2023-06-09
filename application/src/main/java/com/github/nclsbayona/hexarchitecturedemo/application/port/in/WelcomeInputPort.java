package com.github.nclsbayona.hexarchitecturedemo.application.port.in;

import com.github.nclsbayona.common.annotations.Port;
import com.github.nclsbayona.common.entities.Person;
import com.github.nclsbayona.hexarchitecturedemo.application.port.out.WelcomeOutputPort;

@Port
public interface WelcomeInputPort {
    public void setOutput(WelcomeOutputPort outputPort);
    
    public Person salute(Integer id);
}
