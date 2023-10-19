package com.revature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;

    public EmailDetails() {
    }

    public EmailDetails(final String recipient, final String msgBody, final String subject) {
        this.recipient = recipient;
        this.msgBody = msgBody;
        this.subject = subject;
    }

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(final String recipient) {
        this.recipient = recipient;
    }

    public String getMsgBody() {
        return this.msgBody;
    }

    public void setMsgBody(final String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }
}
