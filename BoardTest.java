import static org.junit.Assert.*;

import org.junit.Test;


public class BoardTest{
    @Test
    public void creation_test(){

        char[][] testmap = new char[][]{
            {'b','d','c','x'},
            {'u','g','c','0'}};

        Board oldboard = new Board(testmap);


        assertEquals("Expected First entity to be grassblock type", "Grass" , oldboard.getEntity(1).getType());
        assertEquals("Expected First entity x location to be at 0", 0 , oldboard.getEntity(1).getXPos());
        assertEquals("Expected First entity y location to be at 0", 0 , oldboard.getEntity(1).getYPos());
        assertEquals("Expected grassblock entity to be collidable", true , oldboard.getEntity(1).isCollideable());

        assertEquals("Expected First Character to be Mario", "Mario" , oldboard.getCharacter(1).getType());
        assertEquals("Expected Mario x pos to be 32", 32 , oldboard.getCharacter(1).getXPos());
        assertEquals("Expected Mario y pos to be 0", 0 ,oldboard.getCharacter(1).getYPos());
        

        assertEquals("Expected third entity to be coin", "Coin", oldboard.getEntity(3).getType());
        assertEquals("Expected third entity to be non-collidable", false, oldboard.getEntity(3).isCollideable());
        assertEquals("Expected 8th entity to be not be initiallized at 96,32", 96, oldboard.getEntity(8).getXPos());
        assertEquals("Expected 8th entity to be not be initiallized at 96,32", 32, oldboard.getEntity(8).getYPos());

        assertEquals("expected testmap to have height of 2", 2 ,testmap.length);
        assertEquals("expected testmap to have Lenght of 4", 4 ,testmap[0].length);
    }

    @Test
    public void return_map_test(){
        char[][] testmap = new char[][]{
            {'b','d','c','x'},
            {'u','g','c','0'}};

        Board oldboard = new Board(testmap);

        assertEquals("expected map", testmap ,oldboard.getMap());
    
    }
    @Test
    public void Entities_Test(){
        char[][] testmap = new char[][]{
            {'b','d','c','x'},
            {'u','g','c','0'}};

        Board oldboard = new Board(testmap);
        assertEquals("Expected 8 entities in map", 8, oldboard.getEntities().size());
    }
    @Test
    public void Characters_Test(){
        char[][] testmap = new char[][]{
            {'b','d','c','x'},
            {'u','g','c','0'}};

        Board oldboard = new Board(testmap);
        assertEquals("Expected 2 Characters in map", 2, oldboard.getCharacters().size());
    }

    @Test
    public void bigBoard_Test(){
        char [][] oldmap = new char[][]{
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'c', 'c', 'c', ' ', ' ',' ', ' ', ' ', 'c', 'c', 'c', 'c', 'c', 'c', ' ', 'c', 'c', 'c', 'c', 'c', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'w', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'c', 'c', 'c', ' ', ' ',' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'c', 'c', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ', 'b', 'b', ' ', ' ', ' ', 'w', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ', 'c', 'c', ' ', ' ', ' ', 'c', 'c', 'c', ' ', ' ',' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'c', 'c', 'c', 'c', ' ', ' ', 'c', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', 'b', 'u', 'u', ' ', ' ', ' ', 'w', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'c', ' ', 'c', 'c', 'c', ' ', 'c', ' ', ' ', ' ', ' ', ' ', ' ','c', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', 'c', 'c', 'c', ' ', ' ', ' ', ' ', ' ', 'c', ' ', ' ', ' ', 'c', 'c', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', 'b', 'u', 'u', 'u', ' ', ' ', ' ', 'w', ' ', ' ', 'm', ' '},
            {' ', ' ', ' ', 'x', ' ', 'x', 'q', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', 'b', 'b', ' ', ' ', 'b', 'b', ' ', ' ', 'q', ' ', ' ', ' ',' ', 'x', 'q', 'x', ' ', ' ', ' ', ' ', 'c', ' ', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'b', ' ', 'b', ' ', ' ', ' ', ' ',' ', ' ', 'b', 'u', 'u', 'u', 'u', ' ', ' ', ' ', 'w', ' ', 'm', 'm', 'm'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'b', 'b',' ', ' ', ' ', 'u', 'u', ' ', ' ', 'u', 'u', ' ', ' ', ' ', ' ', 'c', 'c',' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'b', 'u', ' ', 'u', 'b', ' ', ' ', ' ',' ', 'b', 'u', 'u', 'u', 'u', 'u', ' ', ' ', ' ', 'w', ' ', 'm', 'm', 'm'},
            {' ', 'd', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'u', 'u',' ', ' ', ' ', 'u', 'u', ' ', ' ', 'u', 'u', ' ', ' ', ' ', ' ', ' ', ' ',' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'b', 'u', 'u', ' ', 'u', 'u', 'b', ' ', ' ','b', 'u', 'u', 'u', 'u', 'u', 'u', ' ', ' ', ' ', 'w', ' ', 'm', ' ', 'm'},
            {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'u', 'u','b', 'b', 'b', 'u', 'u', 'b', 'b', 'u', 'u', 'b', 'b', 'b', 'b', ' ', ' ', 'b','b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', ' ', 'b', 'b', 'b', 'b', 'b', 'b', 'u', 'u', 'u', ' ', 'u', 'u', 'u', 'b', 'b', 'u','u', 'u', 'u', 'u', 'u', 'u', 'b', 'b', 'b', 'w', 'b', 'b', 'b', 'b'}};

    Board oldboard = new Board(oldmap);

    assertEquals("Expected map to be fully copied", oldmap, oldboard.getMap());
    assertEquals("Expected 1 Character in map", 1, oldboard.getCharacters().size());

    }
}

