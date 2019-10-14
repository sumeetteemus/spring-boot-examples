package com.publicissapient.employee.listeners;
public class GenericSpringEvent<T> {
    private T what;
    protected boolean success;
 
    public GenericSpringEvent(T what, boolean success) {
        this.what = what;
        this.success = success;
    }
    // ... standard getters
}