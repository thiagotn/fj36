package br.com.caelum.jaxb;

import java.io.FileInputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class TesteUnMarshal {

	public static void main(String[] args) throws Exception {
		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		livro.setTitulo("Arquitetura Java");
		livro.setNomeAutor("Paulo Silveira");
		livro.setValor(new BigDecimal("29.90"));
		
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Livro unmarshal = (Livro) unmarshaller.unmarshal(new FileInputStream("livro.xml"));
		System.out.println(unmarshal);
	}
}
