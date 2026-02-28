import java.util.Map;

class Stud {
    String name;
    String id;
    Map<String, Result> results;

    Stud(String name, String id, Map<String, Result> results) {
        this.name = name;
        this.id = id;
        this.results = results;
    }
}