package Chap21;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2014-09-26.
 */
public class State {

	private static final int THRESHOLD_TO_USE_SPARSE = 3;

	private int depth;
	private EdgeList edgeList;
	private State fail;
	private Set<Object> outputs;

	public State(int depth) {
		this.depth = depth;
		if (depth > THRESHOLD_TO_USE_SPARSE) {
			this.edgeList = new SparesEdgeList();
		} else {
			this.edgeList = new DenseEdgeList();
		}
		this.fail = null;
		this.outputs = new HashSet<Object>();
	}

	private State extend(byte b) {
		if (this.edgeList.get(b) != null) {
			return this.edgeList.get(b);
		}
		State nextState = new State(this.depth + 1);
		this.edgeList.put(b, nextState);
		return nextState;
	}

	public State extendAll(byte[] bytes) {
		System.out.println("all = " + bytes);
		State state = this;
		for (int i = 0; i < bytes.length; i++) {
			System.out.println("byte = " + bytes[i] + " " + "int = " + ((int) bytes[i]) + " " + "16진수 = " + ((int) bytes[i] & 0xFF));
			if (state.edgeList.get(bytes[i]) != null) {
				state = state.edgeList.get(bytes[i]);
			} else {
				state = state.extend(bytes[i]);
			}
		}
		return state;
	}

	public void addOutput(Object o) {
		this.outputs.add(o);
	}
}
