package org.eda1.examenSegundoParcialGrupoA.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;

import org.eda1.estructurasdedatos.ALStack;
import org.eda1.estructurasdedatos.Graph;
import org.eda1.estructurasdedatos.LinkedQueue;

public class Network<Vertex> implements Graph<Vertex>, Iterable<Vertex> {

	protected boolean directed; // directed = false (unDirected), directed =
								// true (DiGraph)

	protected TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;

	protected TreeMap<Vertex, Boolean> visited;

	protected ArrayList<Vertex> result;

	protected ArrayList<ArrayList<Vertex>> resultSimplePaths;

	Double shortestPathWeight;
	protected ArrayList<Vertex> resultShortestPath;

	int largestLengthPath;
	protected ArrayList<Vertex> resultLargestLengthPath;

	int numberOfSimplePaths, sumOfLengthOfSimplePaths;

	/**
	 * Initialized this Network object to be empty.
	 */
	public Network() {
		directed = true;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	} // default constructor

	public Network(boolean uDOrD) {
		directed = uDOrD;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	} // default constructor

	/**
	 * Initializes this Network object to a shallow copy of a specified Network
	 * object. The averageTime(V, E) is O(V + E).
	 * 
	 * @param network
	 *            - the Network object that this Network object is initialized
	 *            to a shallow copy of.
	 * 
	 */
	public Network(Network<Vertex> network) {
		this.directed = network.directed;
		this.adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>(
				network.adjacencyMap);
	} // copy constructor

	public void setDirected(boolean uDOrD) {
		directed = uDOrD;
	}

	public boolean getDirected() {
		return directed;
	}

	/**
	 * Determines if this Network object contains no vertices.
	 * 
	 * @return true - if this Network object contains no vertices.
	 * 
	 */
	public boolean isEmpty() {
		return adjacencyMap.isEmpty();
	} // method isEmpty

	/**
	 * Determines the number of vertices in this Network object.
	 * 
	 * @return the number of vertices in this Network object.
	 * 
	 */
	public int numberOfVertices() {
		return adjacencyMap.size();
	} // method size

