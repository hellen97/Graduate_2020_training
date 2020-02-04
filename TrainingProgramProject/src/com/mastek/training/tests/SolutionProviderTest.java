package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mastek.training.basics.SolutionProvider;

class SolutionProviderTest {

		@Test
		void testGetMaxNumberValid() {
			//assert<Condition>(<Expected-Result>, <call the function for actual Result>.
			// 		<Message to display if expected result does not match actual result>);
		assertEquals(10,SolutionProvider.getMaxNumber(10,2),"invalid max number returned ");
		}

		@Test
		void testGetMaxNumberEqual() {
		
		assertEquals(9,SolutionProvider.getMaxNumber(9,9), " invalid Max Number returned");
		}

		@Test
		void testGetMaxNumberNegativeValueParams() {
			
		assertEquals(9,SolutionProvider.getMaxNumber(110,10), " invalid Max Number returned");
		}	
		@Test
		void testGetMaxNumberMaxLimitsForIntParams() {
			
	  assertEquals(9,SolutionProvider.getMaxNumber(11,1), " invalid Max Number returned");
		}
}

