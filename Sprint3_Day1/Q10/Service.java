package Q10;

public class Service {
    private final Repository repo = new Repository();

    public String process() throws DatabaseException {
        return repo.fetchData(); 
    }
}

