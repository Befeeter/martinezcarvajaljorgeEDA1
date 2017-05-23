package org.eda1.examenSegundoParcial.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;

import org.eda1.estructurasdedatos.ALStack;
import org.eda1.estructurasdedatos.Graph;
import org.eda1.estructurasdedatos.LinkedQueue;

public class RoadNetwork<Vertex> implements Graph<Vertex>, Iterable<Vertex> {

	protected boolean directed; // directed = false (unDirected), directed =
								// true (DiGraph)

	protected TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;

	protected TreeMap<Vertex, Boolean> visited;

	protected ArrayList<Vertex> result;

	protected ArrayList<ArrayList<Vertex>> resultSimplePaths;

	Double shortestPathWeight;
	protected ArrayList<Vertex> resultShortestPath;

	Double largestPathWeight;
	protected ArrayList<Vertex> resultLargestPath;

	protected ArrayList<ArrayList<Object>> resultFloyd;
	ArrayList<Vertex> pathFloyd;

	/**
	 * Initialized this Network object to be empty.
	 */
	public RoadNetwork() {
		directed = true;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	}

	public RoadNetwork(boolean uDOrD) {
		directed = uDOrD;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	}

	/**
	 * Initializes this Network object to a shallow copy of a specified Network
	 * object. The averageTime(V, E) is O(V + E).
	 * 
	 * @param network
	 *            - the Network object that this Network object is initialized
	 *            to a shallow copy of.
	 * 
	 */
	public RoadNetwork(RoadNetwork<Vertex> network) {
		this.directed = network.directed;
		this.adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>(
				network.adjacencyMap);
	}

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
	}

	/**
	 * Determines the number of vertices in this Network object.
	 * 
	 * @return the number of vertices in this Network object.
	 * 
	 */
	public int numberOfVertices() {
		return adjacencyMap.size();
	}

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
		return count;
	}

	public void clear() {
		adjacencyMap.clear();
	}

	/**
	 * Determines the weight of an edge in this Network object. The averageTime
	 * (V, E) is O (E / V).
	 * 
	 * @param v1
	 *            - the beginning Vertex object of the edge whose weight is
	 *            sought.
	 * @param v2
	 *            - the ending Vertex object of the edge whose weight is sought.
	 * 
	 * @return the weight of edge <v1, v2>, if <v1, v2> forms an edge; return
	 *         –1.0 if <v1, v2> does not form an edge in this Network object.
	 * 
	 */
	public double getWeight(Vertex v1, Vertex v2) {
		if (!(adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(
				v2)))
			return -1.0;

		return adjacencyMap.get(v1).get(v2);
	}

	public double setWeight(Vertex v1, Vertex v2, double w) {
		if (!(adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(
				v2)))
			return -1.0;

		TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(v1);
		double oldWeight = neighborMap.get(v2);
		adjacencyMap.get(v1).put(v2, w);
		return oldWeight;
	}

	public boolean isAdjacent(Vertex v1, Vertex v2) {
		if ((adjacencyMap.containsKey(v1))
				&& (adjacencyMap.get(v1).containsKey(v2)))
			return true;
		else
			return false;
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
	}

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
	}

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
	}

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
	}

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
		}
		adjacencyMap.remove(vertex);
		return true;
	}

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
	}

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
	}

	public static RoadNetwork<String> readRoadNetwork(String filename)
			throws FileNotFoundException {
		// type of Graph
		int typeOfGraph;
		// nVertices is number of vertices to read
		int i, nVertices, nEdges;
		// use for input of vertices (v1) and edges ( {v1, v2} )
		String v1, v2;
		// edge weight
		double weight;

		RoadNetwork<String> net = new RoadNetwork<String>();

		try {
			Scanner f = new Scanner(new File(filename));
			typeOfGraph = Integer.parseInt(f.nextLine());
			if (typeOfGraph == 1)
				net.directed = true;
			else
				net.directed = false;
			nVertices = Integer.parseInt(f.nextLine());
			for (i = 0; i < nVertices; i++) {
				v1 = f.nextLine();
				net.addVertex(v1);
			}
			nEdges = Integer.parseInt(f.nextLine());
			for (i = 0; i < nEdges; i++) {
				Scanner l = new Scanner(f.nextLine());
				v1 = l.next();
				v2 = l.next();
				weight = l.nextDouble();
				net.addEdge(v1, v2, weight);
				if (!net.directed)
					net.addEdge(v2, v1, weight);
				l.close();
			}
			f.close();
		} catch (Exception e) {
			System.out.println("Error en la carga del fichero");
		}

		return net;
	}

	/**
	 * función que partiendo de una ciudad elegida por el usuario, muestre un
	 * recorrido en profundidad del grafo de carreteras.
	 * 
	 * @param start
	 * @return result
	 */
	public ArrayList<Vertex> toArrayDFS(Vertex start) {
		result = new ArrayList<Vertex>();
		visited = new TreeMap<Vertex, Boolean>();
		for (Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap.entrySet()) {
			visited.put(e.getKey(), false);
		}
		toArrayDFSAux(start);
		for (Entry<Vertex, Boolean> e1 : visited.entrySet()) {
			if (e1.getValue() == false)
				toArrayDFSAux(e1.getKey());
		}

		return result;
	}

	private void toArrayDFSAux(Vertex current) {
		visited.put(current, true);
		result.add(current);
		for (Entry<Vertex, Double> e : adjacencyMap.get(current).entrySet()) {
			if (visited.get(e.getKey()) == false)
				toArrayDFSAux(e.getKey());
		}
	}

	/**
	 * función que partiendo de una ciudad elegida por el usuario, muestre un
	 * recorrido en profundidad y otro en anchura del grafo de carreteras
	 * iterativamente.
	 * 
	 * @param start
	 * @return result
	 */
	public ArrayList<Vertex> toArrayDFSIterative(Vertex start) {
		result = new ArrayList<Vertex>();
		DepthFirstIterator it = depthFirstIterator(start);
		while (it.hasNext()) {
			Vertex v = it.next();
			result.add(v);
		}
		return result;
	}

	/**
	 * función que partiendo de una ciudad elegida por el usuario, muestre un
	 * recorrido en anchura del grafo de carreteras.
	 * 
	 * @param start
	 * @return result
	 */
	public ArrayList<Vertex> toArrayBFS(Vertex start) {
		result = new ArrayList<Vertex>();
		BreadthFirstIterator it = breadthFirstIterator(start);
		while (it.hasNext()) {
			Vertex v = it.next();
			result.add(v);
		}
		return result;
	}

	/**
	 * método que realice esta tarea (camino más corto entre dos ciudades dadas,
	 * utilizando el algoritmo de Dijkstra) para un par de ciudades cualquiera
	 * que decida el usuario.
	 * 
	 * @param source
	 * @param destination
	 * @return lista
	 */
	public ArrayList<Object> Dijkstra(Vertex source, Vertex destination) {
		ArrayList<Object> lista = new ArrayList<Object>();
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
		TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		Vertex to = null, from;
		if (source == null || destination == null) // Si el inicio o el destino
													// es nulo
			return new ArrayList<Object>();
		if (source.equals(destination)) // si el inicio es igual al destino
			return new ArrayList<Object>();
		if (!(adjacencyMap.containsKey(source) && adjacencyMap
				.containsKey(destination))) // Si dentro del M.Adyacencias no
											// tenemos el destino.
			return new ArrayList<Object>();
		for (Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap.entrySet()) {
			if (!(source.equals(e.getKey()))) {
				V_minus_S.add(e.getKey());
			}
		}

		Iterator it = V_minus_S.iterator();
		while (it.hasNext()) {
			Vertex v = (Vertex) it.next();
			if (isAdjacent(source, v)) {
				S.put(v, source);
				D.put(v, getWeight(source, v));
			} else {
				S.put(v, null);
				D.put(v, Double.MAX_VALUE);
			}
		}

		S.put(source, source);
		D.put(source, 0.0);

		while (!V_minus_S.isEmpty()) {
			Double minWeight = Double.MAX_VALUE;
			from = null;

			Iterator it3 = V_minus_S.iterator();
			while (it3.hasNext()) {
				Vertex v = (Vertex) it3.next();
				if (D.get(v) < minWeight) {
					minWeight = D.get(v);
					from = v;
				}
			}

			if (!from.equals(null)) {
				V_minus_S.remove(from);
				Iterator it2 = V_minus_S.iterator();
				while (it2.hasNext()) {

					to = (Vertex) it2.next();
					if (isAdjacent(from, to)) {
						Double weight = getWeight(from, to);
						if (D.get(from) + weight < D.get(to)) {
							D.put(to, (D.get(from) + weight));
							S.put(to, from);
						}

					}
				}
			} else
				break;
		}
		ALStack<Vertex> st = new ALStack<Vertex>();
		if (S.get(destination).equals(null)) {
			System.out.println("El vertice " + source
					+ " no es alcanzable por " + destination);
			return lista;
		} else {
			st.push(destination);
			while (!(st.peek().equals(source))) {
				st.push(S.get(st.peek()));
			}
			while (!(st.isEmpty())) {
				lista.add(st.pop());
			}

		}
		// llena el arrayList de tipo object en tipo EdgeWeight
		ArrayList<Object> edgePath = new ArrayList<Object>();
		for (int i = 0; (i < (lista.size() - 1)); i++) {
			EdgeWeight edgeWeight = new EdgeWeight((Vertex) lista.get(i),
					(Vertex) lista.get(i + 1), getWeight((Vertex) lista.get(i),
							(Vertex) lista.get(i + 1)));
			edgePath.add(edgeWeight);
		}
		return edgePath;
	}

	/**
	 * Muestra el recorrido de una ciudad inicio (source) a otra
	 * destino(destination) pasando por una situada en medio (middle).
	 * 
	 * @param source
	 * @param middle
	 * @param destination
	 * @return
	 */
	public String shortestPathSTD(Vertex source, Vertex middle,
			Vertex destination) {
		String cadena = "";
		ArrayList<Object> first = Dijkstra(source, middle);
		ArrayList<Object> last = Dijkstra(middle, destination);
		shortestPathWeight = 0.0;
		for (int i = 0; i < first.size(); i++) {
			EdgeWeight vertex = (EdgeWeight) first.get(i);
			cadena = cadena + vertex.from + " -> ";
			shortestPathWeight = shortestPathWeight + vertex.weight;
		}

		for (int i = 0; i < last.size(); i++) {
			EdgeWeight vertex = (EdgeWeight) last.get(i);
			if (i != last.size())
				cadena = cadena + vertex.from + " -> ";
			shortestPathWeight = shortestPathWeight + vertex.weight;

		}
		cadena = cadena + destination + " => ";
		cadena = cadena + shortestPathWeight;

		return cadena;
	}

	/**
	 * Metodo que implementa el arbol de caminos minimos de Dijkstra.
	 * 
	 * @param source
	 * @return
	 */
	public ArrayList<Object> DijkstraTree(Vertex source) {
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
		TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		Vertex vertex, to = null, from;
		ArrayList<Object> lista = new ArrayList<Object>();
		if (!(adjacencyMap.containsKey(source)))
			return new ArrayList<Object>();
		// Inicializar V_menos_S con todos los vértices de V menos fuente
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet()) {
			if (!(source.equals(e.getKey()))) {
				V_minus_S.add(e.getKey());
			}
		}

		Iterator itr = V_minus_S.iterator();
		while (itr.hasNext()) {
			vertex = (Vertex) itr.next();
			if (isAdjacent(source, vertex)) {
				S.put(vertex, source);
				D.put(vertex, getWeight(source, vertex));
			} else {
				S.put(vertex, null);
				D.put(vertex, Double.MAX_VALUE);
			}
		}
		// S.put(source, source); // Añadimos almeria almeria
		// D.put(source, 0.0); // Añadimos almeria con distancia 0

		// Mientras queden vertices en V_minus_S
		while (!V_minus_S.isEmpty()) {
			Double minWeight = Double.MAX_VALUE;
			from = null;

			// Cojemos el vertice con menor distancia de la lista de D y lo
			// llamos from.
			Iterator itr1 = V_minus_S.iterator();
			while (itr1.hasNext()) {
				vertex = (Vertex) itr1.next();
				if (D.get(vertex) < minWeight) {
					minWeight = D.get(vertex);
					from = vertex;
				}

			}

			// Cojemos el camino mas corto actual en la lista de D y lo añadimos
			// a nuestro retorno
			// calculando la distancia de from actual a su nodo adyacente mas
			// cercano.
			EdgeWeight edg = new EdgeWeight(S.get(from), from, getWeight(
					S.get(from), from));
			lista.add(edg);

			if (!from.equals(null)) {
				V_minus_S.remove(from); // quitamos el camino mas corto de de
										// V_minus_S
				Iterator itr2 = V_minus_S.iterator();
				while (itr2.hasNext()) {
					to = (Vertex) itr2.next();
					if (isAdjacent(from, to)) {
						double weight = getWeight(from, to);
						if (D.get(from) + weight < D.get(to)) { // Si la
																// distancia
																// desde origen
																// a destino es
																// mas pequeña
																// que la
																// calculada (si
																// hay)
							D.put(to, D.get(from) + weight); // Añade destino
																// con la
																// distancia
																// acumulada
																// desde Origen.
							S.put(to, from);

						}
					}
				}
			} else
				break;
		}

		return lista;

	}

	public ArrayList<ArrayList<Object>> DijkstraFarthest(Vertex source) {
		ArrayList<ArrayList<Object>> tree = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> arr;
		ArrayList<EdgeWeight> tree2 = new ArrayList<EdgeWeight>();
		for (Vertex v : adjacencyMap.keySet()) {
			if (!v.equals(source)) {
				arr = Dijkstra((Vertex) source, v);
				if (arr.size() != 0) {
					double total = 0.0;
					// Calculo el peso total de camino.
					Iterator<Object> it = arr.iterator();
					while (it.hasNext()) {
						EdgeWeight edg = (EdgeWeight) it.next();
						total = total + edg.weight;
					}

					tree2.add(new EdgeWeight(source, v, total));
				}
			}
		}
		Collections.sort(tree2);
		Collections.reverse(tree2);
		Iterator<EdgeWeight> it = tree2.iterator();
		while (it.hasNext()) {
			EdgeWeight e = (EdgeWeight) it.next();
			arr = Dijkstra(e.from, e.to);
			tree.add(arr);
		}

		return tree;
	}

	public TreeMap<Double, ArrayList<String>> intervalPaths(String source,
			String destination, double dis1, double dis2) {
		TreeMap<Double, ArrayList<String>> resultIntervalPaths = new TreeMap<Double, ArrayList<String>>();
		ArrayList<ArrayList<Vertex>> caminosSimples = new ArrayList<ArrayList<Vertex>>();
		Double distanciaMaxima = 0.0;
		ArrayList<String> aux;
		ArrayList<Vertex> Vdelcamino = new ArrayList<Vertex>();
		Vertex source1, destination1;
		source1 = (Vertex) source;
		destination1 = (Vertex) destination;

		// Obtenemos todos los caminos simples desde almeria a Oviedo
		caminosSimples = simplePaths(source1, destination1);

		// Recorremos todos los caminos simples de almeria a oviedo para calcula
		// el mas largo.
		for (int i = 0; i < caminosSimples.size() - 1; i++) {

			// calculamos la suma total de su distancia.
			Vertex actual = caminosSimples.get(i).get(0); // Almeria
			Double sumDistancia = 0.0;

			for (int j = 1; j < caminosSimples.get(i).size(); j++) {
				Vertex destinoActual = caminosSimples.get(i).get(j);
				sumDistancia = sumDistancia + getWeight(actual, destinoActual);
				actual = destinoActual; // Actualizamos almeria por la siguiente
										// ciudad
			}
			// En este momento en sumDistancia tenemos la suma total del
			// caminosimple
			distanciaMaxima = sumDistancia;
			System.out.println(distanciaMaxima);
			if (distanciaMaxima >= dis1 && distanciaMaxima <= dis2) {
				Vdelcamino = caminosSimples.get(i);
				Iterator<Vertex> it = Vdelcamino.iterator();
				aux = new ArrayList<String>();
				while (it.hasNext()) {
					String vertice = (String) it.next();
					if(!aux.contains(vertice))
					aux.add(vertice);
				}
				if (!resultIntervalPaths.containsKey(distanciaMaxima))
				resultIntervalPaths.put(distanciaMaxima, aux);
			}
			
			
		}
		//System.out.println(resultIntervalPaths);
		return resultIntervalPaths;
	}

	/**
	 * Algoritmo que devuelve el camino simple.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public ArrayList<ArrayList<Vertex>> simplePaths(Vertex source,
			Vertex destination) {
		result = new ArrayList<Vertex>();
		resultSimplePaths = new ArrayList<ArrayList<Vertex>>();

		simplePathsAux(source, destination);

		return resultSimplePaths;
	}

	private void simplePathsAux(Vertex current, Vertex destination) {
		result.add(current);

		if (current.equals(destination)) {
			ArrayList<Vertex> resultAux = new ArrayList<Vertex>();
			for (int i = 0; i < result.size(); i++)
				resultAux.add(result.get(i));
			resultSimplePaths.add(resultAux);
		} else {
			TreeMap<Vertex, Double> neighborMap = adjacencyMap.get(current);
			for (Map.Entry<Vertex, Double> entry : neighborMap.entrySet()) {
				Vertex to = entry.getKey();
				if (!result.contains(to))
					simplePathsAux(to, destination);
			}
		}
		result.remove(result.size() - 1);
	}

	public ArrayList<Object> largestPathWithSimplePaths(Vertex source,
			Vertex destination) {
		result = new ArrayList<Vertex>();
		ArrayList<ArrayList<Vertex>> caminosSimples = new ArrayList<ArrayList<Vertex>>();
		Double distanciaMaxima = 0.0;
		ArrayList<Object> arrEdge = new ArrayList<Object>();
		ArrayList<Vertex> VdelcaminoLargo = new ArrayList<Vertex>();

		// Obtenemos todos los caminos simples desde almeria a Oviedo
		caminosSimples = simplePaths(source, destination);

		// Recorremos todos los caminos simples de almeria a oviedo para calcula
		// el mas largo.
		for (int i = 0; i < caminosSimples.size() - 1; i++) {

			// calculamos la suma total de su distancia.
			Vertex actual = caminosSimples.get(i).get(0); // Almeria
			Double sumDistancia = 0.0;

			for (int j = 1; j < caminosSimples.get(i).size(); j++) {
				Vertex destinoActual = caminosSimples.get(i).get(j);
				sumDistancia = sumDistancia + getWeight(actual, destinoActual);
				actual = destinoActual; // Actualizamos almeria por la siguiente
										// ciudad
			}
			// En este momento en sumDistancia tenemos la suma total del
			// caminosimple
			if (sumDistancia > distanciaMaxima) {
				distanciaMaxima = sumDistancia;
				VdelcaminoLargo = caminosSimples.get(i);
			}

		}
		// En este momento Tenemos el camino mas largo = VdelcaminoLargo

		// El test pide un arrayList con el formato de EdgeWeight. Lo creamos.
		Vertex from = VdelcaminoLargo.get(0);
		for (int i = 1; i < VdelcaminoLargo.size(); i++) {
			Vertex to = VdelcaminoLargo.get(i);
			Double weight = getWeight(from, to); // El primero con el segundo
													// del array calcula
													// distancia.
			EdgeWeight auxEdge = new EdgeWeight(from, to, weight);
			arrEdge.add(auxEdge);
			from = to; // El inicio pasa a ser el destino anterior.
		}

		return arrEdge;
	}

	public int FloydWithDijkstra() {
		// Obtenemos todas las ciudades del mapa.
		ArrayList<Vertex> arrVertex = new ArrayList<Vertex>();
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet()) {
			arrVertex.add(e.getKey());
		}

		// recorremos todas la ciudades llamando al Dijkstra para obtener todos
		// los caminos simples.
		int contador = 0;
		for (int i = 0; i < arrVertex.size(); i++) {
			Vertex v1 = arrVertex.get(i);
			for (int j = 0; j < arrVertex.size(); j++) { // Realizamos el
															// recorrido para
															// cada una de las
															// ciudades.
				Vertex destino = arrVertex.get(j);
				if (!(v1.equals(destino))) { // Almeria almeria no lo recorremos
					if (Dijkstra(v1, destino).size() != 0)
						; // Si el array no esta vacio es porque hay camino.
					contador++;
				}
			}
		}
		System.err.println("Caminos simples FloydWithDijkstra " + contador);

		return contador;
	}

	public boolean isFloydGraph() {
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet()) {
			Vertex actual = e.getKey();
			// comprobamos si el vertice actual existe en el el TreMap de
			// adyacencias como Almeria 0.0
			if (!(e.getValue().containsKey(actual)))
				return false; // si en alguno de las provincias no lo contiene
								// retorno falso
		}
		return true;
	}

	// Añade al mapa de adyacencias los vertices de origen a origen con
	// distancia 0
	public void adaptToFloydGraph() {
		Vertex actual;
		for (Iterator<Vertex> iterador = iterator(); iterador.hasNext();) {
			actual = iterador.next();
			addEdge(actual, actual, 0.0);
		}
	}

	public ArrayList<ArrayList<EdgeWeight>> Floyd() {
		final double INFINITY = Double.MAX_VALUE;
		double[][] D; // Distancias
		int[][] A; // Vertices Anteriores
		TreeMap<Vertex, Integer> vtxIndex = new TreeMap<Vertex, Integer>();
		Vertex vertex, from, to;
		EdgeWeight edgeWeight;
		double weight;
		int i, j, k;
		int n = numberOfVertices();
		// if (n <= 0)
		// return null;
		D = new double[n][n];
		A = new int[n][n];
		int index = 0;
		// Imicializo D a infinito y A a -1 y guardo las posiciones de los
		// vertices en vtxIndex
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet())
			vtxIndex.put(e.getKey(), index++); // almacenamos el nombre del
												// vertice "Almeria" y la
												// posicion donde se encuentra
												// referenciado en el D y A
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				D[i][j] = INFINITY;
				A[i][j] = -1;
			}
		}

		// Añado los valores a la tabla de D (pesos)
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

		// Voy comprobando si para D[i][k] + D[k][j]) < D[i][j] si es menor
		// actualizo A con el camino corto.
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
		// En este momento contenemos en D y A los caminos cortos.
		// Tenemos que devolver un ArrayList<ArrayList<Object>>
		// showPaths(D, A, vtxIndex); // Solo visualiza.
		return getPaths(D, A, vtxIndex);
	}

	// Modificacion del showPaths (apuntes) que visualizaba para que devuelva un
	// ArrayList con el recorrido de los caminos mas cortos a cada provincia (lo
	// utiliza el Floyd para el test)
	private ArrayList<ArrayList<EdgeWeight>> getPaths(double D[][], int A[][],
			TreeMap<Vertex, Integer> vI) {
		final double INFINITY = Double.MAX_VALUE;
		int i, j;
		ArrayList<EdgeWeight> camino = new ArrayList<EdgeWeight>();
		ArrayList<ArrayList<EdgeWeight>> caminos = new ArrayList<ArrayList<EdgeWeight>>();

		// recorre D para cada provincia D[][]
		for (i = 0; (i < numberOfVertices()); i++) {
			for (j = 0; (j < numberOfVertices()); j++) {
				if ((D[i][j] >= 0) && (D[i][j] < INFINITY)) {
					// Obtengo el nombre de la provincia llamando al
					// getVertexFromIndex que me devuelve el nombre segun la
					// tabla de indices
					// vtxIndex creada en el floid y que pasamos como vI.
					Vertex v1 = getVertexFromIndex(vI, i);
					Vertex v2 = getVertexFromIndex(vI, j);
					// Compruebo siempre que no sean iguales el camino de
					// almeria a j (siendo j el resto)
					if (!(v1.equals(v2))) { // Almeria Almeria no lo compruebo
						camino = getPath(i, j, A, vI); // calcula el camino
						caminos.add(camino); // añadimos desde almeria a la
												// primera provincia el camino

					}
				}
			}
		}
		System.err.println("Tamaño Floyd" + caminos.size());
		return caminos;
	}

	// Modificacion del showPath: se llama recursivamente segun la tabla de A
	// para ir retornando el camino corto encontrado por Floyd
	private ArrayList<EdgeWeight> getPath(int i, int j, int A[][],
			TreeMap<Vertex, Integer> vI) {
		ArrayList<EdgeWeight> recorridocompleto = new ArrayList<EdgeWeight>();
		int k = A[i][j];

		if (k >= 0) {
			recorridocompleto.addAll(getPath(i, k, A, vI));
			recorridocompleto.addAll(getPath(k, j, A, vI));
		} else {
			Vertex nbciudadfron = getVertexFromIndex(vI, i);
			Vertex nbciudadto = getVertexFromIndex(vI, j);
			double distancia = getWeight(nbciudadfron, nbciudadto);
			EdgeWeight recorrido = new EdgeWeight(nbciudadfron, nbciudadto,
					distancia);
			recorridocompleto.add(recorrido);
		}

		return recorridocompleto;
	}

	private Vertex getVertexFromIndex(TreeMap<Vertex, Integer> vI, int index) {
		Vertex v = null;
		for (Map.Entry<Vertex, Integer> ei : vI.entrySet())
			if (ei.getValue() == index) {
				v = ei.getKey();
				break;
			}
		return v; // Retorna el nombre de la provincia segun el indice dado.
	}

	// Apuntes --> Visualiza D y A del Floyd
	private void showPaths(double D[][], int A[][], TreeMap<Vertex, Integer> vI) {
		final double INFINITY = Double.MAX_VALUE;
		int i, j;

		for (i = 0; (i < numberOfVertices()); i++) {
			for (j = 0; (j < numberOfVertices()); j++) {
				if ((D[i][j] >= 0) && (D[i][j] < INFINITY)) {
					if (!(getVertexFromIndex(vI, i).equals(getVertexFromIndex(
							vI, j)))) {
						System.out.print("Camino de "
								+ getVertexFromIndex(vI, i) + " a "
								+ getVertexFromIndex(vI, j) + ": "
								+ getVertexFromIndex(vI, i) + ", ");
						showPath(i, j, A, vI);
					}
				}
			}
			System.out.println();
		}
	}

	// Apuntes
	private void showPath(int i, int j, int A[][], TreeMap<Vertex, Integer> vI) {
		int k = A[i][j];
		if (k >= 0) {
			showPath(i, k, A, vI);
			showPath(k, j, A, vI);
		}
	}

	// Devuelve los itinerarios de todos los caminos mínimos de pares de
	// ciudades cuya distancia esté
	// comprendida entre dos distancias dadas [d1, d2], siendo d1 < d2.
	public ArrayList FloydFilterByDistances(double d1, double d2) {
		ArrayList<ArrayList<EdgeWeight>> retornoCaminosEntredosDistancia = new ArrayList<ArrayList<EdgeWeight>>();

		if (d1 > d2)
			return null;
		ArrayList<ArrayList<EdgeWeight>> todosLosCaminos = Floyd(); // Obtenemos
																	// todos los
																	// caminos
																	// simples
		// Recorremos los caminos para obtener o descartar los que se encuentren
		// dentro de los margenes
		for (int i = 0; i < todosLosCaminos.size(); i++) {
			Double contadorDistancia = 0.0;
			ArrayList<EdgeWeight> camino = todosLosCaminos.get(i);
			for (int j = 0; j < camino.size(); j++) {
				EdgeWeight edg = camino.get(j);
				contadorDistancia = contadorDistancia + edg.weight;

			}
			// System.out.println(contadorDistancia);
			if (contadorDistancia > d1 && contadorDistancia < d2) {
				retornoCaminosEntredosDistancia.add(camino);
			}

		}
		return retornoCaminosEntredosDistancia;

	}

	// FLOYDCLOSESTFARTHEST --> Camino minimo y maximo entre dos puntos.
	// "Badajoz -> Caceres => 90.0" + "
	// "Corunya -> Valladolid -> Madrid -> Zaragoza -> Barcelona -> Gerona -> Lerida => 1591.0"
	// + "
	public ArrayList<ArrayList<EdgeWeight>> FloydClosestFarthest() {
		ArrayList<ArrayList<EdgeWeight>> retornoMinimoMaximo = new ArrayList<ArrayList<EdgeWeight>>();
		ArrayList<ArrayList<EdgeWeight>> todosLosCaminos = new ArrayList<ArrayList<EdgeWeight>>();
		Double minimoCamino = Double.MAX_VALUE;
		Double maximoCamino = Double.MIN_VALUE;
		todosLosCaminos = Floyd(); // Obtenemos todos los caminos posibles.
		ArrayList<EdgeWeight> arrAuxMin = new ArrayList<EdgeWeight>();
		ArrayList<EdgeWeight> arrAuxMax = new ArrayList<EdgeWeight>();

		// obtenemos el camino minimo y maximo
		for (int i = 0; i < todosLosCaminos.size(); i++) {
			Double contador = 0.0;
			for (int j = 0; j < todosLosCaminos.get(i).size(); j++) {
				contador = contador + todosLosCaminos.get(i).get(j).weight;

			}
			if (contador < minimoCamino) {
				minimoCamino = contador;
				arrAuxMin = todosLosCaminos.get(i);
			}
			if (contador > maximoCamino) {
				maximoCamino = contador;
				arrAuxMax = todosLosCaminos.get(i);
			}
		}
		// System.err.println(arrAuxMax.toString());
		// System.err.println(arrAuxMin.toString());
		retornoMinimoMaximo.add(arrAuxMin);
		retornoMinimoMaximo.add(arrAuxMax);

		return retornoMinimoMaximo;
	}

	// FLOYDFILTERBYNAMESOFCITY
	// Todos los caminos minimos que tienen como origen Madrid y destino todas
	// las restantes ciudades del grafo.
	public ArrayList<ArrayList<EdgeWeight>> FloydFilterByNameOfCity(
			Vertex source) {
		ArrayList<ArrayList<EdgeWeight>> retorno = new ArrayList<ArrayList<EdgeWeight>>();

		// Llamamos a Floyd para calcular todos los caminos minimos posibles del
		// grafo.
		ArrayList<ArrayList<EdgeWeight>> todosLosCaminosSimples = new ArrayList<ArrayList<EdgeWeight>>();
		todosLosCaminosSimples = Floyd();

		// Recorremos el resultado de Floyd quedandnos solo con los fron =
		// Madrid
		for (int i = 0; i < todosLosCaminosSimples.size(); i++) {
			EdgeWeight edg = todosLosCaminosSimples.get(i).get(0); // Solo es
																	// necesario
																	// comprobar
																	// el primer
																	// EdgeWeight
																	// de cada
																	// array.
			// si el origen es Madrid lo que añadimos a nuestro resultado final
			if (edg.from.equals(source)) {
				retorno.add(todosLosCaminosSimples.get(i));

			}
		}
		return retorno;
	}

	// PRIM (Transparencias)
	public ArrayList Prim(Vertex source) {
		final double INFINITY = Double.MAX_VALUE;
		TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
		TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
		TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();
		Vertex vertex, to = null, from;
		ArrayList<Object> MST = new ArrayList<Object>();
		if (source == null)
			return new ArrayList<Object>();
		if (!(adjacencyMap.containsKey(source)))
			return new ArrayList<Object>();
		for (Map.Entry<Vertex, TreeMap<Vertex, Double>> e : adjacencyMap
				.entrySet()) {
			if (!(source.equals(e.getKey())))
				V_minus_S.add(e.getKey());
		}

		Iterator itr = V_minus_S.iterator();
		while (itr.hasNext()) {
			vertex = (Vertex) itr.next();
			if (isAdjacent(source, vertex)) {
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

			if (from != null) {
				V_minus_S.remove(from);
				EdgeWeight edgeWeight = new EdgeWeight(S.get(from), from,
						getWeight(S.get(from), from));
				MST.add(edgeWeight);
				Iterator itr2 = V_minus_S.iterator();
				while (itr2.hasNext()) {
					to = (Vertex) itr2.next();
					if (isAdjacent(from, to)) {
						double weight = getWeight(from, to);
						if (weight < D.get(to)) {
							D.put(to, weight);
							S.put(to, from);
						}
					}
				}
			} else
				break;
		}
		return MST;

	}

	// RECORRIDO EN ANCHURA ( Apuntes)

	// IMPLEMENT THE EXERCISES SUGGESTED AT THE PRACTICE 04
	// ...

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

	// ...

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
			RoadNetwork.this.removeVertex(current);
		}

	}

	protected class VertexWeightPair implements Comparable<VertexWeightPair> {
		Vertex vertex;
		double weight;

		/**
		 * Initializes this VertexWeightPair from vertex and weight.
		 * 
		 */
		public VertexWeightPair(Vertex vertex, double weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		/**
		 * Returns the vertex in this VertexWeightPair.
		 * 
		 */
		public Vertex getVertex() {
			return vertex;
		}

		/**
		 * Returns the weight in this VertexWeightPair.
		 * 
		 */
		public double getWeight() {
			return weight;
		}

		/**
		 * Set the weight in this VertexWeightPair.
		 * 
		 */
		public void setWeight(double w) {
			weight = w;
		}

		/**
		 * Returns an int <, = or > 0 , depending on whether this
		 * VertexWeightPair's weight is <, = or > other's weight.
		 * 
		 */
		public int compareTo(VertexWeightPair other) {
			return (int) (weight - other.getWeight());
		}

		/**
		 * Returns a String representation of this VertexWeightPair.
		 * 
		 */
		public String toString() {
			return vertex.toString() + "  " + String.valueOf(weight);
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

}
