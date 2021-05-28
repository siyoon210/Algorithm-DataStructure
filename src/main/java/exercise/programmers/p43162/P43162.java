package exercise.programmers.p43162;

import java.util.*;

class Computer {
    List<Computer> computers;
    int index;
    Computer root;
    
    Computer(List<Computer> computers, int index) {
        this.computers = computers;
        this.index = index;
        root = this;
    }
    
    public void union(Computer computer){
        if(root.index < computer.root.index) {
            Computer computerRoot = computer.find();
            computerRoot.root = computers.get(root.index);
            return;
        }
        
        if(computer.root.index < root.index) {
            Computer thisRoot = find();
            thisRoot.root = computers.get(computer.root.index);
            return;
        }
    }
    
    public Computer find() {
        if(root.index == index) {
            return this;
        }
        
        return computers.get(root.index).find();
    }
    
    public boolean isSameRoot(Computer computer) {
        return computer.find().index == find().index;
    }
}

class Solution {
    public int solution(int n, int[][] computersArray) {
        List<Computer> computers = initComputers(n);
        
        for(int i = 0; i < computersArray.length; i++) {
            for(int j =0; j < computersArray[i].length; j++){
                if(computersArray[i][j] == 0) {
                    continue;
                }
                
                Computer computer1 = computers.get(i);
                Computer computer2 = computers.get(j);
                
                if (computer1.isSameRoot(computer2)) {
                    continue;
                }
                
                computer1.union(computer2);
            }
        }
        
        Set<Integer> rootIndices = new HashSet<Integer>();
        
        for(Computer computer : computers) {
            rootIndices.add(computer.find().index);
        }
        
        return rootIndices.size();
    }
    
    private List<Computer> initComputers(int n) {
        List<Computer> computers = new ArrayList<Computer>(n);
        
        for(int i =0; i < n; i++) {
            computers.add(new Computer(computers, i));
        }
        
        return computers;
    }
}