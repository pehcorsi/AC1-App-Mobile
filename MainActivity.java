package com.facens.ac1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private EditText editTextTitulo;
  private EditText editTextAutor;
  private CheckBox checkBoxLido;
  private Button buttonAdicionar;
  private TextView textViewListaLivros;

  private List<Livro> listaLivros;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });

    editTextTitulo = findViewById(R.id.editTextTitulo);
    editTextAutor = findViewById(R.id.editTextAutor);
    checkBoxLido = findViewById(R.id.checkBoxLido);
    buttonAdicionar = findViewById(R.id.buttonAdicionar);
    textViewListaLivros = findViewById(R.id.textViewListaLivros);

    listaLivros = new ArrayList<>();

    checkBoxLido.setOnCheckedChangeListener((buttonView, isChecked) -> {
      if (isChecked) {
        checkBoxLido.setText("Lido");
      } else {
        checkBoxLido.setText("Não lido");
      }
    });

    buttonAdicionar.setOnClickListener(v -> adicionarLivro());
  }

  private void adicionarLivro() {
    String titulo = editTextTitulo.getText().toString().trim();
    String autor = editTextAutor.getText().toString().trim();
    boolean lido = checkBoxLido.isChecked();

    if (titulo.isEmpty() || autor.isEmpty()) {
      Toast.makeText(this, "Preencha Título e Autor!", Toast.LENGTH_SHORT).show();
      return;
    }

    Livro novoLivro = new Livro(titulo, autor, lido);
    listaLivros.add(novoLivro);

    atualizarListaNaTela();

    editTextTitulo.setText("");
    editTextAutor.setText("");
    checkBoxLido.setChecked(false);
    checkBoxLido.setText("Não lido");

    Toast.makeText(this, "Livro adicionado com sucesso!", Toast.LENGTH_SHORT).show();
  }

  private void atualizarListaNaTela() {
    StringBuilder sb = new StringBuilder();
    for (Livro livro : listaLivros) {
      sb.append(livro.toString()).append("\n----------------------------\n");
    }
    textViewListaLivros.setText(sb.toString());
  }
}
