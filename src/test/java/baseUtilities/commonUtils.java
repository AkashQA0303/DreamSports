package baseUtilities;

import java.util.ArrayList;
import java.util.List;

import pojomodel.Todo;

public class commonUtils {
	
	protected static List<Todo> todoList = new ArrayList<>();
    protected static List<Integer> fanCodeUserIds = new ArrayList<>();
    
    protected String baseUrl;

    public commonUtils() {
        this.baseUrl = ConfigReader.getProperty("base_url");
    }

}
