package maze.tools;

public class ToolBuilder {
    public static Tool byName(String name) {
        switch (name) {
            case "key": return new Key();
            case "hammer": return new Hammer();
            default: return null;
        }
    }
}
