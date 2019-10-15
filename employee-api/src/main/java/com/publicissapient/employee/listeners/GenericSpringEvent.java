package com.publicissapient.employee.listeners;

//TODO
public class GenericSpringEvent<T> {
    private T what;
    protected boolean success;
 
    public GenericSpringEvent(T what, boolean success) {
        this.setWhat(what);
        this.success = success;
    }

	public T getWhat() {
		return what;
	}

	public void setWhat(T what) {
		this.what = what;
	}
}