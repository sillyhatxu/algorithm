package com.sillyhat.algorithm.company.advanceai;

import com.sillyhat.algorithm.company.advanceai.dto.Vertice;

import java.util.HashSet;
import java.util.Set;

public class FindingOptimalPath {

    public static int getCyclicalMaxWeightSum(Vertice node, Set<String> selectNode){
        if(selectNode.contains(node.getVertex())){
            return 0;
        }
        selectNode.add(node.getVertex());
        if(!node.hasLeaf()){
            return node.getWeight();
        }
        if(node.getMaxLeafWeight() != 0){
            return node.getMaxLeafWeight();
        }
        int maxLeafWeight = 0;
        for (Vertice leaf : node.getConnectionVertexList()){
            int leafWeight = getCyclicalMaxWeightSum(leaf,selectNode);
            maxLeafWeight = Math.max(maxLeafWeight,leafWeight);
        }
        return node.getWeight() + maxLeafWeight;
    }
    public static int getAcyclicMaxWeightSum(Vertice node){
        if(node.hasLeaf()){
            if(node.getMaxLeafWeight() != 0){
                return node.getMaxLeafWeight();
            }
            int maxLeafWeight = 0;
            for (Vertice leaf : node.getConnectionVertexList()){
                int leafWeight = getAcyclicMaxWeightSum(leaf);
                maxLeafWeight = Math.max(maxLeafWeight,leafWeight);
            }
            return node.getWeight() + maxLeafWeight;
        }
        return node.getWeight();
    }


    public static void main(String[] args) {
        Vertice a = new Vertice("A",1);
        Vertice b = new Vertice("B",2);
        Vertice c = new Vertice("C",3);
        Vertice d = new Vertice("D",4);
        Vertice e = new Vertice("E",5);
        Vertice f = new Vertice("F",6);
        a.addConnectionVertice(b);
        a.addConnectionVertice(d);
        b.addConnectionVertice(d);
        b.addConnectionVertice(c);
        d.addConnectionVertice(c);
        d.addConnectionVertice(e);
        c.addConnectionVertice(e);
        c.addConnectionVertice(f);
        e.addConnectionVertice(f);
        System.out.println(getAcyclicMaxWeightSum(a));//O(n)

        Vertice g = new Vertice("G",7);
        f.addConnectionVertice(g);
        g.addConnectionVertice(a);
        System.out.println(getCyclicalMaxWeightSum(a,new HashSet<>()));//O(n)
    }
}