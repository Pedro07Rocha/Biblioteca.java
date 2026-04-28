

import java.util.*;
import java.io.*;

public class LivroController {
    private List<Livro> livros = new ArrayList<>();
    private final String FILE_NAME = "livros.txt";
    private int proximoId = 1;

    public LivroController() {
        carregar();
        if (!livros.isEmpty()) {
            proximoId = livros.get(livros.size() - 1).getId() + 1;
        }
    }

    public void adicionarLivro(String titulo, String autor, int ano) {
        Livro livro = new Livro(proximoId++, titulo, autor, ano);
        livros.add(livro);
        salvar();
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public Livro buscarPorId(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    public boolean removerLivro(int id) {
        boolean removed = livros.removeIf(l -> l.getId() == id);
        if (removed) salvar();
        return removed;
    }

    public void salvar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(livros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            livros = (List<Livro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            livros = new ArrayList<>();
        }
    }
}
