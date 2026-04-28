
import java.io.Serializable;

public class Livro implements Serializable {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private boolean emprestado;

    public Livro(int id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.emprestado = false;
    }

    public void emprestar() {
        this.emprestado = true;
    }

    public void devolver() {
        this.emprestado = false;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAno() { return ano; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAno(int ano) { this.ano = ano; }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Ano: " + ano +
                ", Emprestado: " + (emprestado ? "Sim" : "Não");
    }
}