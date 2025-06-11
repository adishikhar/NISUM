package Q10;

public class Controller {
    private final Service service = new Service();

    public void handleRequest() {
        try {
            String result = service.process();
            System.out.println("Result: " + result);
        } catch (DatabaseException e) {
            System.out.println("Error: " + e.getMessage());  
        }
    }
}
