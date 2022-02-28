package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractBankAccount {

    public SimpleBankAccountWithAtm(int balance, AccountHolder accountHolder) {
      super(balance, accountHolder, ()->1);
    }

}
