import accounts.DebitAccount;
import accounts.DepositAccount;
import banks.Bank;
import banks.CentralBank;
import clients.Client;
import org.junit.jupiter.api.Test;
import transactions.AddMoney;
import transactions.Transaction;
import transactions.Transfer;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BanksTests {
    @Test
    public void OpenDepositAccount_PutMoneyToAccount() {
        CentralBank centralBank = new CentralBank("Central1");
        Bank bank = centralBank.createBank("Bank of Gena Tsidarmyan", 5, 800000, 10);
        Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
        Client client1 = clientBuilder.build();
        bank.addClient(client1);
        DepositAccount depositAccount = bank.openDepositAccount(client1, 15000, bank, 50);
        Transaction addMoney = new AddMoney(depositAccount, 10000);
        addMoney.execute();
        assertEquals(25000, depositAccount.getBalance());
    }
    @Test
    public void OpenDebitAccount_TransferMoney()
    {
        CentralBank centralBank = new CentralBank("Central");
        Bank bank1 = centralBank.createBank("Redan Bank",5, 800000, 10);
        Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
        var client1 = clientBuilder.build();
        bank1.addClient(client1);
        DebitAccount debitAccount1 = bank1.openDebitAccount(client1, 88888, bank1);
        Bank bank2 = centralBank.createBank("Offnik Bank", 10, 5000000, 10);
        Client.ClientBuilder clientBuilder2 = new Client.ClientBuilder();
        var client2 = clientBuilder2.build();
        bank1.addClient(client2);
        DebitAccount debitAccount2 = bank2.openDebitAccount(client2, 55000, bank2);
        var transferTransaction = new Transfer(debitAccount1, debitAccount2, 5000);
        transferTransaction.execute();
        assertEquals(60000, debitAccount2.getBalance());
    }
    @Test
    public void OpenDebitAccount_CanselTransaction()
    {
        CentralBank centralBank = new CentralBank("Central");
        Bank bank = centralBank.createBank("Cash Cow Credit Union", 5, 800000, 10);
        Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
        var client = clientBuilder.build();
        bank.addClient(client);
        DebitAccount debitAccount1 = bank.openDebitAccount(client, 88888, bank);
        var addMoneyTransaction = new AddMoney(debitAccount1, 8888);
        addMoneyTransaction.execute();
        addMoneyTransaction.cancel();
        assertEquals(88888, debitAccount1.getBalance());
    }
}
