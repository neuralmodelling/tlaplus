package pcal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import tlc2.tool.CommonTestCase;
import util.ToolIO;

public class CallGotoUnlabeledTest {
	
	// https://groups.google.com/forum/#!topic/tlaplus/6M1oFOtN-5k/discussion
	
	@Test
	public void test() {
		// Make tool capture the output written to ToolIO.out. Otherwise,
		// ToolIO#getAllMessages returns an empty array.
		ToolIO.setMode(ToolIO.TOOL);

		final String fileName = "CallGotoUnlabeledTest.tla";
		
		final TLAtoPCalMapping mapping = trans.runMe(new String[] {"-nocfg", "-unixEOL", "-reportLabels", CommonTestCase.BASE_PATH + fileName});
		assertNotNull(mapping);
		
		final String[] messages = ToolIO.getAllMessages();
		assertTrue(Arrays.toString(messages), messages.length == 3);
		
		assertEquals("Parsing completed.", messages[0]);
		assertEquals("Translation completed.", messages[1]);
		assertEquals("New file test-model/" + fileName + " written.", messages[2]);
	}
}
