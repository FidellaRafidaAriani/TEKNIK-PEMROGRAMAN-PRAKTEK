package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import java.math.BigDecimal;

public class LoanService {

    public Loan createLoan(Borrower borrower, BigDecimal amount) {

        // TC-01: borrower harus verified
        if (!borrower.isVerified()) {
            throw new IllegalArgumentException();
        }

        // TC-02: amount harus valid (> 0)
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }

        // TC-03: tentukan status loan
        Loan loan = new Loan(amount);

        if (borrower.getCreditScore() >= 600) {
            loan.approve();
        } else {
            loan.reject();
        }

        return loan;
    }
}