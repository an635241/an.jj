package com.topsports.hr.weixin.SendMSGutil;

import java.util.ArrayList;
import java.util.List;

public class SMSSendResponse {

	private List<Data>	DATA;

	public static class Data {
		//磁条信息
		private String	MOBILE;

		private String	ERROR;

		public String getMOBILE() {
			return MOBILE;
		}

		public void setMOBILE(String mOBILE) {
			MOBILE = mOBILE;
		}

		public String getERROR() {
			return ERROR;
		}

		public void setERROR(String eRROR) {
			ERROR = eRROR;
		}

	}

	public void addDATA(Data data) {
		if (this.DATA == null) {
			this.DATA = new ArrayList<Data>();
		}
		this.DATA.add(data);
	}

	public List<Data> getDATA() {
		return DATA;
	}

	public void setDATA(List<Data> dATA) {
		DATA = dATA;
	}

	public Data getFirstData() {
		if (this.getDATA() != null && this.getDATA().size() > 0) {
			return this.getDATA().get(0);
		}
		return new Data();
	}
}
