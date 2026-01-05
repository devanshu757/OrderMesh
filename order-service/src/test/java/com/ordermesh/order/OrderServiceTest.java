@SpringBootTest
class OrderServiceTest {

    @Test
    void createOrderDoesNotThrow() {
        OrderService service = new OrderService();
        assertDoesNotThrow(() ->
            service.createOrder("P100", 1)
        );
    }
}
