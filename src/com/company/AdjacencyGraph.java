package com.company;
import java.util.ArrayList;

public class AdjacencyGraph {

    ArrayList<Vertex> Vertices;

    public AdjacencyGraph(){

        Vertices = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v){

        Vertices.add(v);
    }

    public void addEdge(Vertex from, Vertex to, Integer dist){

        if(!(Vertices.contains(from) && Vertices.contains(to))) {
            System.out.println("Vertices missing from graph");
            return;
        }

        Edge newE = new Edge(from, to, dist);
    }

    public void addUndirectedEdge(Vertex from, Vertex to, Integer dist){

        if(!(Vertices.contains(from) && Vertices.contains(to)))
        {
            System.out.println("Vertices missing from graph");
            return;
        }

        Edge newE0 = new Edge(from, to, dist);
        Edge newE1 = new Edge(to, from, dist);
    }

    public void PrintGraph(){

        for(int i=0; i<Vertices.size(); i++){

            System.out.println(" "+Vertices.get(i).name + " is connected to:");

            Vertex current = Vertices.get(i);

            for(Edge e: current.OutEdge){
                System.out.println(e.to.name + " with dist:" + e.dist);
            }
        }
    }
}

class Vertex {

    String name;
    ArrayList<Edge> OutEdge;

    public Vertex(String name){

        this.name = name;
        OutEdge = new ArrayList<Edge>();
    }
}

class Edge {

    Vertex from;
    Vertex to;
    Integer dist;

    public Edge(Vertex from, Vertex to, Integer dist){

        this.from = from;
        this.to = to;
        this.dist = dist;
        from.OutEdge.add(this);
    }
}