package com.company;

import java.util.ArrayList;

public class AdjacencyGraph {

    ArrayList<Vertex> Vertices;

    public AdjacencyGraph(){
        Vertices = new ArrayList<>();
    }

    public void addVertex(Vertex v){
        Vertices.add(v);
    }

    public void addEdge(Vertex from, Vertex to, Integer dist){

        if(!(Vertices.contains(from) && Vertices.contains(to)))

        {
            System.out.println("Vertices missing from graph");
            return;
        }

        Edge newE = new Edge(from, to, dist);
        Edge newE1 = new Edge(to, from, dist);

    }

    public void PrintGraph(){

        //Beskriver distancen mellem alle Vertex's Edges

        for(int i = 0; i < Vertices.size() ; i++){

            System.out.println("");
            System.out.println(""+Vertices.get(i).name+" is connected to: ");
            Vertex current=Vertices.get(i);

            for (Edge e: current.OutEdge) {

                System.out.println(e.to.name +" with distance: "+e.dist);
            }
        }
    }

        public void Prims() {

            //Prims algorithme aflæser alle de Vertex's der er, samt distancen mellem de forskellige edges.
            //Derudover udregner den også den korteste distance mellem alle Vertex's, altså et Minimum Spanning Tree.

            MinHeap<Vertex> Q = new MinHeap<>();
            ArrayList<Vertex> Cities = new ArrayList<>();

            if (Vertices.size() > 0) {
                Vertices.get(0).distance = 0;
            } else {
                return;
            }

            for (Vertex city : Vertices) {
                Q.Insert(city);
            }

            int MST = 0;

            Vertex minHeap;

            while (!Q.isEmpty()) {
                minHeap = Q.extractMin();
                Cities.add(minHeap);
                MST += minHeap.distance;

                for (Edge outEdge : minHeap.OutEdge) {

                    if (!Cities.contains(outEdge.to) && outEdge.dist < outEdge.to.distance) {

                        outEdge.to.distance = outEdge.dist;
                        outEdge.to.prev = minHeap;
                        int pos = Q.getPosition(outEdge.to);
                        Q.decreasekey(pos);
                    }
                }
            }

            System.out.println("");
            System.out.println("Minimum spanning tree distance: " +MST);

            for(int i = 1; i< Cities.size(); i++){
                System.out.println("From "+ Cities.get(i).prev.name + " to " + Cities.get(i).name +" Distance: "+ Cities.get(i).distance);
            }

            System.out.println("Price of the powergrid = " + (MST*1000000) + " Danish Crowns.");
        }
}

class Vertex implements Comparable<Vertex> {

    Integer distance=Integer.MAX_VALUE;

    Vertex prev=null;

    String name;

    ArrayList<Edge> OutEdge;

    public Vertex(String name){
        this.name=name;
        OutEdge=new ArrayList<>();
    }

    @Override
    public int compareTo(Vertex o) {
        return this.distance.compareTo(o.distance);
    }
}

class Edge{

    Vertex from;
    Vertex to;
    Integer dist;

    public Edge(Vertex from,Vertex to, Integer dist){

        this.from=from;
        this.to=to;
        this.dist=dist;

        from.OutEdge.add(this);
    }
}