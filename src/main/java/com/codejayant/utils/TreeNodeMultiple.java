package com.codejayant.utils;

import java.util.List;

public class TreeNodeMultiple {
	public int val;
	public List<TreeNodeMultiple> children;

	public TreeNodeMultiple() {}

	public TreeNodeMultiple(int _val) {
		val = _val;
	}

	public TreeNodeMultiple(int _val, List<TreeNodeMultiple> _children) {
		val = _val;
		children = _children;
	}
}
