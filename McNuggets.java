import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
class McNuggets {
  
  static int greatestImpossible(int x, int y, int z, int max)
  { // bottom up
    boolean[] sums = new boolean[max+1];
    int iMax = max/x;
    int jMax = max/y;
    int kMax = max/z;
    for (int i = 0; i <= iMax; i++) {
      for (int j = 0;  j <= jMax; j++) {
        for (int k = 0; k <= kMax; k++) {
          int sum = x*i + y*j + z*k;
          if (sum <= max && !sums[sum]) sums[sum] = true;
        }
      }
    }
    for (int i = max; i > 0; i--) {
      if (!sums[i]) return i;
    }
    return 0;
  }

  public static void makeCSV(int maxNug, int maxTested)
  {
    var hm = new HashMap<Integer,ArrayList<int[]>>();
    var factors = new int[]{2,3,5,7,11,13,17,19};
    for (int i = 3; i <= maxNug-2; i++) {
      System.out.print(i+", ");
      for (int j = i+1; j <= maxNug-1; j++) {
        for (int k = j+1; k <= maxNug; k++) {
          boolean notCoprime = true;
          for (int factor : factors) {
            if (i%factor==0 && j%factor==0 && k%factor==0) {
              notCoprime = false;
              break;
            }
          }
          if (notCoprime) {
            int max = greatestImpossible(i,j,k,maxTested);
            if (hm.get(max)==null) hm.put(max, new ArrayList<int[]>());
            hm.get(max).add(new int[]{max, i, j, k});
          }
        }
      }
    }
    var outToFile = new StringBuilder();
    for (int i : hm.keySet()){
      for (int[] triples : hm.get(i)) {
        outToFile.append(String.format("%d,%d,%d,%d%n", triples[0], triples[1], triples[2], triples[3]));
      }
    }
    try {
      FileWriter myWriter = new FileWriter("McNuggets.csv");
      myWriter.write(outToFile.toString());
      myWriter.close();
      System.out.println("success");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public static HashMap<Integer, ArrayList<int[]>> readCSV()
  {
    String csvFile = "McNuggets.csv";
    String line = "";
    HashMap<Integer, ArrayList<int[]>> impossibles =  new HashMap<>();
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        while ((line = br.readLine()) != null) {
            String[] vals = line.split(",");
            int key = Integer.parseInt(vals[0]);
            impossibles.putIfAbsent(key,new ArrayList<int[]>());
            impossibles.get(key).add(new int[]{ 
              Integer.parseInt(vals[1]), Integer.parseInt(vals[2]), Integer.parseInt(vals[3])
            });
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return impossibles;
  }
  public static void pprintCSV()
  {
    HashMap<Integer, ArrayList<int[]>> impossibles = readCSV();
    for (Integer i : impossibles.keySet()) {
      StringBuilder arrToStr = new StringBuilder();
      for (int[] triple : impossibles.get(i)) 
        arrToStr.append(String.format("[%d,%d,%d], ", triple[0], triple[1], triple[2]));
      System.out.printf("\t%d: [%s],%n", i, arrToStr.toString());
    }
  }
  public static void main(String[] args)
  {
    // makeCSV(60, 1000);
    // pprintCSV();
    HashMap<Integer, ArrayList<int[]>> impossibles = readCSV();
    HashMap<String, int[]> experiment = new HashMap<>();
    // "small-n,big-n" : [result,frequency]
    for (Integer impossible : impossibles.keySet()) {
      // 
      for (int[] triple : impossibles.get(impossible)) {
        for (int i = 0; i < 3; i++) {
        }
      }
      // 
    }
  }
}