	/**
	 * Returns the number of edges in this Network object. The averageTime (V,
	 * E) is O (V).
	 * 
	 * @return the number of edges in this Network object.
	 * 
	 */
	public int numberOfEdges() {
		int count = 0;
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> entry : adjacencyMap
				.entrySet())
			count += entry.getValue().size();
		if (!directed)
			return count / 2;
		return count;
	} // method getEdgeCount

	public void clear() {
		adjacencyMap.clear();
	}

	public double getWeight(Vertex v1, Vertex v2) {
		if (!(adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(
				v2)))
			return -1.0;

		return adjacencyMap.get(v1).get(v2);
	} // method getWeight

	public double setWeight(Vertex v1, Vertex v2, double w) {
		if (!(adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(
				v2)))
			return -1.0;

		TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(v1);
		double oldWeight = neighborMap.get(v2);
		adjacencyMap.get(v1).put(v2, w);
		return oldWeight;
	}

	/**
	 * Determines if this Network object contains a specified Vertex object.
	 * 
	 * @param vertex
	 *            - the Vertex object whose presence is sought.
	 * 
	 * @return true - if vertex is an element of this Network object.
	 */
	public boolean containsVertex(Vertex vertex) {
		return adjacencyMap.containsKey(vertex);
	} // method containsVertex

	/**
	 * Determines if this Network object contains an edge specified by two
	 * vertices. The averageTime (V, E) is O (E / V).
	 * 
	 * @param v1
	 *            - the beginning Vertex object of the edge sought.
	 * @param v2
	 *            - the ending Vertex object of the edge sought.
	 * 
	 * @return true - if this Network object contains the edge <v1, v2>.
	 * 
	 */
	public boolean containsEdge(Vertex v1, Vertex v2) {
		if (adjacencyMap.containsKey(v1)
				&& adjacencyMap.get(v1).containsKey(v2))
			return true;
		else
			return false;
	} // method containsEdge

	/**
	 * Ensures that a specified Vertex object is an element of this Network
	 * object.
	 * 
	 * @param vertex
	 *            - the Vertex object whose presence is ensured.
	 * 
	 * @return true - if vertex was added to this Network object by this call;
	 *         returns false if vertex was already an element of this Network
	 *         object when this call was made.
	 */
	public boolean addVertex(Vertex vertex) {
		if (adjacencyMap.containsKey(vertex))
			return false;
		adjacencyMap.put(vertex, new TreeMap<Vertex, Double>());
		return true;
	} // method addVertex

	/**
	 * Ensures that an edge is in this Network object.
	 * 
	 * @param v1
	 *            - the beginning Vertex object of the edge whose presence is
	 *            ensured.
	 * @param v2
	 *            - the ending Vertex object of the edge whose presence is
	 *            ensured.
	 * @param weight
	 *            - the weight of the edge whose presence is ensured.
	 * 
	 * @return true - if the given edge (and weight) were added to this Network
	 *         object by this call; return false, if the given edge (and weight)
	 *         were already in this Network object when this call was made.
	 * 
	 */
	public boolean addEdge(Vertex v1, Vertex v2, double w) {
		addVertex(v1);
		addVertex(v2);
		adjacencyMap.get(v1).put(v2, w);
		if (!directed)
			adjacencyMap.get(v2).put(v1, w);
		return true;
	} // method addEdge

	/**
	 * Ensures that a specified Vertex object is not an element of this Network
	 * object. The averageTime (V, E) is O (V + E).
	 * 
	 * @param vertex
	 *            - the Vertex object whose absence is ensured.
	 * 
	 * @return true - if vertex was removed from this Network object by this
	 *         call; returns false if vertex was not an element of this Network
	 *         object when this call was made.
	 * 
	 */
	public boolean removeVertex(Vertex vertex) {
		if (!adjacencyMap.containsKey(vertex))
			return false;

		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> entry : adjacencyMap
				.entrySet()) {
			TreeMap<Vertex, Double> neighborMap = entry.getValue();
			neighborMap.remove(vertex);
		} // for each vertex in the network
		adjacencyMap.remove(vertex);
		return true;
	} // removeVertex

	/**
	 * Ensures that an edge specified by two vertices is absent from this
	 * Network object. The averageTime (V, E) is O (E / V).
	 * 
	 * @param v1
	 *            - the beginning Vertex object of the edge whose absence is
	 *            ensured.
	 * @param v2
	 *            - the ending Vertex object of the edge whose absence is
	 *            ensured.
	 * 
	 * @return true - if the edge <v1, v2> was removed from this Network object
	 *         by this call; return false if the edge <v1, v2> was not in this
	 *         Network object when this call was made.
	 * 
	 */
	public boolean removeEdge(Vertex v1, Vertex v2) {
		if (!adjacencyMap.containsKey(v1)
				|| !adjacencyMap.get(v1).containsKey(v2))
			return false;

		TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(v1);
		neighborMap.remove(v2);
		if (!directed) {
			TreeMap<Vertex, Double> neighborMapV2 = adjacencyMap.get(v2);
			neighborMapV2.remove(v1);
		}
		return true;
	} // method removeEdge

	public Set<Vertex> vertexSet() {
		return adjacencyMap.keySet();
	}

	public Set<Vertex> getNeighbors(Vertex v) {
		TreeSet<Vertex> neighbors = new TreeSet<Vertex>();
		if (adjacencyMap.containsKey(v)) {
			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(v);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				neighbors.add(entry.getKey());
			}
		}
		return neighbors;
	}

	/**
	 * Returns a String representation of this Network object. The
	 * averageTime(V, E) is O(V + E).
	 * 
	 * @return a String representation of this Network object.
	 * 
	 */
	public String toString() {
		return adjacencyMap.toString();
	} // method toString

	/**
	 * grado de entrada, es decir, numero de aristas que tienen como destino el
	 * vertice v
	 */
	public int inDegree(Vertex v) {
		int cont = 0;
		for (Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap.entrySet()) {
			if (e.getValue().get(v) != null)
				cont++;
		}
		return cont;
	}

	/**
	 * grado de salida, es decir, numero de aristas que tienen como origen el
	 * vertice v
	 */
	public int outDegree(Vertex v) {
		return adjacencyMap.get(v).size();
	}

	/**
	 * Builds a graph whose vertices are strings by reading the vertices and
	 * edges from the textfile <tt>filename</tt>. The format of the file is
	 * <code>
	 *     nVertices
	 *     vertex_1 vertex_2 ...vertex_n
	 *     nEdges
	 *     vertex_i vertex_j weight
	 *     . . .  </code> ...
	 * 
	 * @param filename
	 *            name of the text file with vertex and edge specifications.
	 * @return <tt>DiGraph</tt> object with generic type String.
	 */
	public static Network<String> readNetwork(String filename)
			throws FileNotFoundException {
		// type of Graph
		int typeOfGraph;
		// nVertices is number of vertices to read
		int i, nVertices, nEdges;
		// use for input of vertices (v1) and edges ( {v1, v2} )
		String v1, v2;
		// edge weight
		double weight;
		Network<String> net = new Network<String>();

		try {
			Scanner f = new Scanner(new File(filename));
			typeOfGraph = Integer.parseInt(f.nextLine());
			net.directed = (typeOfGraph == 1);
			nVertices = Integer.parseInt(f.nextLine());
			for (i = 0; i < nVertices; i++) {
				v1 = f.nextLine();
				net.addVertex(v1);
			}
			nEdges = Integer.parseInt(f.nextLine());
			for (i = 0; i < nEdges; i++) {
				Scanner linea = new Scanner(f.nextLine());
				v1 = linea.next();
				v2 = linea.next();
				weight = Double.parseDouble(linea.next());
				net.addEdge(v1, v2, weight);
				if (!net.directed)
					net.addEdge(v2, v1, weight);
				linea.close();
			}
			f.close();
		} catch (Exception e) {
			System.out.println("Error en la lectura del fichero");
		}
		return net;
	}

	public void showNetwork() {
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap
				.entrySet()) {
			TreeMap<Vertex, Double> neighborMap = e1.getValue();
			for (Map.Entry<Vertex, Double> e2 : neighborMap.entrySet()) {
				System.out.println(e1.getKey() + " " + e2.getKey() + " "
						+ e2.getValue());
			}
		}
	}

	public boolean isReachable(Vertex source, Vertex destination) {
		visited = new TreeMap<Vertex, Boolean>();
		for (Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap.entrySet()) {
			visited.put(e.getKey(), false);
		}
		return isReachableAux(source, destination);
	}

	private boolean isReachableAux(Vertex current, Vertex destination) {
		/*
		 * if (current.equals(destination)) return true; if
		 * (visited.get(current)) return false; visited.put(current, true); for
		 * (Entry<Vertex, Double> e : adjacencyMap.get(current).entrySet()) { if
		 * (isReachableAux (e.getKey(), destination)) return true; } return
		 * false;
		 */
		if (current.equals(destination))
			return true;
		visited.put(current, true);
		for (Entry<Vertex, Double> e : adjacencyMap.get(current).entrySet()) {
			if (!visited.get(e.getKey())) {
				if (isReachableAux(e.getKey(), destination))
					return true;
			}
		}
		return false;
	}

	public boolean isSource(Vertex v) {
		if (inDegree(v) == 0 && outDegree(v) != 0)
			return true;
		return false;
	}

	public boolean isSink(Vertex v) {
		if (inDegree(v) != 0 && outDegree(v) == 0)
			return true;
		return false;
	}

	public ArrayList<ArrayList<Vertex>> simplePaths(Vertex source,
			Vertex destination) {
		result = new ArrayList<Vertex>();
		resultSimplePaths = new ArrayList<ArrayList<Vertex>>();
		simplePathsAux(source, destination);
		return resultSimplePaths;
	}

	private void simplePathsAux(Vertex current, Vertex destination) {
		if (result.contains(current))
			return;
		result.add(current);
		if (current.equals(destination)) {
			resultSimplePaths.add((ArrayList<Vertex>) result.clone());
			result.remove(result.size() - 1);
			return;
		}
		for (Entry<Vertex, Double> e : adjacencyMap.get(current).entrySet()) {
			simplePathsAux(e.getKey(), destination);
		}
		result.remove(result.size() - 1);
	}

	public ArrayList<Vertex> toArrayDFS(Vertex start) {
		result = new ArrayList<Vertex>();
		visited = new TreeMap<Vertex, Boolean>();

		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> v : adjacencyMap
				.entrySet()) {
			visited.put(v.getKey(), false);
		}
		toArrayDFSAux(start);
		return result;
	}

	private void toArrayDFSAux(Vertex current) {
		visited.put(current, true);
		result.add(current);
		for (Map.Entry<Vertex, Double> w : adjacencyMap.get(current).entrySet()) {
			if (visited.get(w.getKey()) == false)
				toArrayDFSAux(w.getKey());
		}
	}

	public ArrayList<Vertex> toArrayDFSIterative(Vertex start) {
		DepthFirstIterator it = depthFirstIterator(start);
		result = new ArrayList<Vertex>();
		while (it.hasNext()) {
			Vertex v = it.next();
			result.add(v);
		}
		return result;
	}

	public ArrayList<Vertex> toArrayBFS(Vertex start) {
		BreadthFirstIterator it = breadthFirstIterator(start);
		result = new ArrayList<Vertex>();
		while (it.hasNext()) {
			Vertex v = it.next();
			result.add(v);
		}
		return result;
	}

	public String shortestPathWithSimplePaths(Vertex source, Vertex destination) {

		shortestPathWeight = Double.MAX_VALUE;
		resultShortestPath = null;
		result = new ArrayList<Vertex>();
		shortestPathWithSimplePathsAux(source, destination);
		// cuando termino las llamadas recursivas, creo la cadena
		String cadena = "The shortest path using the simple paths algorithm from "
				+ source + " to " + destination + " is:\n";
		for (int i = 0; i < resultShortestPath.size(); i++) {
			cadena = cadena + resultShortestPath.get(i);
			if (i < resultShortestPath.size() - 1)
				cadena = cadena + " --> ";
		}
		cadena = cadena + " => (" + shortestPathWeight + ")";
		return cadena;
	}

	private void shortestPathWithSimplePathsAux(Vertex current,
			Vertex destination) {
		if (result.contains(current))
			return;
		result.add(current);
		if (current.equals(destination)) {
			// calculo el peso de mi result
			Double total = 0.0;
			for (int i = 0; i < result.size() - 1; i++) {
				total = total + getWeight(result.get(i), result.get(i + 1));
			}
			// si ese total es menor que el camino minimo, cambio el minimo
			if (total < shortestPathWeight) {
				resultShortestPath = (ArrayList<Vertex>) result.clone();
				shortestPathWeight = total;
			}
			result.remove(result.size() - 1);
			return;
		}
		for (Entry<Vertex, Double> e : adjacencyMap.get(current).entrySet()) {
			shortestPathWithSimplePathsAux(e.getKey(), destination);
		}
		result.remove(result.size() - 1);
	}

	public String largestLenghtPathWithSimplePaths(Vertex source,
			Vertex destination) {
		largestLengthPath = Integer.MIN_VALUE;
		resultLargestLengthPath = null;
		result = new ArrayList<Vertex>();
		numberOfSimplePaths = 0;
		sumOfLengthOfSimplePaths = 0;
		largestLenghtPathWithSimplePathsAux(source, destination);
		// cuando termino las llamadas recursivas, creo la cadena
		String cadena = "The largest length path using the simple paths algorithm from "
				+ source + " to " + destination + " is:\n";
		for (int i = 0; i < resultLargestLengthPath.size(); i++) {
			cadena = cadena + resultLargestLengthPath.get(i);
			if (i < resultLargestLengthPath.size() - 1)
				cadena = cadena + " --> ";
		}
		cadena = cadena + " => (" + largestLengthPath + ")";
		double media = (double) sumOfLengthOfSimplePaths / numberOfSimplePaths;
		cadena = cadena + "\nThe average length of the simple paths from "
				+ source + " to " + destination + " is: "
				+ String.format(Locale.ENGLISH, "%4.2f", media);
		return cadena;
	}

	private void largestLenghtPathWithSimplePathsAux(Vertex current,
			Vertex destination) {
		if (result.contains(current))
			return;
		result.add(current);
		if (current.equals(destination)) {
			// calculo el peso de mi result
			Integer total = result.size() - 1;
			// si ese total es menor que el camino minimo, cambio el minimo
			if (total > largestLengthPath) {
				resultLargestLengthPath = (ArrayList<Vertex>) result.clone();
				largestLengthPath = total;
			}
			result.remove(result.size() - 1);
			numberOfSimplePaths++;
			sumOfLengthOfSimplePaths = sumOfLengthOfSimplePaths + total;
			return;
		}
		for (Entry<Vertex, Double> e : adjacencyMap.get(current).entrySet()) {
			largestLenghtPathWithSimplePathsAux(e.getKey(), destination);
		}
		result.remove(result.size() - 1);
	}

	public boolean isPathLength(Vertex source, Vertex destination,
			Integer length) {
		simplePaths(source, destination);
		for (ArrayList<Vertex> l : resultSimplePaths) {
			if (l.size() - 1 == length)
				return true;
		}
		return false;
	}

	// Otras funciones adicionales
	public ArrayList<Object> Dijkstra(Vertex source, Vertex destination) {
		final double INFINITY = Double.MAX_VALUE;
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
		TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		Vertex vertex, to = null, from;
		if (source == null || destination == null)
			return new ArrayList<Object>();
		if (source.equals(destination))
			return new ArrayList<Object>();
		if (!(adjacencyMap.containsKey(source) && adjacencyMap
				.containsKey(destination)))
			return new ArrayList<Object>();
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet())
			if (!(source.equals(e.getKey())))
				V_minus_S.add(e.getKey());
		Iterator itr = V_minus_S.iterator();
		while (itr.hasNext()) {
			vertex = (Vertex) itr.next();
			if (containsEdge(source, vertex)) {
				S.put(vertex, source);
				D.put(vertex, getWeight(source, vertex));
			} else {
				S.put(vertex, null);
				D.put(vertex, INFINITY);
			}
		}
		S.put(source, source);
		D.put(source, 0.0);
		while (!V_minus_S.isEmpty()) {
			Double minWeight = INFINITY;
			from = null;
			Iterator itr1 = V_minus_S.iterator();
			while (itr1.hasNext()) {
				vertex = (Vertex) itr1.next();
				if (D.get(vertex) < minWeight) {
					minWeight = D.get(vertex);
					from = vertex;
				}
			}
			if (!from.equals(null)) {
				V_minus_S.remove(from);
				Iterator itr2 = V_minus_S.iterator();
				while (itr2.hasNext()) {
					to = (Vertex) itr2.next();
					if (containsEdge(from, to)) {
						double weight = getWeight(from, to);
						if (D.get(from) + weight < D.get(to)) {
							D.put(to, D.get(from) + weight);
							S.put(to, from);
						}
					}
				}
			} else
				break;
		}
		ArrayList<Object> path = new ArrayList<Object>();
		ALStack<Vertex> st = new ALStack<Vertex>();
		if (S.get(destination).equals(null)) {
			System.out.println("The vertex " + destination
					+ " is not reachable from " + source);
			return path;
		} else {
			st.push(destination);
			while (!(st.peek().equals(source)))
				st.push(S.get(st.peek()));
			while (!(st.isEmpty())) {
				path.add(st.peek());
				st.pop();
			}
		}
		ArrayList<Object> edgePath = new ArrayList<Object>();
		for (int i = 0; (i < (path.size() - 1)); i++) {
			EdgeWeight edgeWeight = new EdgeWeight((Vertex) path.get(i),
					(Vertex) path.get(i + 1), getWeight((Vertex) path.get(i),
							(Vertex) path.get(i + 1)));
			edgePath.add(edgeWeight);
		}
		return edgePath;

	}

	public ArrayList<Object> DijkstraPQ(Vertex source, Vertex destination) {
		final double INFINITY = Double.MAX_VALUE;
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
		TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		PriorityQueue<VertexWeightPair> pQ;
		Vertex vertex, to = null, from;
		if (source == null || destination == null)
			return new ArrayList<Object>();
		if (source.equals(destination))
			return new ArrayList<Object>();
		if (!(adjacencyMap.containsKey(source) && adjacencyMap
				.containsKey(destination)))
			return new ArrayList<Object>();
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet())
			if (!(source.equals(e.getKey())))
				V_minus_S.add(e.getKey());
		Iterator itr = V_minus_S.iterator();
		while (itr.hasNext()) {
			vertex = (Vertex) itr.next();
			if (containsEdge(source, vertex)) {
				S.put(vertex, source);
				D.put(vertex, getWeight(source, vertex));
			} else {
				S.put(vertex, null);
				D.put(vertex, INFINITY);
			}
		}
		S.put(source, source);
		D.put(source, 0.0);
		while (!V_minus_S.isEmpty()) {
			Double minWeight = INFINITY;
			from = null;
			Iterator itr1 = V_minus_S.iterator();
			/*
			 * while (itr1.hasNext()) { vertex = (Vertex) itr1.next(); if
			 * (D.get(vertex) < minWeight) { minWeight = D.get(vertex); from =
			 * vertex; } }
			 */
			pQ = new PriorityQueue<VertexWeightPair>();
			while (itr1.hasNext()) {
				vertex = (Vertex) itr1.next();
				pQ.add(new VertexWeightPair(vertex, D.get(vertex)));
			}
			VertexWeightPair vwp = pQ.poll();
			minWeight = vwp.getWeight();
			from = vwp.getVertex();
			if (!from.equals(null)) {
				V_minus_S.remove(from);
				Iterator itr2 = V_minus_S.iterator();
				while (itr2.hasNext()) {
					to = (Vertex) itr2.next();
					if (containsEdge(from, to)) {
						double weight = getWeight(from, to);
						if (D.get(from) + weight < D.get(to)) {
							D.put(to, D.get(from) + weight);
							S.put(to, from);
						}
					}
				}
			} else
				break;
		}
		ArrayList<Object> path = new ArrayList<Object>();
		ALStack<Vertex> st = new ALStack<Vertex>();
		if (S.get(destination).equals(null)) {
			System.out.println("The vertex " + destination
					+ " is not reachable from " + source);
			return path;
		} else {
			st.push(destination);
			while (!(st.peek().equals(source)))
				st.push(S.get(st.peek()));
			while (!(st.isEmpty())) {
				path.add(st.peek());
				st.pop();
			}
		}
		ArrayList<Object> edgePath = new ArrayList<Object>();
		for (int i = 0; (i < (path.size() - 1)); i++) {
			EdgeWeight edgeWeight = new EdgeWeight((Vertex) path.get(i),
					(Vertex) path.get(i + 1), getWeight((Vertex) path.get(i),
							(Vertex) path.get(i + 1)));
			edgePath.add(edgeWeight);
		}
		return edgePath;

	}

	public boolean isFloydGraph() {
		for (Entry<Vertex, TreeMap<Vertex,Double>> e1 : adjacencyMap.entrySet()) {
			for (Entry<Vertex,Double> e2 : e1.getValue().entrySet()) {
				if ( ! adjacencyMap.containsKey(e2.getKey()))
					return false;
			}
		}
		return true;
	}

	public void adaptToFloydGraph() {
		ArrayList<Vertex> noEstan = new ArrayList<Vertex> ();
		
		for (Entry<Vertex, TreeMap<Vertex,Double>> e1 : adjacencyMap.entrySet()) {
			for (Entry<Vertex,Double> e2 : e1.getValue().entrySet()) {
				if ( ! adjacencyMap.containsKey(e2.getKey()))
					noEstan.add(e2.getKey());
			}
		}
		for (Vertex v : noEstan) {
			if ( ! adjacencyMap.containsKey(v))
				adjacencyMap.put(v, new TreeMap<Vertex,Double> ());
		}
	}

	public String FloydEC() {
		final double INFINITY = Double.MAX_VALUE;
		double[][] D;
		int[][] A;
		TreeMap<Vertex, Integer> vtxIndex = new TreeMap<Vertex, Integer>();
		Vertex vertex, from, to;
		EdgeWeight edgeWeight;
		double weight;
		int i, j, k;
		int n = numberOfVertices();
		if (n <= 0)
			return "";
		D = new double[n][n];
		A = new int[n][n];
		int index = 0;
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet())
			vtxIndex.put(e.getKey(), index++);
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				D[i][j] = INFINITY;
				A[i][j] = -1;
			}
		}
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap
				.entrySet()) {
			TreeMap<Vertex, Double> neighborMap = e1.getValue();
			for (Map.Entry<Vertex, Double> e2 : neighborMap.entrySet()) {
				from = e1.getKey();
				to = e2.getKey();
				weight = e2.getValue();
				D[vtxIndex.get(from)][vtxIndex.get(to)] = weight;
			}
		}
		for (k = 0; (k < n); k++) {
			for (i = 0; (i < n); i++) {
				for (j = 0; (j < n); j++) {
					if ((D[i][k] < INFINITY) && (D[k][j] < INFINITY)) {
						if ((D[i][k] + D[k][j]) < D[i][j]) {
							D[i][j] = D[i][k] + D[k][j];
							A[i][j] = k;
						}
					}
				}
			}
		}
		String cadena = "";
		double v[] = new double [D.length];
		for (j=0; j<D.length; j++) {
			double max = Double.MIN_VALUE;
			for (i=0; i<D.length; i++) {
				if (D[i][j] != INFINITY && D[i][j] != 0.0) {
					if (D[i][j] > max)
						max = D[i][j];
				}
			}
			if (max == Double.MIN_VALUE)
				v[j] = -1;
			else
				v[j] = max;
		}
		cadena = cadena + "{";
		for (i=0; i<v.length; i++) {
			cadena = cadena + i + "=";
			if (v[i] == INFINITY || v[i] == 0.0)
				cadena = cadena + "-1.0";
			else
				cadena = cadena + String.format(Locale.ENGLISH, "%3.1f", v[i]);
			if (i < v.length-1)
				cadena = cadena + ", ";
		}
		cadena = cadena + "}; ";
		double min = Double.MAX_VALUE;
		int posmin = 0;
		for (i=0; i<v.length; i++) {
			if (v[i] != -1) {
				if (v[i] < min) {
					min = v[i];
					posmin = i;
				}
			}
		}
		cadena = cadena + "centro = "+posmin+"\n";
		cadena = cadena + "[";
		for (j=0; j<D.length; j++) {
			if (D[posmin][j] != -1 && D[posmin][j] != INFINITY) {
				cadena = cadena + "(" + posmin + ", " + j + ")=";
				cadena = cadena + String.format(Locale.ENGLISH, "%3.1f", D[posmin][j]);
				if (j < D.length-1)
					cadena = cadena + ", ";
			}
		}
		cadena = cadena + "]\n";
		return cadena;
	}

	public boolean isConnected() {
		for (Entry<Vertex, TreeMap<Vertex, Double>> e1 : adjacencyMap
				.entrySet()) {
			for (Entry<Vertex, TreeMap<Vertex, Double>> e2 : adjacencyMap
					.entrySet()) {
				if (!e1.getKey().equals(e2.getKey())) {
					if (!isReachable(e1.getKey(), e2.getKey()))
						return false;
				}
			}
		}
		return true;
	}

	public boolean isStronglyConnected() {
		int numVertices = numberOfVertices();
		int numEdges = numberOfEdges();
		if (numVertices * (numVertices - 1) / 2 == numEdges)
			return true;
		return false;
	}

	public boolean isTree() {
		if (directed)
			return false;
		if (!isConnected())
			return false;
		int numVertices = numberOfVertices();
		int numEdges = numberOfEdges();
		if (numVertices - 1 == numEdges)
			return true;
		return false;
	}

	public Iterator<Vertex> iterator() {
		return adjacencyMap.keySet().iterator();
	}

	public BreadthFirstIterator breadthFirstIterator(Vertex v) {
		if (!adjacencyMap.containsKey(v))
			return null;
		return new BreadthFirstIterator(v);
	}

	public DepthFirstIterator depthFirstIterator(Vertex v) {
		if (!adjacencyMap.containsKey(v))
			return null;
		return new DepthFirstIterator(v);
	}

	protected class BreadthFirstIterator implements Iterator<Vertex> {
		protected LinkedQueue<Vertex> queue;

		protected TreeMap<Vertex, Boolean> reached;

		protected Vertex current;

		public BreadthFirstIterator(Vertex start) {
			queue = new LinkedQueue<Vertex>();

			reached = new TreeMap<Vertex, Boolean>();

			Iterator<Vertex> itr = adjacencyMap.keySet().iterator();
			while (itr.hasNext())
				reached.put(itr.next(), false);

			queue.push(start);
			reached.put(start, true);
		}

		public boolean hasNext() {
			return !(queue.isEmpty());
		}

		public Vertex next() {
			Vertex to;

			current = queue.pop();

			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				to = entry.getKey();

				if (!reached.get(to)) {
					reached.put(to, true);
					queue.push(to);
				}
			}
			return current;
		}

		public void remove() {
			removeVertex(current);
		}

	}

	protected class DepthFirstIterator implements Iterator<Vertex> {
		ALStack<Vertex> stack;

		TreeMap<Vertex, Boolean> reached;

		Vertex current;

		public DepthFirstIterator(Vertex start) {
			stack = new ALStack<Vertex>();

			reached = new TreeMap<Vertex, Boolean>();

			Iterator<Vertex> itr = adjacencyMap.keySet().iterator();
			while (itr.hasNext())
				reached.put(itr.next(), false);

			stack.push(start);
			reached.put(start, true);
		}

		public boolean hasNext() {
			return !(stack.isEmpty());
		}

		public Vertex next() {
			Vertex to;

			current = stack.pop();

			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				to = entry.getKey();

				if (!reached.get(to)) {
					reached.put(to, true);
					stack.push(to);
				}
			}
			return current;
		}

		public void remove() {
			Network.this.removeVertex(current);
		}

	}

	protected class EdgeWeight implements Comparable<EdgeWeight> {
		Vertex from;
		Vertex to;
		double weight;

		/**
		 * Initializes this EdgeWeight from v1, v2 and weight.
		 */
		public EdgeWeight(Vertex from, Vertex to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		/**
		 * Returns the "from" vertex in this EdgeWeight.
		 */
		public Vertex getFromVertex() {
			return from;
		}

		/**
		 * Returns the "to" vertex in this EdgeWeight.
		 */
		public Vertex getToVertex() {
			return to;
		}

		/**
		 * Returns the weight vertex in this EdgeWeight.
		 */
		public double getWeight() {
			return weight;
		}

		/**
		 * Returns an int <, = or > 0, depending on whether this EdgeWeight's
		 * weight is <, = or > edge's weight.
		 */
		public int compareTo(EdgeWeight edge) {
			return (int) (weight - edge.weight);
		}

		@Override
		public boolean equals(Object obj) {
			EdgeWeight e = (EdgeWeight) obj;
			if ((from == e.from) && (to == e.to) && (weight == e.weight))
				return true;
			else
				return false;
		}

		/**
		 * Returns a String representation of this EdgeWeight.
		 */
		public String toString() {
			return "<" + from.toString() + ", " + to.toString() + "; "
					+ String.valueOf(weight) + ">";
		}

	}

	protected class VertexWeightPair implements Comparable<VertexWeightPair> {

		protected Vertex vertex;
		protected double weight;

		public VertexWeightPair(Vertex vertex, double weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public Vertex getVertex() {
			return vertex;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double w) {
			weight = w;
		}

		public int compareTo(VertexWeightPair other) {
			if (weight < other.weight)
				return -1;
			if (weight > other.weight)
				return 1;
			return 0;
		}

		public String toString() {
			return "<" + vertex + " ; " + weight + ">";
		}
	}

	public static Network<Vertice> createNetwork() {
		Network<Vertice> red = new Network<Vertice> (false);
		Vertice v1 = new Vertice ("Pueblo01", 28);
		Vertice v2 = new Vertice ("Pueblo02", 12);
		Vertice v3 = new Vertice ("Pueblo03", 24);
		Vertice v4 = new Vertice ("Pueblo04", 8);
		red.addVertex(v1);
		red.addVertex(v2);
		red.addVertex(v3);
		red.addVertex(v4);
		red.addEdge(v1, v2, 7);
		red.addEdge(v1, v3, 11);
		red.addEdge(v1, v4, 4);
		red.addEdge(v2, v3, 5);
		red.addEdge(v2, v4, 12);
		red.addEdge(v3, v4, 8);
		return red;
	}

	public TreeMap<Double, String> obtenerResultado() {
		TreeMap<Double, String> m = new TreeMap<Double, String> ();
		
		
		for (Vertex v1: adjacencyMap.keySet()) {
			Vertice puebloInicio = (Vertice) v1;

			Double costeDesplazamientoEducativo = 0.0;
			for (Vertex v2 : adjacencyMap.get(puebloInicio).keySet()) {
				Vertice puebloDestino = (Vertice) v2;

				costeDesplazamientoEducativo += this.adjacencyMap.get(
						puebloInicio).get(puebloDestino)
						* puebloDestino.getPoblacion();

			}

			m.put(costeDesplazamientoEducativo,
					puebloInicio.getPueblo());
		}

		return m;
	}

} // class Network
