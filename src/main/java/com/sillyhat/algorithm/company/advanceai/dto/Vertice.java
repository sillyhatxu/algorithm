package com.sillyhat.algorithm.company.advanceai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vertice {

    public Vertice(String vertex,int weight){
        this.vertex = vertex;
        this.weight = weight;
        this.maxLeafWeight = 0;
    }
    private String vertex;

    private int weight;

    private List<Vertice> connectionVertexList;

    private int maxLeafWeight;

    public void addConnectionVertice(Vertice vertice){
        if(connectionVertexList == null){
            connectionVertexList = new ArrayList<>();
        }
        connectionVertexList.add(vertice);
    }

    public boolean hasLeaf(){
        return connectionVertexList != null && !connectionVertexList.isEmpty();
    }


}
