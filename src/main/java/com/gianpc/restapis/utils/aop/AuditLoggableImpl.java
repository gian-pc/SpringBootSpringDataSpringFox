package com.gianpc.restapis.utils.aop;

import com.gianpc.restapis.domains.Todo;
import com.gianpc.restapis.domains.TodoType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditLoggableImpl implements AuditLoggable {

    private final Logger logger = LoggerFactory.getLogger(AuditLoggableImpl.class);

    @Override
    public void auditLog(Object o, String eventName) {
        String auditMsg = "";

        if(eventName.equals("INSERT")){
            auditMsg += "Inserting ";
        } else if (eventName.equals("UPDATE")){
            auditMsg += "Updating ";
        }

        if (o instanceof Todo){
            auditMsg += "Todo";
        } else if (o instanceof TodoType) {
            auditMsg += "TodoType";
        }
        logger.info(auditMsg);
    }
}
