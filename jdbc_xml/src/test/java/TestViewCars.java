import buisneslayer.Dispatcher;
import buisneslayer.GoodsViewer;
import models.CarShop;
import models.Cars;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestViewCars extends BaseTest {

    @Test
    public void isAllCategoriesAreAvailable() {

        GoodsViewer goodsViewer = new GoodsViewer();
        goodsViewer.viewAllCars(carShop);
        List<Cars> goodsViewerList = goodsViewer.getCarsList();
        List<Integer> categoriesInGoods = goodsViewerList.stream()
                .map(Cars::getCars_category).distinct()
                .collect(Collectors.toList());
        assertNotNull(categoriesInGoods);

    }

    @Test
    public void isAllCategoriesAreAvailableXML() {

        Dispatcher dispatcher = new Dispatcher("xml");
        CarShop carShop = dispatcher.getCarShop();
        GoodsViewer goodsViewer = new GoodsViewer();
        goodsViewer.viewAllCars(carShop);
        List<Cars> goodsViewerList = goodsViewer.getCarsList();
        List<Integer> categoriesInGoods = goodsViewerList.stream()
                .map(Cars::getCars_category).distinct()
                .collect(Collectors.toList());
        assertNotNull(categoriesInGoods);

    }
}
