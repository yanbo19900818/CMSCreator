package test.yanbo.cmscreator.db;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.yanbo.cmscreator.db.DatabaseConnecter;

public class DatabaseConnecterTest {
	private static DatabaseConnecter databaseConnecter = new DatabaseConnecter();

	@Test
	public void testGetConnection() {
		assertNotNull(databaseConnecter.getConnection());
	}

	@Test
	public void testCreateTableInfo() {
		assertNotNull(databaseConnecter.createTableInfo());
	}

}
