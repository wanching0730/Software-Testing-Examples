package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.converters.Param;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FSMBankAccountTest {

    FSMBankAccount account = new FSMBankAccount(-500, 0, AccountStates.empty);

    @Test
    @Parameters({"addMoney,200,present", "withdrawMoney,100,present"})
    public void testPresentState(AccountEvents eventToDo, int amount, AccountStates expectedState) {
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
    }

    @Test
    @Parameters({"addMoney,200,overdraft", "withdrawMoney,100,overdraft"})
    public void testOverdraftState(AccountEvents eventToDo, int amount, AccountStates expectedState) {
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
    }

    @Test
    @Parameters({"addMoney,200,})
    public void testOverdrawnState(AccountEvents eventToDo, int amount, AccountStates expectedState) {
        account.processEvent(eventToDo, amount);
        assertEquals(expectedState, account.getCurrentState());
    }
}
