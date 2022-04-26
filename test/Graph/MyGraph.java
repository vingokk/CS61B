import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class MyGraph<T extends Node, E extends Weight> {
	private Map<T, List<T>> map;
	private int size;
	public double[][] timeEdge;
	public double[][] moneyEdge;
	public double[] time;
	public double[] money;

	public MyGraph(int size) {
		map = new HashMap<>();
		this.size = size;
		timeEdge = new double[size][size];
		moneyEdge = new double[size][size];
		time = new double[size];
		money = new double[size];
	}

    /** Adds a vertex into the graph. */
	public void add(T s) {
		map.put(s, new ArrayList<T>());
		time[s.num] = s.time;
		money[s.num] = s.money;
	}

	/** Adds an edge from vertex v to w. */
	public void addEdge(T v, T w, E weight) {
		if (!map.containsKey(v)) {
			add(v);
		}
		if (!map.containsKey(w)) {
			add(w);
		}
		// v -> w
		map.get(v).add(w);
		timeEdge[v.num][w.num] = weight.time;
		moneyEdge[v.num][w.num] = weight.money;

		// w -> v
		//map.get(w).add(v);
		//timeEdge[w.num][v.num] = weight.time;
		//moneyEdge[w.num][v.num] = weight.money;
	}

	public Iterable<T> adj(T v){
		return map.get(v);
	}

	/** Returns all vertexes. */
	public Set<T> vertexAll() {
		return map.keySet();
	}

	/** Returns the number of all vertexes. */
	public int vertexNum() {
        return size;
    }
}