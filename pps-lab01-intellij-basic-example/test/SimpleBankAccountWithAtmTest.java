import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;

public class SimpleBankAccountWithAtmTest extends BankAccountTest {

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(0, accountHolder);
    }

    @Override
    protected int getFee() {
        return 1;
    }
}
