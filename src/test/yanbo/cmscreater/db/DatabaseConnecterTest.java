package test.yanbo.cmscreater.db;

import org.junit.Test;
import static org.junit.Assert.*;
import com.yanbo.cmscreater.db.DatabaseConnecter;

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
