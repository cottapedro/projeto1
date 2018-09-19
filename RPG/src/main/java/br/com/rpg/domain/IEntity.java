package br.com.rpg.domain;

import java.io.Serializable;

public interface IEntity<ID> extends Serializable {

	ID getId();

	void setId(ID id);
}