package br.eventos.util;

import java.util.List;

public class UF {
	
	private List<String> ufs;
	
	public UF(){
		this.ufs.add("GO");
		this.ufs.add("MT");
		this.ufs.add("MS");
		this.ufs.add("TO");
	}

	public List<String> getUfs() {
		return ufs;
	}

}
