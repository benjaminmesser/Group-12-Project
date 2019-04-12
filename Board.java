import java.util.ArrayList;

 /**
 * This class sets up the game environment and implements how Mario is able to interact with his environment aka map
 */
public class Board {
  private char[][] map;
  private ArrayList<Character> characters = new ArrayList<Character>();
  private ArrayList<Entity> entities = new ArrayList<Entity>();
  private final char[][] DEFAULT_MAP = new char[][] {
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'c', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ', ' '},
    {' ', ' ', ' ', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', 'c', 'c', 'c', ' ', ' ', ' ',' ',' ',' ', ' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' ', ' '},
    {' ', 'd', 'x', ' ', ' ', 'g', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', 'x', 'x', 'x', ' ', ' ', ' ',' ','d',' ', ' '},
    {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', ' ','b','b','b', 'b'},
    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', ' ','u','u','u', 'u'}};

 /**
 * @param map is setup as a character array
 */
  public Board(char[][] map) {
    this.map = initializeMap(map);
  }

  public Board() {
    this.map = initializeMap(null);
  }
  public void restartGame(){
    this.map = initializeMap(null);
  }
 /**
 * The different characters/letters in the maps' character array correspond to different types of blocks
 *  i.e. c corresponds to coin and so on to initialise the game environment/map
 * @param input if there is no user input the map is set to the default version
 * if user input is detected, it returns the updated map to reflect this
 * @return returns the map which is a character array
 */
  public char[][] initializeMap(char[][] input) {
    char[][] map;
    characters.clear();
    entities.clear();
    if (input == null) {
      map = DEFAULT_MAP;
    } else {
      map = input;
    }

    int p = 1;
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        switch (map[i][j]) {
          case 'd':
            entities.add(new Mario(j*32, i*32, p));
            if (p == 1){
              p = 2;
            }
            characters.add((Character)entities.get(entities.size()-1));
            map[i][j] = ' ';
            break;
          case 'g':
            entities.add(new Goomba(j*32, i*32));
            characters.add((Character)entities.get(entities.size()-1));
            map[i][j] = ' ';
            break;
          case 'b':
            entities.add(new Block(j*32, i*32, "Grass"));
            break;
          case 'u':
            entities.add(new Block(j*32, i*32, "Dirt"));
            break;
          case 'c':
            entities.add(new Block(j*32, i*32, "Coin"));
            break;
          case 'x':
            entities.add(new Block(j*32, i*32, "Block"));
            break;
          case 'q':
            entities.add(new Block(j*32, i*32, "QuestionBlock"));
            break;
          case ' ':
            break;
          default:
            entities.add(new Block(j*32, i*32, "Undefined"));
            break;
        }
      }
    }
    return map;
  }

 /**
 * @return returns mapClone
 * which is a copy of the map.
 */
  public char[][] getMap() {
    char[][] mapClone = new char[map.length][map[0].length];
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        mapClone[i][j] = map[i][j];
      }
    }
    return mapClone;
  }

  public ArrayList<Entity> getEntities() {
    // Memory leak here but is needed
    return this.entities;
  }

  public ArrayList<Character> getCharacters() {
    return this.characters;
  }

  public Entity getEntity(int i){
    return entities.get(i-1);
  }

  public Character getCharacter(int i){
    return characters.get(i-1);
  }

 /**
 * This method handles collisions between Mario and other objects such as Goombas
 * It uses the side of the character that is touching the other object
 * where 'T' - top, 'B' - bottom, 'L' - left, 'R' - right
 * It first finds a collision face
 * It compare the two entities and do actions based on what face the collision is on
 * if Collision is not nothing (not empty) and not T, and it's Mario and Goomba, take health off the Mario
 */
  public void handleCollisions() {
    int charXPos;
    int charYPos;
    int entXPos;
    int entYPos;
    // The side of the character that is touching the other object
    char collisionFace = ' '; // 'T' - top, 'B' - bottom, 'L' - left, 'R' - right
    for (int i = 0; i < characters.size(); i++) {
      characters.get(i).setGrounded(false);
      for (int j = 0; j < entities.size(); j++) {
        if (characters.size() == i){
          break;
        }
        if (characters.get(i) != entities.get(j)) {
          charXPos = characters.get(i).getXPos();
          charYPos = characters.get(i).getYPos();
          entXPos = entities.get(j).getXPos();
          entYPos = entities.get(j).getYPos();
            // Find collision face
          if ((charYPos <= entYPos && charYPos + 32 >= entYPos) && (charYPos + 32 - entYPos <= charXPos + 32 - entXPos) && (charYPos + 32 - entYPos <= entXPos + 32 - charXPos)) {
            collisionFace = 'B';
          } else if ((charYPos >= entYPos && charYPos <= entYPos + 32) && (entYPos + 32 - charYPos <= charXPos + 32 - entXPos) && (entYPos + 32 - charYPos <= entXPos + 32 - charXPos)) {
            collisionFace = 'T';
          } else if ((charXPos <= entXPos && charXPos + 32 >= entXPos) && (charXPos + 32 - entXPos <= charYPos + 32 - entYPos) && (charXPos + 32 - entXPos <= entYPos + 32 - charYPos)) {
            collisionFace = 'R';
          } else if ((charXPos >= entXPos && charXPos <= entXPos + 32) && (entXPos + 32 - charXPos <= charYPos + 32 - entYPos) && (entXPos + 32 - charXPos <= entYPos + 32 - charYPos)) {
            collisionFace = 'L';
          } else {
            collisionFace = ' ';
          }
          // Compare the two entities and do actions based on what face the collision is on
          if (collisionFace != ' ') {
            if (entities.get(j).getType() == "Coin" && characters.get(i).getType() == "Mario") {
              entities.remove(j);
              ((Mario)characters.get(i)).addCoin();
              j--; // Without this the loop will skip an object
              continue;
            }
          }
          // if Collision is not nothing and not T, and it's Mario and Goomba, take health off the Mario
          if (collisionFace != ' ' && collisionFace != 'B' && entities.get(j).getType().equals("Goomba") && characters.get(i).getType().equals("Mario")){
            //if (entities.get(j).getType().equals("Goomba") && characters.get(i).getType().equals("Mario")){
              ((Mario)characters.get(i)).hurt(1);
              if (((Mario)characters.get(i)).getHealth() <= 0){
                for (int e = 0; e < entities.size(); e++){
                  if (entities.get(e).equals(characters.get(i))){
                    characters.remove(i);
                    entities.remove(e);
                    break;
                  }
                }
              }
          //  }
          } else if (collisionFace == 'T') {
            if (entities.get(j).isCollideable()) {

              characters.get(i).setYVelocity(0);
              // Move character
              characters.get(i).setYPos(entYPos + 32);
            }
          } else if (collisionFace == 'B') {
            if (entities.get(j).isCollideable()) {
              if (entities.get(j).getType().equals("Goomba") && characters.get(i).getType().equals("Mario")){
                ((Goomba)entities.get(j)).kill();
                ((Mario)characters.get(i)).addCoin();
                entities.remove(j);
                j--;
              }
              characters.get(i).setGrounded(true);
              characters.get(i).setYVelocity(0);
              // Move character
              characters.get(i).setYPos(entYPos - 32);
            }
          } else if (collisionFace == 'L') {
            if (entities.get(j).isCollideable()) {
              //characters.get(i).setXVelocity(0);
              // Move character
              if (characters.get(i).getType().equals("Goomba")){
                characters.get(i).setXVelocity(characters.get(i).getXVelocity()*-1);
              }
              characters.get(i).setXPos(entXPos + 32);
            }
          } else if (collisionFace == 'R') {
            if (entities.get(j).isCollideable()) {
              //characters.get(i).setXVelocity(0);
              // Move character
              if (characters.get(i).getType().equals("Goomba") && entities.get(j).getType().equals("Block")){
                characters.get(i).setXVelocity(characters.get(i).getXVelocity()*-1);
              }
              characters.get(i).setXPos(entXPos - 32);
            }
          }
        }
      }
    }
  }
  /**
  * This method deals when either one of the Mario's falls into the pit on the board
  * It will first "kill" the Mario by removing his health (-3) and then resets the
  * the Mario who "fell" to their initial positions
  * Goombas or Coins are not respawned if defeated or collected respectively
  */

  public void handleFallingOffBoard(){
    for (int i = 0; i < characters.size(); i++) {
	     if (characters.get(i) instanceof Mario){
		       Mario m = (Mario)characters.get(i);
		       int charY = characters.get(i).getYPos();
		       if(charY >= (map.length * 32) - 32){
	            m.hurt(1);
			        ((Character) m).setXPos(m.getStartPositionX());
			        ((Character) m).setYPos(m.getStartPositionY());
              if (((Mario)characters.get(i)).getHealth() <= 0){
                for (int e = 0; e < entities.size(); e++){
                  if (entities.get(e).equals(characters.get(i))){
                    characters.remove(i);
                    entities.remove(e);
                    break;
                  }
                }
              }
            }
          }
        }
      }
}
