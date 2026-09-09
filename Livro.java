package com.facens.ac1;

public class Livro {
  private String titulo;
  private String autor;
  private boolean lido;

  public Livro(String titulo, String autor, boolean lido) {
    this.titulo = titulo;
    this.autor = autor;
    this.lido = lido;
  }

  public String getTitulo() { return titulo; }
  public String getAutor() { return autor; }
  public boolean isLido() { return lido; }

  @Override
  public String toString() {
    String status = lido ? "Lido" : "Não lido";
    return "Título: " + titulo + "\nAutor: " + autor + "\nStatus: " + status;
  }
}
