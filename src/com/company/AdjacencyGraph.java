package com.company;

//Vi skal ikke have knude S med, vi skal lave en tilfældig knude (Fra den kode vi har fået fra lektionen i dag)
//Vi skal bare lave Prims Algorithme inde her i Adjacency Graph
//Det er ligegyldigt hvilken knude man starter på, i Prims Algorithme

import java.util.ArrayList;
import java.util.Stack;

public class AdjacencyGraph {

    ArrayList<Vertex> Vertices;

    public AdjacencyGraph(){
        Vertices=new ArrayList<Vertex>();
    }

    public void addVertex(Vertex v){
        Vertices.add(v);
    }

    public void addEdge(Vertex from, Vertex to, Integer weight){

        if(!(Vertices.contains(from) && Vertices.contains(to)))

        {
            System.out.println("Vertices missing from graph");
            return;
        }

        Edge newE=new Edge(from, to, weight);

    }

    public void addUnDirectedEdge(Vertex from, Vertex to, Integer weight){

        if(!(Vertices.contains(from) && Vertices.contains(to))){

            System.out.println("Vertices missing from graph");
            return;

        }

        Edge newE=new Edge(from, to, weight);
        Edge newE2=new Edge( to, from, weight);

    }

    public void PrintGraph(){

        for(int i=0;i<Vertices.size();i++){

            System.out.println("");
            System.out.println(""+Vertices.get(i).name+" is connecte to: ");
            Vertex current=Vertices.get(i);

            for (Edge e: current.OutEdge) {

                System.out.println(e.to.name +" with weight: "+e.weight);
            }
        }
    }

    //Denne del skal skrives om til at være Prims Algorithme og fyldes ud de steder der mangler ting
    public void Prims (){

        MinHeap<Vertex> T = new MinHeap<>();

        for (int i=0;i<Vertices.size();i++){
            T.Insert(Vertices.get(i));
        }

        if(Vertices.size()>0){
            Vertices.get(0).distance=0;
            int pos = T.getPosition(Vertices.get(0));
            T.decreasekey(pos);
        }

        while (!T.isEmpty()){
            Vertex u=T.extractMin();

        }
    }

    public void PrintPath(Vertex Tovertex){

        Vertex pv=Tovertex;

        System.out.println("Distance to: "+Tovertex.name+" shortest path distance: "+Tovertex.distance);

        Stack<Vertex> path=new Stack<>();

        int plenght=0;

        while (pv!=null){
            path.push(pv);
            pv=pv.prev;
        }

        if(!path.isEmpty())
            plenght=path.size();

        for(int i =0 ;i<plenght-1;i++){
            System.out.print(path.pop().name + "-> ");
        }

        if (plenght>0){
            System.out.print(path.pop().name);
        }
    }

}

class Vertex implements Comparable<Vertex>{

    Integer distance=Integer.MAX_VALUE;

    Vertex prev=null;

    boolean visited=false;

    String name;

    ArrayList<Edge> OutEdge;

    public Vertex(String name){
        this.name=name;
        OutEdge=new ArrayList<Edge>();
    }

    @Override
    public int compareTo(Vertex o) {
        return this.distance.compareTo(o.distance);
    }
}

class Edge{

    Vertex from;
    Vertex to;
    Integer weight;

    public Edge(Vertex from,Vertex to, Integer weight){

        this.from=from;
        this.to=to;
        this.weight=weight;

        from.OutEdge.add(this);
    }
}