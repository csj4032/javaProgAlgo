/**
 *	Copyrihgt DaumService., Copyright(c) 2014 All rights reserved.
 *
 *    @Project        :		javaProgAlgo
 *	@Package        :		Chap09
 *	@File            :		Node.java
 *	@Date            :		2014. 2. 17.
 *	@Author        :		daum
 *	@Version        :		1.0
 *	@Description    :
 *
 *	@ModifyDate    :
 *	@Amender        :
 *	@Description    :
 **/

package chap09;

public class Node {

	Comparable data;
	Node left;
	Node right;

	public Node(Comparable aLabel) {
		left = null;
		right = null;
		data = aLabel;
	}
}