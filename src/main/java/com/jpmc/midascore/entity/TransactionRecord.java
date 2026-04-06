package com.jpmc.midascore.entity;

import jakarta.persistence.*;

@Entity
public class TransactionRecord {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private UserRecord senderId;
    @ManyToOne
    private UserRecord recipientId;
    private float amount;

    public TransactionRecord() {
    }

    public TransactionRecord(UserRecord senderId, UserRecord recipientId, float amount){
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.amount = amount;
    }


    public UserRecord getSenderId() {
        return senderId;
    }

    public void setSenderId(UserRecord senderId) {
        this.senderId = senderId;
    }

    public UserRecord getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(UserRecord recipientId) {
        this.recipientId = recipientId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

