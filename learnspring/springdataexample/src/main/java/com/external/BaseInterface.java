package com.external;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseInterface<T, ID extends Serializable> extends Repository<T, ID> {
	T findOne(ID id);

}
