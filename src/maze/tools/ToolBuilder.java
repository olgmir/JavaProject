package maze.tools;

public class ToolBuilder {
    public static Tool byName(String name) {
        switch (name) {
            case "key": return new Key();
            case "hammer": return new Hammer();
            case "start": return new StartToken();
            case "end": return new EndToken();
            default: return null;
        }
    }
}
