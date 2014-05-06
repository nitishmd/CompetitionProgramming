public class MineField {
  
  public void getMineField(String mineLocations) {
    int[][] mineField = new int[9][9];


    for(int i = 1; i < mineLocations.length(); ) {
      //System.out.println("Debug: Locations"+mineLocations.charAt(i)+" "+mineLocations.charAt(i+2));
      int x = Character.getNumericValue(mineLocations.charAt(i));
      int y = Character.getNumericValue(mineLocations.charAt(i+2));

      //System.out.println("Debug: "+x+" "+y);

      mineField[x][y] = -1;

      // Here is the bug
      if((x-1) >= 0 && (x+1) <= 8 && (y-1) >= 0 && (y+1) <= 8) {
        // Mark borders
        mineField[x-1][y] = mineField[x-1][y] == -1? -1 : mineField[x-1][y] + 1;
        System.out.println("Debug: "+mineField[x-1][y]);
        mineField[x+1][y] = mineField[x+1][y] == -1? -1 : mineField[x+1][y] + 1;
        mineField[x][y-1] = mineField[x][y-1] == -1? -1 : mineField[x][y-1] + 1;
        mineField[x][y+1] = mineField[x][y+1] == -1? -1 : mineField[x][y+1] + 1;
        mineField[x-1][y-1] = mineField[x-1][y-1] == -1? -1 :  mineField[x-1][y-1] + 1;
        mineField[x+1][y+1] = mineField[x+1][y+1] == -1? -1 : mineField[x+1][y+1] + 1;
        mineField[x+1][y-1] = mineField[x+1][y-1] == -1? -1 : mineField[x+1][y-1] + 1;
        mineField[x-1][y+1] = mineField[x-1][y+1] == -1? -1 :  mineField[x-1][y+1] + 1;
      }
      i = i + 5;
    }

    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        System.out.print(mineField[i][j]+" ");
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    String s = "(0,0)(1,0)(2,0)(3,0)(4,0)";
    MineField m = new MineField();
    m.getMineField(s);
  }
}
