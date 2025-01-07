package Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    public void testContructorWithString(){
        Transaction transaction = new Transaction(1,"Test1","12/3/2024","24.99","21","This Is a Test");
        asserto
        System.out.println("Test Over");
    }

}