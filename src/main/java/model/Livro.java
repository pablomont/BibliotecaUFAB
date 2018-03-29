package model;

import java.util.ArrayList;
import java.util.List;

public class Livro implements ItemAcervo {
	
	private String isbn;
	private String titulo;
	private List<String> autores;
	private String editora;
	private int anoDePublicacao;
	private int numPaginas;
	private String area;
	private String tema;
	
	public Livro(String isbn, String titulo) {
		autores = new ArrayList<String>();
		setTitulo(titulo);
		setIsbn(isbn);
	}

	public void addAutor(String autor) {
		if(!autores.contains(autor)) {
			autores.add(autor);
		}
		else
			throw new IllegalArgumentException("Autor já existente");
	}
	
	public void removeAutor(String autor) {
		if(autores.contains(autor)) {
			autores.remove(autor);
		}
		else
			throw new IllegalArgumentException("Autor inexistente");
	}
	
	//https://www.moreofless.co.uk/validate-isbn-13-java/
	public boolean  validateIsbn13(String isbn)
    {
        if (isbn == null)
            return false;
        
        isbn = isbn.replaceAll( "-", "" );

        if (isbn.length() != 13)
            return false;
        
        try
        {
            int tot = 0;
            for ( int i = 0; i < 12; i++ )
            {
                int digit = Integer.parseInt( isbn.substring( i, i + 1 ) );
                tot += (i % 2 == 0) ? digit * 1 : digit * 3;
            }

            int checksum = 10 - (tot % 10);
            if ( checksum == 10 )
                checksum = 0;
            

            return checksum == Integer.parseInt( isbn.substring( 12 ) );
        }
        catch ( NumberFormatException nfe )
        {
            return false;
        }
    }	
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		if(validateIsbn13(isbn))
			this.isbn = isbn;
		
		else
			throw new IllegalArgumentException("ISBN inválido");

	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<String> getAutores() {
		return autores;
	}
	
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}
	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + "]";
	}


}
