package test;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.PositionalList;
import net.datastructures.Vertex;

public class PruebaVertices {

	public static void main(String[] args) {

		Graph<String, Integer> g = new AdjacencyMapGraph<>(false);

		Vertex<String> v1 = g.insertVertex("MAD");
		Vertex<String> v2 = g.insertVertex("TRE");
		Vertex<String> v3 = g.insertVertex("RAW");
		Vertex<String> v4 = g.insertVertex("ESQ");
		Vertex<String> v5 = g.insertVertex("COM");
		Vertex<String> v6 = g.insertVertex("SAR");

		Edge<Integer> a1 = g.insertEdge(v1, v2, 65);
		Edge<Integer> a2 = g.insertEdge(v1, v3, 70);
		Edge<Integer> a3 = g.insertEdge(v2, v3, 17);
		Edge<Integer> a4 = g.insertEdge(v2, v4, 619);
		Edge<Integer> a5 = g.insertEdge(v2, v5, 350);
		Edge<Integer> a6 = g.insertEdge(v5, v6, 155);
		Edge<Integer> a7 = g.insertEdge(v6, v4, 441);


		// Versión original de shortestPathLengths (Dijkstra)
		Map<Vertex<String>, Integer> res = GraphAlgorithms.shortestPathLengths(
				g, v1);

		System.out.println("shortestPathLengths");
		for (Vertex<String> result : res.keySet())
			System.out.println(result.getElement() + "  -->  "
					+ res.get(result));

		// Versión modificada de shortestPathLengths (Dijkstra)
		// Retorna todos los vértices por donde pasa.
		PositionalList<Vertex<String>> pl = GraphAlgorithms.shortestPathList(g, v1, v6);
		
		System.out.println("shortestPathLengths modificada - Dado dos vertices muestra por todos los vertices que pasa");
		for (Vertex<String> v: pl)
			System.out.println(v.getElement());	

	}
}
