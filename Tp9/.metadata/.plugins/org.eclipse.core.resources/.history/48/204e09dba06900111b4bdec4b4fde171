package test;

import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.Vertex;

public class Prueba {

	public static void main(String[] args) {

		Graph<String, Integer> g = new AdjacencyMapGraph<>(false);

		Vertex<String> v1 = g.insertVertex("1");
		Vertex<String> v2 = g.insertVertex("2");
		Vertex<String> v3 = g.insertVertex("3");
		Vertex<String> v4 = g.insertVertex("4");
		Vertex<String> v5 = g.insertVertex("5");
		Vertex<String> v6 = g.insertVertex("6");
		Vertex<String> v7 = g.insertVertex("7");

		Edge<Integer> a1 = g.insertEdge(v1, v2, 2);
		Edge<Integer> a2 = g.insertEdge(v1, v4, 1);
		Edge<Integer> a3 = g.insertEdge(v2, v4, 3);
		Edge<Integer> a4 = g.insertEdge(v2, v5, 10);
		Edge<Integer> a5 = g.insertEdge(v3, v1, 4);
		Edge<Integer> a6 = g.insertEdge(v3, v6, 6);
		Edge<Integer> a7 = g.insertEdge(v4, v3, 2);
		Edge<Integer> a8 = g.insertEdge(v4, v5, 2);
		Edge<Integer> a9 = g.insertEdge(v4, v6, 8);
		Edge<Integer> a10 = g.insertEdge(v4, v7, 4);
		Edge<Integer> a11 = g.insertEdge(v5, v7, 6);
		Edge<Integer> a12 = g.insertEdge(v7, v6, 1);

		System.out.println("Número de vértices: " + g.numVertices());
		System.out.println("Número de arcos: " + g.numEdges());

		for (Vertex<String> vert : g.vertices())
			System.out.println(vert.getElement());

		for (Edge<Integer> arc : g.edges())
			System.out.println(arc.getElement());

		System.out.println("Número de arcos salen del vertice V1: "
				+ g.outDegree(v1));
		System.out.println("Número de arcos llegan al vertice V4: "
				+ g.inDegree(v4));

		for (Edge<Integer> arc : g.outgoingEdges(v1))
			System.out.println("Arcos que salen de v1 " + arc.getElement());

		for (Edge<Integer> arc : g.incomingEdges(v4))
			System.out.println("Arcos que llegan a v4 " + arc.getElement());

		System.out
				.println("Vertice opuesto " + g.opposite(v5, a4).getElement());

		System.out.println("Arco entre el vertice V7 y V6 "
				+ g.getEdge(v7, v6).getElement());

		Vertex<String>[] vert = g.endVertices(a9);
		for (Vertex<String> a : vert)
			System.out
					.println("Vertices finales del arco a9 " + a.getElement());

	}
}
