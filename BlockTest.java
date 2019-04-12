import static org.junit.Assert.*;

import org.junit.Test;


public class BlockTest{

    @Test
    public void set_Type_test(){
        Block b = new Block(1,1,"dirt");
        assertEquals("Code is case sensitive, expected type to be undefined", "Undefined", b.getType());
        assertEquals("MainClass should always return Block, even if undefined", "Block", b.getMainClass());
        Block dirtblock = new Block(1,1,"Dirt");
        assertEquals("Code is case sensitive, expected type to be dirt block", "Dirt", dirtblock.getType());
        assertEquals("expected block to be initalized at 1,1", 1, dirtblock.getXPos(),0.00001);
        assertEquals("expected block to be initalized at 1,1", 1, dirtblock.getYPos(),0.00001);
        assertEquals("expected dirt block to be collidable", true, dirtblock.isCollideable());

        Block coinblock = new Block(0,0,"Coin");
        assertEquals("expected coins to be not be collidable", false, coinblock.isCollideable());

        coinblock.setType("Grass");
        coinblock.setXPos(-10);
        coinblock.setYPos(-10);

        assertEquals("Set coinblock to grassblock type, Type should not be changed while game is running", false, coinblock.isCollideable());
        assertEquals("Set coinblock to grassblock type, set x position values to -10, expected x pos to be -10", -10, coinblock.getXPos(), 0.0001);
        assertEquals("Set coinblock to grassblock type, set y position values to -10, expected y pos to be -10", -10, coinblock.getYPos(), 0.0001);

        assertEquals("MainClass should always return Block", "Block", coinblock.getMainClass());
    }
}