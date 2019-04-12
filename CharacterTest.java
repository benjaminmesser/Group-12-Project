import static org.junit.Assert.*;

import org.junit.Test;


public class CharacterTest{


        @Test
        public void test_creation(){
            Character b = new Character(5,5);
            assertEquals("Expected x position to be 5", 5, b.getXPos(), 0.00001);
            assertEquals("Expected y position to be 5", 5, b.getYPos(), 0.00001);
            assertEquals("Expected Collidable to be true", true, b.isCollideable());
        }

        @Test
        public void test_invalid_Constructor(){
            Character b = new Character(-1,-1);
            assertEquals("Expected x position to be -1", -1, b.getXPos(), 0.00001);
            assertEquals("Expected y position to be -1", -1, b.getYPos(), 0.00001);
        }


        @Test
        public void test_Set_xy(){
            Character b = new Character(5,5);
            b.setXPos(10);
            b.setYPos(10);
            assertEquals("Expected x position to be 10", 10, b.getXPos(), 0.00001);
            assertEquals("Expected y position to be 10", 10, b.getXPos(), 0.00001);
        }

        @Test
        public void Collisiontest(){
            Character b = new Character(0,0);
            b.setCollision(false);
            assertEquals("Expected is collidable to be false", false, b.isCollideable());
        }

        @Test
        public void set_velocity_Test(){
            Character b = new Character(0,0);
            assertEquals("Expected initial x velocity to be 1", 1, b.getXVelocity(), 0.00001);
            assertEquals("Expected initial y velocity to be 0", 0, b.getYVelocity(), 0.00001);
            b.setXVelocity(-1);
            assertEquals("Testing negatives, Expected y velocity to be set to -1", -1, b.getXVelocity(), 0.00001);
            b.setYVelocity(-100);
            assertEquals("Testing negatives, Expected y velocity to be set to -100", -100, b.getYVelocity(), 0.00001);
            b.setXVelocity(10000);
            assertEquals("Testing Large numbers, Expected x velocity to be set to 10000", 10000, b.getXVelocity(), 0.00001);
            assertEquals("grounded should be initalized to false", false, b.isGrounded());
        }

        @Test
        public void add_velocity_Test(){
            Character b =new Character(0,0);
            b.setXVelocity(10);
            b.addXVelocity(-10);
            assertEquals("testing for negatives, set speed to 10, then added -10 expected value to be 0", 0, b.getXVelocity(), 0.00001);
            b.setYVelocity(5);
            b.addYVelocity(10);
            assertEquals("set horizontal speed to 5, then added 10, expected value to be 15", 15, b.getYVelocity(), 0.00001);
        }

        @Test
        public void test_set_grounded(){
            Character b = new Character(0,0);
            b.setGrounded(true);
            assertEquals("grounded should be set to true", true, b.isGrounded());
        }

        @Test
        public void Mario_Test(){
            Mario m = new Mario(1, 1, 1);
            assertEquals("Expected Mario to be initalized at 0 coins", 0 ,m.getCoins());
            assertEquals("Expected Mario to be initalized at 3 health", 3 ,m.getHealth());
            assertEquals("Expected Mario to be of type Mario", "Mario" ,m.getType());
            assertEquals("Expected Mario to be initalized facing right", "Right" ,m.getSprite());

            m.addCoin();
            m.addCoin();
            m.addCoin();
            m.addCoin();
            m.addCoin();
            m.addCoin();

            m.hurt(2);

            assertEquals("Expected Mario have 6 coins after adding coin 6 times", 6 ,m.getCoins());
            assertEquals("Expected Mario to have 1 health after taking 2 damage of hurt", 1 ,m.getHealth());

            m.setCoins(1000);
            m.setSprite("Left");

            assertEquals("Expected Mario have 1000 coins after setting coins to 1000", 1000 ,m.getCoins());
            assertEquals("Expected Mario to be turned left", "Left" ,m.getSprite());

        }

        @Test
        public void GoombaTest(){
            Goomba g = new Goomba(1,1);

            assertEquals("Expected Goomba to be of type Goomba", "Goomba" , g.getType());
            assertEquals("Expected Goomba to be initalized at 1 health", 1 ,g.getHealth());

            g.kill();

            assertEquals("Expected Gomba to die", 0 ,g.getHealth());
            
        }
    }
