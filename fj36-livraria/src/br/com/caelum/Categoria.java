package br.com.caelum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categoria implements Serializable {

	private String nome;
	private List<Livro> livros = new ArrayList<Livro>();
}
