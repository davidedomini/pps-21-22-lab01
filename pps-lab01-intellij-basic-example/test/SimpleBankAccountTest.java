import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */

class SimpleBankAccountTest extends BankAccountTest {

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Override
    protected int getFee() {
        return 0;
    }
}
