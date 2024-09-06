import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankTest {
    @Test
    public void tests(){
        Bank account = new Bank("Jack", 10);
        assertEquals("Jack", account.getName());
        account.withdraw(5);
        assertEquals(5, account.getBalance(), 0.0000001);
        account.add(10);
        assertEquals(15,account.getBalance(),0.000001);

    }
}
