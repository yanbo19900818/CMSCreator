package test.yanbo.cmscreater.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yanbo.cmscreater.util.PropertiesManager;

public class PropertiesManagerTest {

	@Test
	public void testGetValue() {
		String ip = PropertiesManager.getValue("ip");
		assertNotNull(ip);
	}

}
