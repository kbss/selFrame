package com.ksb.selframe;

public interface IElement {


	public IElement find(By criteria);

	public void click();

	public IElement clear();

	public void set(String value);

	public IElement waitElement(int timeOutInSeconds);

}
