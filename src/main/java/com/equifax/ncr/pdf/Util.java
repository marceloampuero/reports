package com.equifax.ncr.pdf;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Util {

	public static JRBeanCollectionDataSource oneElementList() {
		List<String> list = new ArrayList<String>();
		list.add("");

		return new JRBeanCollectionDataSource(list);

	}

}
