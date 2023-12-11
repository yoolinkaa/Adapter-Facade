import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.adapter.task3.Authorization;
import ua.edu.ucu.apps.adapter.task3.Database;
import ua.edu.ucu.apps.adapter.task3.ReportBuilder;

public class TestTask3 {
    @Test
    public void testMain() {
        Database db = new Database();
        Authorization authorization = new Authorization();
        if (authorization.authorize(db)) {
            ReportBuilder br = new ReportBuilder(db);
        }
    }

    @Test
    public void testDb() {
        Database db = new Database();
        Assertions.assertEquals("hello", db.getUserData());
        Assertions.assertEquals("hello2", db.getStaticData());
    }
}
