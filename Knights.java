import java.util.ArrayList;
class Knights {
  // i +/- 2 & j +/- 1
  // i +/- 1 & j +/- 2
  public static boolean cannotCapture(int[][] board)
  {
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == 1) {
          for (int factor = 1; factor < 3; factor++){
            for (int signs = 0; signs < 4; signs++){
              int _i = i + (factor * (Math.floorDiv(signs,2)==0 ? 1 : -1));
              if (_i<0 || _i>7) continue;
              int _j = j + ((factor==1 ? 2 : 1) * (signs%2==0?1:-1));
              if (_j<0 || _j>7) continue;
              if (board[_i][_j] == 1) return true;
            }
          }
        }
      }
    }
    return false;
  }
  public static void main(String[] args)
  {
    System.out.println(cannotCapture(new int[][]{
      new int[]{0, 0, 0, 1, 0, 0, 0, 0},
      new int[]{0, 0, 0, 0, 0, 0, 0, 0},
      new int[]{0, 1, 0, 0, 0, 1, 0, 0},
      new int[]{0, 0, 0, 0, 1, 0, 1, 0},
      new int[]{0, 1, 0, 0, 0, 1, 0, 0},
      new int[]{0, 0, 0, 0, 0, 0, 0, 0},
      new int[]{0, 1, 0, 0, 0, 0, 0, 1},
      new int[]{0, 0, 0, 0, 1, 0, 0, 0}
    }));
    System.out.println(cannotCapture(new int[][]{
      new int[]{1, 0, 1, 0, 1, 0, 1, 0},
      new int[]{0, 1, 0, 1, 0, 1, 0, 1},
      new int[]{0, 0, 0, 0, 1, 0, 1, 0},
      new int[]{0, 0, 1, 0, 0, 1, 0, 1},
      new int[]{1, 0, 0, 0, 1, 0, 1, 0},
      new int[]{0, 0, 0, 0, 0, 1, 0, 1},
      new int[]{1, 0, 0, 0, 1, 0, 1, 0},
      new int[]{0, 0, 0, 1, 0, 1, 0, 1}
    }));
  }
}