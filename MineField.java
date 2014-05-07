/*
 * Author: Nitish Devadiga
 * Description: TopCoder SRM 169 Div 1 250
 */
import java.util.*;
import static java.lang.Integer.parseInt;

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
    StringTokenizer st = new StringTokenizer(mineLocations, "(,)");
    int[] dx = {-1,1,0,0,-1,1,1,-1};
    int[] dy = {0,0,-1,1,-1,1,-1,1};

    while(st.hasMoreTokens()) {
      int x = parseInt(st.nextToken());
      int y = parseInt(st.nextToken());

      mineField[x][y] = -1;

      for(int i = 0; i < dx.length; i++) {
        int ix = x + dx[i];
        int iy = y + dy[i];
        if(!checkBorder(ix, iy))
          continue;
        mineField[ix][iy] = mineField[ix][iy] == -1? -1 : mineField[ix][iy] + 1;
      }
    }

    StringBuilder mines = new StringBuilder();
    String mine;
    for(int i = 0; i < mineField.length; i++) {
      for(int j = 0; j < mineField[i].length; j++) {
        mine = mineField[i][j] == -1? "M" : Integer.toString(mineField[i][j]);
        mines.append(mine);
      }
      outputField[i] = mines.toString();
      System.out.println(outputField[i]);
      mines.setLength(0);
    }
    return outputField;
  }

  public static void main(String[] args) {
    String s = "(0,0)(1,0)(2,0)(3,0)(4,0)";
    MineField m = new MineField();
    m.getMineField(s);
  }
}
