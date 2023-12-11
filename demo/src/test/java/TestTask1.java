import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.singleton.DBConnection;

public class TestTask1 {
    @Test
    public void testDb(){
        DBConnection db1 = DBConnection.getInstance();
        DBConnection db2 = DBConnection.getInstance();
        Assertions.assertEquals(db1, db2);
    }
}
