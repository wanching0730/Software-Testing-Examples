package my.edu.utar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import my.edu.utar.FSMWatch;
import my.edu.utar.WatchEvents;
import my.edu.utar.WatchStates;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FSMWatchTestSingle {
	
	@Test
	@Parameters({
		
		// tests for Time state
		"Time,Showing Time,pressSet,setHrs,Showing Set Hrs,0,0,0,0", 
		"Time,Showing Time,pressMode,Altimeter,Showing Altimeter,0,0,0,0",

		// tests for Altimeter state
		"Altimeter,Showing Altimeter,pressSet,Altimeter,Showing Altimeter,0,0,0,0", 
		"Altimeter,Showing Altimeter,pressMode,Time,Showing Time,0,0,0,0", 	
		
		// tests for Set Hrs state
		"setHrs,Showing Set Hrs,pressSet,setHrs,Showing Set Hrs,5,10,6,10", 
		"setHrs,Showing Set Hrs,pressSet,setHrs,Showing Set Hrs,23,10,0,10", 
		"setHrs,Showing Set Hrs,pressMode,setMins,Showing Set Mins,0,5,0,5", 

		// tests for Set Mins state
		"setMins,Showing Set Mins,pressSet,setMins,Showing Set Mins,5,10,5,11", 
		"setMins,Showing Set Mins,pressSet,setMins,Showing Set Mins,5,59,5,00", 
		"setMins,Showing Set Mins,pressMode,Time,Showing Time,0,5,0,5" 			
	
	}) 	
	public void testAllStates(WatchStates initialState, String initialDisplay, 
			WatchEvents eventToDo, WatchStates expectedState, String expectedDisplay,
			int currentHour, int currentMinute, int expectedHour, int expectedMinute) {
		
		FSMWatch fw = new FSMWatch(initialState, initialDisplay, currentHour, currentMinute);
		fw.processEvent(eventToDo);
		assertEquals(expectedState, fw.getCurrentWatchState());
		assertEquals(expectedDisplay, fw.getWatchDisplay());
		assertEquals(expectedHour, fw.getCurrentHrs());
		assertEquals(expectedMinute, fw.getCurrentMins());
	}	

}
