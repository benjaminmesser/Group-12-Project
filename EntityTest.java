public class EntityTest{

    public class EntityTest{

        @test
        public void test_creation(){
            Entity b = new Entity(5,5);
            assertEquals("Expected x position to be 5", 1, b.getXPos, 0.00001);
            assertEquals("Expected y position to be 5", 1, b.getYPos, 0.00001);
        }

        @test
        public void test_invalid_Constructor(){
            Entity b = new Entity(-1,-1);
            assertEquals("Expected x position to be 1", 1, b.getXPos, 0.00001);
            assertEquals("Expected y position to be 1", 1, b.getYPos, 0.00001);
        }

        @test
        public void test_copy_constuctor(){
            Entity e1 = new Entity(5,10);
            Entity e2  = new Entity(e1);

            assertEquals("Expected x position to be 1", 5, e2.getXPos, 0.00001);
            assertEquals("Expected y position to be 1", 10, e2.getYPos, 0.00001);
        }

        @test
        public void test_Set_X(){
            Entity b = new Entity(5,5);
            b.setXPos(10);
            assertEquals("Expected x position to be 10", 10, b.getXPos, 0.00001);
        }

        @test
        public void test_Set_Y(){
            Entity b = new Entity(5,5);
            b.setYPos(10);
            assertEquals("Expected y position to be 10", 10, b.getYPos, 0.00001);
        }

        @test
        public void test_invalid_X(){
            Entity b = new Entity(5,5);
            b.setXPos(-1);
            assertEquals("Expected x position to be 1", 1, b.getYPos, 0.00001);
        }

        @test
        public void test_invalid_Y(){
            Entity b = new Entity(5,5);
            b.setYPos(-1);
            assertEquals("Expected y position to be 1", 1, b.getYPos, 0.00001);
        }
            
    } 
}