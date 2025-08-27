public static ArrayList<ArrayList<int[]>> combinations(int[][] arr, int r) {
        ArrayList<ArrayList<int[]>> combinations = new ArrayList<>();
        int n = arr.length;
        int[] indices = new int[r];

        for (int i = 0; i < r; i ++)
            indices[i] = i;

        ArrayList<int[]> pair = new ArrayList<>();
        for (int i : indices) {
            pair.add(arr[i]);
        }
        combinations.add(pair);

        int lastI = 0;
        boolean broke;
        while (true) {
            broke = false;
            for (int i = r-1; i >= 0; i --) {
                lastI = i;
                if (indices[i] != i + n - r) {
                    broke = true;
                    break;
                }
            }
            if (!broke)
                return combinations;

            indices[lastI] ++;
            for (int i = lastI+1; i < r; i ++)
                indices[i] = indices[i-1] + 1;

            pair = new ArrayList<>();
            for (int i : indices) {
                pair.add(arr[i]);
            }
            combinations.add(pair);
        }