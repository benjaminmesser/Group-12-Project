import java.util.ArrayList;

public class Board {
  private char[][] map;
  private ArrayList<Character> characters = new ArrayList<Character>();
  private ArrayList<Entity> entities = new ArrayList<Entity>();
  private final char[][] DEFAULT_MAP = new char[][] {
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'c', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'c', 'c', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' '},
    {' ', ' ', ' ', 'c', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', 'c', 'c', 'c', ' ', ' ', ' ',' ',' ',' '},
    {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' ',' ',' '},
    {' ', 'd', ' ', 'x', ' ', 'g', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', 'x', 'x', 'x', ' ', ' ', ' ',' ',' ',' '},
    {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', ' ','b','b','b'},
    {'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', 'u', ' ','u','u','u'}};

  public Board(char[][] map) {
    this.map = initializeMap(map);
  }

  public Board() {
    this.map = initializeMap(null);
  }

  public char[][] initializeMap(char[][] input) {
    char[][] map;
    if (input == null) {
      map = DEFAULT_MAP;
    } else {
      map = input;
    }

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        switch (map[i][j]) {
          case 'd':
            entities.add(new Mario(j*32, i*32));
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

  public char[][] getMap() {
    //returns a copy of the map.
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
          if (collisionFace == 'T') {
            if (entities.get(j).isCollideable()) {
              characters.get(i).setYVelocity(0);
              // Move character
              characters.get(i).setYPos(entYPos + 32);
            }
          } else if (collisionFace == 'B') {
            if (entities.get(j).isCollideable()) {
              characters.get(i).setGrounded(true);
              characters.get(i).setYVelocity(0);
              // Move character
              characters.get(i).setYPos(entYPos - 32);
            }
          } else if (collisionFace == 'L') {
            if (entities.get(j).isCollideable()) {
              characters.get(i).setXVelocity(0);
              // Move character
              characters.get(i).setXPos(entXPos + 32);
            }
          } else if (collisionFace == 'R') {
            if (entities.get(j).isCollideable()) {
              characters.get(i).setXVelocity(0);
              // Move character
              characters.get(i).setXPos(entXPos - 32);
            }
          }
        }
      }
    }
  }
}
