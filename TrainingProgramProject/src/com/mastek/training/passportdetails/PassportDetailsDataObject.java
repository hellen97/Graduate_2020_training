package com.mastek.training.passportdetails;

import java.util.Collection;

public interface PassportDetailsDataObject<D> {
	public D add (D newD);
	public Collection<D> listAll();
	public D find(int key);
	public D remove(int key);


}
