import org.junit.Assert;
import org.junit.Test;
import ru.eremin.soap.note.*;

/**
 * @autor Eremin Artem on 24.01.2019.
 */

public class NoteTest {

    @Test
    public void test() {
        final NoteEndpointPortService service = new NoteEndpointPortService();
        final NoteEndpointPort port = service.getNoteEndpointPortSoap11();
        final FindAllRequest request = new FindAllRequest();
        request.setCategoryId("a4ccddb7-4883-4c5f-829c-c95e3b20b467");
        final FindAllResponse response = port.findAll(request);
        final int size = response.getRows().size();

        final CreateRequest request1 = new CreateRequest();
        request1.setCategoryName("New Category");
        request1.setData("testeste");
        request1.setDescription("test");
        port.create(request1);

        final FindAllResponse response1 = port.findAll(request);
        final int newSize = response1.getRows().size();
        Assert.assertEquals(size, newSize - 1);
    }
}
