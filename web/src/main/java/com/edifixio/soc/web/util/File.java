package com.edifixio.soc.web.util;

import java.io.Serializable;

public class File implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String mime;
	private long length;
	private byte[] data;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	
}
