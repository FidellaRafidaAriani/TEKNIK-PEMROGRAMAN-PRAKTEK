package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceTest {

    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        Borrower borrower = new Borrower(false, 700);
        LoanService service = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.createLoan(borrower, BigDecimal.valueOf(1000));
        });
    }

    //TAMBAHAN TC-02
    @Test
    void shouldRejectLoanWhenAmountInvalid() {
        Borrower borrower = new Borrower(true, 700);
        LoanService service = new LoanService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.createLoan(borrower, BigDecimal.ZERO);
        });
    }

    //TAMBAHAN TC-03
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        Borrower borrower = new Borrower(true, 700);
        LoanService service = new LoanService();

        Loan loan = service.createLoan(borrower, BigDecimal.valueOf(1000));

        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    //TAMBAHAN TC-04
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        Borrower borrower = new Borrower(true, 500);
        LoanService service = new LoanService();

        Loan loan = service.createLoan(borrower, BigDecimal.valueOf(1000));

        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}