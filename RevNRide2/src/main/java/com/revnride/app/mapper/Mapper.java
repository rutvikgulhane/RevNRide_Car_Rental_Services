package com.revnride.app.mapper;

/**
 * Interface generic use for mapper class.
 */
public interface Mapper<U, V, Z> {

	public V toDto(final U u);


    public U toEntity(final Z z);

   
    public U update(U u, final Z z);
}
