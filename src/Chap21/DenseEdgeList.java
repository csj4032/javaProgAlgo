package Chap21;

/**
 * Created by Administrator on 2014-09-26.
 */
public class DenseEdgeList implements EdgeList {

	private State[] array;

	public DenseEdgeList() {
		this.array = new State[256];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = null;
		}
	}

	@Override
	public State get(byte b) {
		return this.array[(int) b & 0xFF];
	}

	@Override
	public void put(byte b, State state) {
		this.array[(int) b & 0xFF] = state;
	}

	@Override
	public byte[] keys() {
		return new byte[0];
	}
}
