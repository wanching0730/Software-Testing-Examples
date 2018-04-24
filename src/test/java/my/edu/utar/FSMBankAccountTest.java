package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FSMBankAccountTest {

    @Test
    @Parameters({"addMoney,200,present,400", // transition 12
                "withdrawMoney,50,present,150", // transition 13
                "withdrawMoney,200,empty,0", // transition 3
                "withdrawMoney,300,overdrawn,-100", // transition 6
                "withdrawMoney,700,overdraft,-500", // transition 4
                "withdrawMoney,1000,overdraft,-500"})
    public void testPresentState(AccountEvents eventToDo, int amount, AccountStates expectedState, int expectedBalance) {
        FSMBankAccount account = new FSMBankAccount(-500, 200, AccountStates.present);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
        assertEquals(expectedBalance, account.getCurrentBalance());
    }

    @Test
    @Parameters({"addMoney,200,present,200", "withdrawMoney,200,overdrawn,-200"})
    public void testEmptyState(AccountEvents eventToDo, int amount, AccountStates expectedState, int expectedBalance) {
        FSMBankAccount account = new FSMBankAccount(-500, 0, AccountStates.empty);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
        assertEquals(expectedBalance, account.getCurrentBalance());
    }

    @Test
    @Parameters({"addMoney,100,overdrawn,-400", "addMoney,600,present,100", "withdrawMoney,100,overdraft,-500"})
    public void testOverdraftState(AccountEvents eventToDo,int amount, AccountStates expectedState, int expectedBalance) {
        FSMBankAccount account = new FSMBankAccount(-500, -500, AccountStates.overdraft);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
        assertEquals(expectedBalance, account.getCurrentBalance());
    }

    @Test
    @Parameters({"addMoney,300,present,100", "addMoney,200,empty,0",
            "withdrawMoney,500,overdraft,-500", "withdrawMoney,300,overdraft,-500",  "withdrawMoney,200,overdrawn,-400"})
    public void testOverdrawnState(AccountEvents eventToDo, int amount, AccountStates expectedState, int expectedBalance) {
        FSMBankAccount account = new FSMBankAccount(-500, -200, AccountStates.overdrawn);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
        assertEquals(expectedBalance, account.getCurrentBalance());
    }

    @Test
    @Parameters({"addMoney,200,present,200,present,400", "withdrawMoney,200,present,200,empty,0",
            "withdrawMoney,200,present,300,overdrawn,-100", "withdrawMoney,200,present,700,overdraft,-500",
            "withdrawMoney,200,present,1000,overdraft,-500",

            "addMoney,-500,overdraft,100,overdrawn,-400", "addMoney,-500,overdraft,600,present,100",
            "withdrawMoney,-500,overdraft,100,overdraft,-500",

            "addMoney,-200,overdrawn,300,present,100", "addMoney,-200,overdrawn,200,empty,0",
            "withdrawMoney,-200,overdrawn,500,overdraft,-500", "withdrawMoney,-200,overdrawn,300,overdraft,-500",
            "withdrawMoney,-200,overdrawn,200,overdrawn,-400",

            "addMoney,0,empty,200,present,200", "withdrawMoney,0,empty,200,overdrawn,-200"
    })
    public void testAllStates(AccountEvents eventToDo, int currentBalance, AccountStates currentState, int amount, AccountStates expectedState, int expectedBalance) {
        FSMBankAccount account = new FSMBankAccount(-500, currentBalance, currentState);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
        assertEquals(expectedBalance, account.getCurrentBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"withdrawMoney,0,empty,500", // transition from empty to overdraft
            "addMoney,-500,overdraft,500"}) // from overdraft to empty
    public void testIllegalStates(AccountEvents eventToDo, int currentBalance, AccountStates currentState, int amount) {
        FSMBankAccount account = new FSMBankAccount(-500,currentBalance,currentState);
        account.processEvent(eventToDo,amount);
    }
}
