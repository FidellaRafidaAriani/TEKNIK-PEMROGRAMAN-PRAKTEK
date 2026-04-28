/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.p2p.domain;

/**
 *
 * @author FIDELLA
 */
import java.math.BigDecimal;

public class Loan {

    public enum Status {
        APPROVED,
        REJECTED
    }

    private Status status;
    private BigDecimal amount;

    public Loan(BigDecimal amount) {
        this.amount = amount;
    }

    public void approve() {
        this.status = Status.APPROVED;
    }

    public void reject() {
        this.status = Status.REJECTED;
    }

    public Status getStatus() {
        return status;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}