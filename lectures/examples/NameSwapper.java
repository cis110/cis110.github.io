public class NameSwapper {
  public static void main(String[] args) {
    String[] names = { "Jules", "Michael", "Gian", "Ben" };
    System.out.println("ORIGINAL ARRAY:");
    for (int i = 0; i < names.length; i++) {
      System.out.print(names[i] + ", ");
    }
    swapNames("Michael", "Ben", names);
    System.out.println("SWAPPED ARRAY:");
    for (int i = 0; i < names.length; i++) {
      System.out.print(names[i] + ", ");
    }
  }

  public static void swapNames(String first, String second, String[] names) {
    // TODO: Find the first name's index
    int firstIndex = indexOfName(first, names);

    // TODO: Find the second name's index
    int secondIndex = indexOfName(second, names);

    // TODO: Swap the names!
    swapAtIndices(firstIndex, secondIndex, names);

  }

  public static int indexOfName(String name, String[] nameArr) {
    for (int i = 0; i < nameArr.length; i++) {
      if (name.equals(nameArr[i])) {
        return i;
      }
    }
    return -1;
  }

  public static void swapAtIndices(int i, int j, String[] arr) {
    String temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}