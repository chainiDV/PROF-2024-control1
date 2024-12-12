package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() {
        Customer customer = new Customer();

        //Verifico que tira la excepción
        assertThrows(NoAccountsException.class, () -> customer.getAccountWithHighestBalance());
    }

    @Test
    public void testGetAccountWithHighestBalanceWithAccounts() throws NoAccountsException {

        final float LOWEST_TRANSACTION  = 100.0f;
        final float MIDDLE_TRANSACTION  = 200.0f;
        final float HIGHEST_TRANSACTION = 300.0f;

        final String ACCOUNT_NAME_1 = "Account 1";
        final String ACCOUNT_NAME_2 = "Account 2";
        final String ACCOUNT_NAME_3 = "Account 3";

        final String TRANSACTION_NAME_1 = "Transaction 1";
        final String TRANSACTION_NAME_2 = "Transaction 2";
        final String TRANSACTION_NAME_3 = "Transaction 3";

        Customer customer = new Customer();

        Account account1 = new Account();
        account1.setAccountNumber(ACCOUNT_NAME_1);

        Account account2 = new Account();
        account2.setAccountNumber(ACCOUNT_NAME_2);

        Account account3 = new Account();
        account3.setAccountNumber(ACCOUNT_NAME_3);

        Transaction transaction1 = new Transaction();
        transaction1.concept = TRANSACTION_NAME_1;
        transaction1.amount = LOWEST_TRANSACTION;

        Transaction transaction2 = new Transaction();
        transaction2.concept = TRANSACTION_NAME_2;
        transaction2.amount = MIDDLE_TRANSACTION;

        Transaction transaction3 = new Transaction();
        transaction3.concept = TRANSACTION_NAME_3;
        transaction3.amount = HIGHEST_TRANSACTION;

        account1.addTransaction(transaction1);
        account2.addTransaction(transaction2);
        account3.addTransaction(transaction3);

        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);

        String accountWithHighestBalance = customer.getAccountWithHighestBalance();

        //Verifico que devuelve el número de cuenta con el saldo más alto
        assertEquals(account3.getAccountNumber(), accountWithHighestBalance);
    }

    public void testGetAccountWithHighestBalanceWithAccountsUsingMocking() throws NoAccountsException {

        final float LOWEST_TRANSACTION  = 100.0f;
        final float MIDDLE_TRANSACTION  = 200.0f;
        final float HIGHEST_TRANSACTION = 300.0f;

        final String ACCOUNT_NAME_1 = "Account 1";
        final String ACCOUNT_NAME_2 = "Account 2";
        final String ACCOUNT_NAME_3 = "Account 3";

        Customer customer = new Customer();

        Account account1 = mock(Account.class);
        when(account1.getAccountNumber()).thenReturn(ACCOUNT_NAME_1);
        when(account1.getCurrentBalance()).thenReturn(LOWEST_TRANSACTION);

        Account account2 = mock(Account.class);
        when(account2.getAccountNumber()).thenReturn(ACCOUNT_NAME_2);
        when(account2.getCurrentBalance()).thenReturn(MIDDLE_TRANSACTION);

        Account account3 = mock(Account.class);
        when(account3.getAccountNumber()).thenReturn(ACCOUNT_NAME_3);
        when(account3.getCurrentBalance()).thenReturn(HIGHEST_TRANSACTION);

        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);

        String accountWithHighestBalance = customer.getAccountWithHighestBalance();

        //Verifico que devuelve el número de cuenta con el saldo más alto
        assertEquals(account3.getAccountNumber(), accountWithHighestBalance);
    }
}
