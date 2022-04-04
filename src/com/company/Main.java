package com.company;

// Det vi skal have gjort nu, er at skrive noter som disse, hvorend der er noget der skal forklares.
// Så de steder koden gør noget vigtigt, tænker jeg vi skriver noter der forklare hvad der sker under noten <3

public class Main {

    public static void main(String[] args) {

        AdjacencyGraph adjDirectedG = createDirectedAdj();
        adjDirectedG.PrintGraph();
        adjDirectedG.Prims();

    }

    public static AdjacencyGraph createDirectedAdj(){

        AdjacencyGraph newG = new AdjacencyGraph();

        Vertex Eskildstrup = new Vertex("Eskildstrup");
        Vertex Haslev = new Vertex("Haslev");
        Vertex Holbæk = new Vertex("Holbæk");
        Vertex Jægerspris = new Vertex("Jægerspris");
        Vertex Kalundborg = new Vertex("Kalundborg");
        Vertex Korsør = new Vertex("Korsør");
        Vertex Køge = new Vertex("Køge");
        Vertex Maribo = new Vertex("Maribo");
        Vertex Næstved = new Vertex("Næstved");
        Vertex Ringsted = new Vertex("Ringsted");
        Vertex Slagelse = new Vertex("Slagelse");
        Vertex NykøbingF = new Vertex("NykøbingF");
        Vertex Roskilde = new Vertex("Roskilde");
        Vertex Sorø = new Vertex("Sorø");
        Vertex Nakskov = new Vertex("Nakskov");
        Vertex Vordingborg = new Vertex("Vordingborg");

        newG.addVertex(Eskildstrup);
        newG.addVertex(Haslev);
        newG.addVertex(Holbæk);
        newG.addVertex(Jægerspris);
        newG.addVertex(Kalundborg);
        newG.addVertex(Korsør);
        newG.addVertex(Køge);
        newG.addVertex(Maribo);
        newG.addVertex(Næstved);
        newG.addVertex(Ringsted);
        newG.addVertex(Slagelse);
        newG.addVertex(NykøbingF);
        newG.addVertex(Roskilde);
        newG.addVertex(Sorø);
        newG.addVertex(Nakskov);
        newG.addVertex(Vordingborg);

        newG.addEdge(Eskildstrup,Maribo,28);
        newG.addEdge(Eskildstrup,NykøbingF,13);
        newG.addEdge(Eskildstrup,Vordingborg, 24);
        newG.addEdge(Haslev,Korsør,60);
        newG.addEdge(Haslev,Køge,24);
        newG.addEdge(Haslev,Næstved,25);
        newG.addEdge(Haslev,Ringsted,19);
        newG.addEdge(Haslev,Roskilde,47);
        newG.addEdge(Haslev,Slagelse,48);
        newG.addEdge(Haslev,Sorø,34);
        newG.addEdge(Haslev,Vordingborg,40);
        newG.addEdge(Holbæk,Jægerspris,34);
        newG.addEdge(Holbæk,Kalundborg,44);
        newG.addEdge(Holbæk,Korsør,66);
        newG.addEdge(Holbæk,Ringsted,36);
        newG.addEdge(Holbæk,Roskilde,32);
        newG.addEdge(Holbæk,Slagelse,46);
        newG.addEdge(Holbæk,Sorø,34);
        newG.addEdge(Jægerspris,Korsør,95);
        newG.addEdge(Jægerspris,Køge,58);
        newG.addEdge(Jægerspris,Ringsted,56);
        newG.addEdge(Jægerspris,Roskilde,33);
        newG.addEdge(Jægerspris,Slagelse,74);
        newG.addEdge(Jægerspris,Sorø,63);
        newG.addEdge(Kalundborg,Ringsted,62);
        newG.addEdge(Kalundborg,Roskilde,70);
        newG.addEdge(Kalundborg,Slagelse,39);
        newG.addEdge(Kalundborg,Sorø,51);
        newG.addEdge(Korsør,Næstved,45);
        newG.addEdge(Korsør,Slagelse,20);
        newG.addEdge(Køge,Næstved,45);
        newG.addEdge(Køge,Ringsted,28);
        newG.addEdge(Køge,Roskilde,25);
        newG.addEdge(Køge,Vordingborg,60);
        newG.addEdge(Maribo,Nakskov,27);
        newG.addEdge(Maribo,NykøbingF,26);
        newG.addEdge(Næstved,Roskilde,57);
        newG.addEdge(Næstved,Ringsted,26);
        newG.addEdge(Næstved,Slagelse,37);
        newG.addEdge(Næstved,Sorø,32);
        newG.addEdge(Næstved,Vordingborg,28);
        newG.addEdge(Ringsted,Roskilde,31);
        newG.addEdge(Ringsted,Sorø,15);
        newG.addEdge(Ringsted,Vordingborg,58);
        newG.addEdge(Slagelse,Sorø,14);

        return newG;
    }
}