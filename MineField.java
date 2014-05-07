/*
 * Author: Nitish Devadiga
 * Description: TopCoder SRM 169 Div 1 250
 */

public class MineField {

  boolean checkBorder(int x, int y) {
    if(x >= 0 && x <= 8 && y >= 0 && y <= 8) {
      return true;
    }
    return false;
  }
  
  public String[] getMineField(String mineLocations) {
    int[][] mineField = new int[9][9];
    String[] outputField = new String[9];


    for(int i = 1; i < mineLocations.length(); ) {
      //System.out.println("Debug: Locations"+mineLocations.charAt(i)+" "+mineLocations.charAt(i+2));
      int x = Character.getNumericValue(mineLocations.charAt(i));
      int y = Character.getNumericValue(mineLocations.charAt(i+2));

      //System.out.println("Debug: "+x+" "+y);

      mineField[x][y] = -1;

      // Mark borders
      if(checkBorder(x-1,y))
        mineField[x-1][y] = mineField[x-1][y] == -1? -1 : mineField[x-1][y] + 1;
      if(checkBorder(x+1,y))
        mineField[x+1][y] = mineField[x+1][y] == -1? -1 : mineField[x+1][y] + 1;
      if(checkBorder(x,y-1))
        mineField[x][y-1] = mineField[x][y-1] == -1? -1 : mineField[x][y-1] + 1;
      if(checkBorder(x,y+1))
        mineField[x][y+1] = mineField[x][y+1] == -1? -1 : mineField[x][y+1] + 1;
      if(checkBorder(x-1,y-1))
        mineField[x-1][y-1] = mineField[x-1][y-1] == -1? -1 :  mineField[x-1][y-1] + 1;
      if(checkBorder(x+1,y+1))
        mineField[x+1][y+1] = mineField[x+1][y+1] == -1? -1 : mineField[x+1][y+1] + 1;
      if(checkBorder(x+1,y-1))
        mineField[x+1][y-1] = mineField[x+1][y-1] == -1? -1 : mineField[x+1][y-1] + 1;
      if(checkBorder(x-1,y+1))
        mineField[x-1][y+1] = mineField[x-1][y+1] == -1? -1 :  mineField[x-1][y+1] + 1;

      i = i + 5;
    }


    StringBuilder mines = new StringBuilder();
    String mine;
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        mine = mineField[i][j] == -1? "M" : Integer.toString(mineField[i][j]);
        mines.append(mine);
      }
      outputField[i] = mines.toString();
      //System.out.println(outputField[i]);
      mines.setLength(0);
    }
    return outputField;
  }

  /*public static void main(String[] args) {
    String s = "(0,0)(1,0)(2,0)(3,0)(4,0)";
    MineField m = new MineField();
    m.getMineField(s);
  }*/
}
