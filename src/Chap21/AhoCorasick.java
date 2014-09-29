package Chap21;

/**
 * Created by Administrator on 2014-09-26.
 */
public class AhoCorasick {

	private State root;
	private Boolean prepared;

	public AhoCorasick() {
		this.root = new State(0);
		this.prepared = false;
	}

	public void add(byte[] keyword, Object output) {
		if(this.prepared) {
			throw new IllegalStateException("can't add keywords after prepare is called");
		}
		State lastState = this.root.extendAll(keyword);
		lastState.addOutput(output);
	}
}
