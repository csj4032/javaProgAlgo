package chap21;

public interface EdgeList {
	State get(byte b);
	void put(byte b, State state);
	byte[] keys();
}