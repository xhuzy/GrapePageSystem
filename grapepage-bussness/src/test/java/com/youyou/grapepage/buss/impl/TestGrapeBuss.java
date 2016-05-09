package com.youyou.grapepage.buss.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.youyou.grapepage.buss.IGrapeBuss;

import junit.framework.Assert;

public class TestGrapeBuss {
	@Resource(name = "grapeBussImpl")
	private IGrapeBuss grapeBuss;

	@Test
	public void test() {
        String result=this.grapeBuss.grapeByUrl("", "");
        Assert.assertTrue(result.length()>0);
}

}
