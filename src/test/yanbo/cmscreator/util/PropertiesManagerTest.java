package test.yanbo.cmscreator.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.yanbo.cmscreator.util.PropertiesManager;

public class PropertiesManagerTest {

	@Test
	public void testGetValue() {
		String ip = PropertiesManager.getValue("ip");
		assertNotNull(ip);
	}

}
