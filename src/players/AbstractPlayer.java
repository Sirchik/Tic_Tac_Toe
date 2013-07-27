package players;

import grid.Grid;

public abstract class AbstractPlayer implements IPlayer {
    protected String name;
    protected char symbolForGame;
    protected Grid game;

    AbstractPlayer(String in_name, char ch, Grid in_game) {
        name = in_name;
        symbolForGame = ch;
        game = in_game;
    }

    @Override
    public void move() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public char getSymbolForGame() {
        return symbolForGame;
    }

    public String getName() {
        return name;
    }
}
