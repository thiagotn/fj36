package br.com.caelum;

import java.io.Serializable;

public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	@Override
	public String toString() {
		return "livro";
	}
}
