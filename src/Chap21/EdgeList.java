package Chap21;

/**
 * Created by Administrator on 2014-09-26.
 */
public interface EdgeList {
	State get(byte b);
	void put(byte b, State state);
	byte[] keys();
}