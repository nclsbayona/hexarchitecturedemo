package com.github.nclsbayona.hexarchitecturedemo.application.port.out;

import com.github.nclsbayona.common.annotations.Port;
import com.github.nclsbayona.common.entities.Person;

@Port
public interface WelcomeOutputPort {
	public Person retornarPersona(Integer id);
}
