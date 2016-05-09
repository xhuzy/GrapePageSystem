package com.youyou.grapepage.buss.impl;

import javax.annotation.Resource;

import com.youyou.grapepage.buss.IGrapeBuss;

public class Test {
	
	@Resource(name = "grapeBussImpl")
	private IGrapeBuss grapeBuss;
	
	public void test(){
		this.grapeBuss.grapeByUrl("", "");
	}
}
