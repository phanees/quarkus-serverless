package org.acme;

import java.util.Optional;

import org.acme.domain.Input;
import org.acme.domain.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.funqy.Context;
import io.quarkus.funqy.Funq;
import io.quarkus.funqy.knative.events.CloudEvent;

public class ToLowerCaseFunction {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToLowerCaseFunction.class);

    @Funq("lowercase")
    public Output lowerCaseFunction(Input input, @Context CloudEvent<Input> cloudEvent) {
		LOGGER.info("Input: {}", input);

        String inputStr = input.getInput();
        String outputStr = Optional.ofNullable(inputStr).map(String::toLowerCase).orElse("NO DATA");
        LOGGER.info("Output CE: {}", outputStr);
        return new Output(inputStr, cloudEvent.subject(), outputStr, null);
    }
}
