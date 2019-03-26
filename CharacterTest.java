import static org.junit.Assert.*;

import org.junit.Test;


public class CharacterTest{


        @Test
        public void test_creation(){
            Character b = new Character(5,5);
            assertEquals("Expected x position to be 5", 5, b.getXPos(), 0.00001);
            assertEquals("Expected y position to be 5", 5, b.getYPos(), 0.00001);
        }

        @Test
        public void test_invalid_Constructor(){
            Character b = new Character(-1,-1);
            assertEquals("Expected x position to be 0", 0, b.getXPos(), 0.00001);
            assertEquals("Expected y position to be 0", 0, b.getYPos(), 0.00001);
        }

        @Test
        public void test_copy_constuctor(){
            Character e1 = new Character(5,10);
            Character e2  = new Character(e1);

            assertEquals("Expected x position to be 5", 5, e2.getXPos(), 0.00001);
            assertEquals("Expected y position to be 10", 10, e2.getYPos(), 0.00001);
        }

        @Test
        public void test_Set_X(){
            Character b = new Character(5,5);
            b.setXPos(10);
            assertEquals("Expected x position to be 10", 10, b.getXPos(), 0.00001);
        }

        @Test
        public void test_Set_Y(){
            Character b = new Character(5,5);
            b.setYPos(10);
            assertEquals("Expected y position to be 10", 10, b.getYPos(), 0.00001);
        }

        @Test
        public void test_invalid_X(){
            Character b = new Character(5,5);
            b.setXPos(-1);
            assertEquals("Expected x position to be 0", 0, b.getXPos(), 0.00001);
        }

        @Test
        public void test_invalid_Y(){
            Character b = new Character(5,5);
            b.setYPos(-1);
            assertEquals("Expected y position to be 0", 0, b.getYPos(), 0.00001);
        }
            
    } 
