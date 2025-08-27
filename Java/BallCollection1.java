
/*
1. Creates a distance matrix between a set of balls
2. Calculates for each subset (not the entire set & starting from smallest -> biggest subset) of balls S and every ball
the shortest path from the start to e that collects every ball in S (but doesn't collect any other ball)
3. When the calculation is done for every subset, find the shortest path that collects every ball (answer)

Time Complexity: O(2^n * n^2)
 */

import java.io.*;
import java.util.*;

public class BallCollection1 {

    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(r.readLine());

        Pair[] locations = new Pair[N + 1];
        for (int i = 0; i < N + 1; i ++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            locations[i] = new Pair(x, y);
        }

        System.out.println(HeldKarp.findMinCost(N, locations));
    }
}

class Pair {
    private final int left;
    private final int right;

    public Pair(int a, int b) {
        this.left = a;
        this.right = b;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return left == pair.left && right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "(" + left +
                "," + right +
                ')';
    }
}

class HeldKarp {
    private static final int INFINITY = Integer.MAX_VALUE;

    private static class Index {
        private final int currentVertex; //ball to collect
        private final Set<Integer> vertexSet; //balls the rover has to collect before getting to the current ball to collect

        public Index(int currentVertex, Set<Integer> vertexSet) {
            this.currentVertex = currentVertex;
            this.vertexSet = vertexSet;
        }

        public int getCurrentVertex() {
            return currentVertex;
        }

        public Set<Integer> getVertexSet() {
            return vertexSet;
        }

        @Override
        public int hashCode() {
            return Objects.hash(currentVertex, vertexSet);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Index index = (Index) o;
            return currentVertex == index.currentVertex && Objects.equals(vertexSet, index.vertexSet);
        }

        @Override
        public String toString() {
            return "(" + currentVertex + "," + vertexSet + ")";
        }
    }

    private static class SetSizeComparator implements Comparator<Set<Integer>>{ //sort by size of set
        @Override
        public int compare(Set<Integer> o1, Set<Integer> o2) {
            return o1.size() - o2.size();
        }
    }

    public static double findMinCost(final int N, Pair[] locations) {
        //create a weighted adjacency matrix composed of distances between two balls
        double[][] distance = new double[N + 1][N + 1];
        for (int i = 0; i < N + 1; i ++) {
            for (int j = 0; j < N + 1; j ++) {
                distance[i][j] = euclideanDistance(locations[i].getLeft(), locations[j].getLeft(), locations[i].getRight(), locations[j].getRight());
            }
        }

        Map<Index, Integer> parent = new HashMap<>(); //
        Map<Index, Double> minCostDP = new HashMap<>(); //stores minimum cost it takes to get to a ball given the rover collects a set of balls

        List<Set<Integer>> allSets = generateCombinations(distance.length - 1);

        for(Set<Integer> set : allSets) {
            for(int currentVertex = 1; currentVertex < distance.length; currentVertex++) {
                if(set.contains(currentVertex)) {
                    continue;
                }
                Index index = new Index(currentVertex, set);
                double minCost = INFINITY;
                int minPrevVertex = 0;

                Set<Integer> tempSet = new HashSet<>(set);
                for(int prevVertex : set) {
                    double cost = distance[prevVertex][currentVertex] + getCost(tempSet, prevVertex, minCostDP);
                    if(cost < minCost) {
                        minCost = cost;
                        minPrevVertex = prevVertex;
                    }
                }
                if(set.size() == 0) { //for empty subset
                    minCost = distance[0][currentVertex];
                }
                minCostDP.put(index, minCost);
                parent.put(index, minPrevVertex);
            }
        }

        //Check which route is fastest
        double minDistance = INFINITY;
        Index minIndex = new Index(-1, new HashSet<>(0));
        for (Index index : minCostDP.keySet()) {
            if (index.getVertexSet().size() == distance.length - 2) {
                if (minCostDP.get(index) < minDistance) {
                    minDistance = minCostDP.get(index);
                    minIndex = index;
                }
            }
        }
        printRoute(parent, locations, minIndex);
        return minDistance;
    }

    public static double euclideanDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    private static void printRoute(Map<Index, Integer> parent, Pair[] locations, Index minIndex) { //prints answer in format
        Set<Integer> set = new HashSet<>(minIndex.vertexSet);

        Integer start = minIndex.getCurrentVertex();
        Deque<Integer> ansIndexes = new ArrayDeque<>();
        while(true) {
            ansIndexes.push(start);
            set.remove(start);
            start = parent.get(new Index(start, set));
            if(start == null) {
                break;
            }
        }

        ansIndexes.pop(); //get rid of 0 from the stack
        for (int index : ansIndexes) {
            System.out.println(locations[index].getLeft() + " " + locations[index].getRight());
        }
    }

    private static double getCost(Set<Integer> set, int prevVertex, Map<Index, Double> minCostDP) {
        set.remove(prevVertex);
        Index index = new Index(prevVertex, set);
        double cost = minCostDP.get(index);
        set.add(prevVertex);
        return cost;
    }

    private static List<Set<Integer>> generateCombinations(int n) {
        int[] input = new int[n];
        for(int i = 0; i < input.length; i ++) {
            input[i] = i + 1;
        }
        List<Set<Integer>> allSets = new ArrayList<>();
        int[] result = new int[input.length];
        generateCombination(input, 0, 0, allSets, result);
        allSets.sort(new SetSizeComparator());
        return allSets;
    }

    private static void generateCombination(int[] input, int start, int pos, List<Set<Integer>> allSets, int[] result) {
        if(pos == input.length) {
            return;
        }
        Set<Integer> set = createSet(result, pos);
        allSets.add(set);
        for(int i = start; i < input.length; i ++) {
            result[pos] = input[i];
            generateCombination(input, i + 1, pos + 1, allSets, result);
        }
    }

    private static Set<Integer> createSet(int[] input, int pos) {
        if(pos == 0) {
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < pos; i ++) {
            set.add(input[i]);
        }
        return set;
    }
}