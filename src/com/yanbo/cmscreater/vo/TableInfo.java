package com.yanbo.cmscreater.vo;

import java.util.ArrayList;
import java.util.List;

public class TableInfo {
	private String tableName;
	private List<ColumInfo> columInfos;

	public void addColumInfo(ColumInfo columInfo) {
		if (columInfos == null)
			columInfos = new ArrayList<ColumInfo>();
		columInfos.add(columInfo);
	}

	public ColumInfo searchColumInfoByName(String name) {
		for (ColumInfo info : columInfos) {
			if (info.getName().equals(name))
				return info;
		}
		return null;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<ColumInfo> getColumInfos() {
		return columInfos;
	}

	public void setColumInfos(List<ColumInfo> columInfos) {
		this.columInfos = columInfos;
	}

}
