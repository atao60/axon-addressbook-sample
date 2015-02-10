/*
 * Copyright (c) 2010. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.examples.addressbook.web.impl;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.examples.addressbook.web.CommandReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

/**
 * <p>Implementation of the CommandReceiver interface to be used as an endpoint for flex clients</p>
 *
 * @author Jettro Coenradie
 */
@Service("commandReceiver")
@RemotingDestination(channels = {"my-amf"})
public class CommandReceiverImpl implements CommandReceiver {

    private final static Logger logger = LoggerFactory.getLogger(CommandReceiverImpl.class);
    private CommandBus commandBus;

    @Autowired
    public CommandReceiverImpl(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @RemotingInclude
    @Override
    public Object sendCommand(Object command) {
        logger.debug("Received a command of type : {}", command.getClass().getSimpleName());
        FutureCallback<Object> callback = new FutureCallback<>();
        commandBus.dispatch(new GenericCommandMessage<Object>(command), callback);
        try {
            return callback.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
