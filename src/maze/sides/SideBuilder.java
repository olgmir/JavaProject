package maze.sides;

public class SideBuilder {
    public static Side byName(String name) {
        if(name.equals("no"))
            return new OpenSide();
        else if(name.equals("wall"))
            return new Wall();
        else if(name.equals("fake"))
            return new FakeWall();
        else if(name.equals("breakable"))
            return new BreakableWall();
        else if(name.equals("door"))
            return new Door();
        else
            return null;
    }
}
