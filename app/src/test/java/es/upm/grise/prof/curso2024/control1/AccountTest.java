package es.upm.grise.prof.curso2024.control1;

import es.upm.grise.prof.curso2024.control1.Account;
import es.upm.grise.prof.curso2024.control1.Transaction;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AccountTest {

    @Test
    public void testGetCurrentBalanceReturnsCorrectBalance() {

        final float TRANSACTION_AMOUNT_1 = 200.0f;
        final float TRANSACTION_AMOUNT_2 = -150.0f;
        final float EXPECTED_BALANCE = TRANSACTION_AMOUNT_1 + TRANSACTION_AMOUNT_2;

        Transaction transaction1 = mock(Transaction.class);
        when(transaction1.getAmount()).thenReturn(TRANSACTION_AMOUNT_1);

        Transaction transaction2 = mock(Transaction.class);
        when(transaction2.getAmount()).thenReturn(TRANSACTION_AMOUNT_2);

        Account account = new Account();
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);

        float actualBalance = account.getCurrentBalance();

        assertEquals(EXPECTED_BALANCE, actualBalance);
    }
}
