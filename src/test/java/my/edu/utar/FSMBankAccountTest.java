package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FSMBankAccountTest {

    @Test
    @Parameters({"addMoney,200,200,present", "withdrawMoney,200,100,present"})
    public void testPresentState(AccountEvents eventToDo, int currentBalance, int amount, AccountStates expectedState) {
        FSMBankAccount account = new FSMBankAccount(-500, currentBalance, AccountStates.present);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
    }

    @Test
    @Parameters({"addMoney,-500,100,overdrawn", "addMoney,-500,600,present", "withdrawMoney,-500,100,overdraft"})
    public void testOverdraftState(AccountEvents eventToDo, int currentBalance, int amount, AccountStates expectedState) {
        FSMBankAccount account = new FSMBankAccount(-500, currentBalance, AccountStates.overdraft);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
    }

    @Test
    @Parameters({"addMoney,-100,300,present", "addMoney,-200,200,empty", "addMoney,-200,100,overdrawn",
            "withdrawMoney,-300,200,overdraft", "withdrawMoney,-100,100,overdrawn"})
    public void testOverdrawnState(AccountEvents eventToDo, int currentBalance, int amount, AccountStates expectedState) {
        FSMBankAccount account = new FSMBankAccount(-500, currentBalance, AccountStates.overdrawn);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
    }

    @Test
    @Parameters({"addMoney,0,200,present", "withdrawMoney,0,200,overdrawn"})
    public void testEmptyState(AccountEvents eventToDo, int currentBalance, int amount, AccountStates expectedState) {
        FSMBankAccount account = new FSMBankAccount(-500, currentBalance, AccountStates.empty);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
    }

    @Test
    @Parameters({"addMoney,200,200,present", "withdrawMoney,200,100,present",
            "addMoney,-500,100,overdrawn", "addMoney,-500,600,present", "withdrawMoney,-500,100,overdraft", "addMoney,-100,300,present", "addMoney,-200,200,empty", "addMoney,-200,100,overdrawn",
            "withdrawMoney,-300,200,overdraft", "withdrawMoney,-100,100,overdrawn", "addMoney,0,200,present", "withdrawMoney,0,200,overdrawn"})
    public void testAllStates(AccountEvents eventToDo, int currentBalance, int amount, AccountStates expectedState) {
        FSMBankAccount account = new FSMBankAccount(-500, currentBalance, expectedState);
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({"withdrawMoney,0,500"})
    public void testEmptyStateIllegalArgument(AccountEvents eventToDo, int currentBalance, int amount) {
        FSMBankAccount account = new FSMBankAccount(-500,currentBalance,AccountStates.empty);
        account.processEvent(eventToDo,amount);
    }
}
