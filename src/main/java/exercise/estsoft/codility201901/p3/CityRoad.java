package exercise.estsoft.codility201901.p3;

class City {
    private int index;
    private City directCityToCapital;
    private boolean isCapital;

    City(int index) {
        this.index = index;
        isCapital = false;
    }

    public int getIndex() {
        return index;
    }

    City getDirectCityToCapital() {
        return directCityToCapital;
    }

    void setDirectCityToCapital(City directCityToCapital) {
        this.directCityToCapital = directCityToCapital;
    }

    boolean isCapital() {
        return isCapital;
    }

    void setCapital(boolean capital) {
        isCapital = capital;
    }
}

class Graph {
    private City[] cities;
    private int[] distances;

    Graph(int[] T) {
        distances = new int[T.length - 1];
        addCities(T);
        setDirectCityToCapital(T);
    }

    private void addCities(int[] T) {
        cities = new City[T.length];
        for (int i = 0; i < T.length; i++) {
            cities[i] = new City(i);
        }
    }

    private void setDirectCityToCapital(int[] T) {
        for (int i = 0; i < T.length; i++) {
            if (i == T[i]) {
                cities[i].setCapital(true);
            }
            cities[i].setDirectCityToCapital(cities[T[i]]);
        }
    }

    private int calcDistances(City city, int distance) {
        if (city.getDirectCityToCapital().isCapital()) {
            return distance;
        } else {
            return calcDistances(city.getDirectCityToCapital(), distance + 1);
        }
    }

    int[] calcDistances() {
        for (City city : cities) {
            if (!city.isCapital()) {
                int distance = calcDistances(city, 0);
                distances[distance]++;
            }
        }

        return distances;
    }
}

class Solution {
    public int[] solution(int[] T) {
        Graph graph = new Graph(T);
        return graph.calcDistances();
    }
}

public class CityRoad {
    public static void main(String[] args) {
        int[] T = new int[10];
        T[0] = 9;
        T[1] = 1;
        T[2] = 4;
        T[3] = 9;
        T[4] = 0;
        T[5] = 4;
        T[6] = 8;
        T[7] = 9;
        T[8] = 0;
        T[9] = 1;

        Solution solution = new Solution();
        int[] result = solution.solution(T);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
