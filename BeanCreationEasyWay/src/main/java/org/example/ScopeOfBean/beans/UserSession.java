package org.example.ScopeOfBean.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class UserSession {
    private String sessionId;
    public UserSession() {
        this.sessionId = UUID.randomUUID().toString();
        System.out.println("User Session bean created");
    }

    public String getSessionId() {
        return sessionId;
    }
}
