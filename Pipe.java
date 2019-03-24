public class pipe extends Entity{
    private boolean collision = true;
    private int length = 2;
    private int width = 2;
    public Pipe(int x, int y, int w, int l, boolean collideable) {
        super(x,y);
        setCollision(collideable);
        if (w > 0){
            this.width = w;
        }
        if (l > 0){
            this.length = l;
        }
    }
    
      public void setCollision(boolean collideable) {
        this.collision = collideable;
      }
    
      public boolean getCollision() {
        return this.collision;
      }
    
    public void setLength(int l){
        this.length = l;
    }
    
    public int getLength(){
        return length;
    }

    public void setWidth(int w){
        this.width = w;
    }
    
    public int getWidth(){
        return Width;
    }
}