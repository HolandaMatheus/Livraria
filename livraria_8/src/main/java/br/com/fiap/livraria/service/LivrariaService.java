package br.com.fiap.livraria.service;

import br.com.fiap.livraria.spring.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.livraria.spring.model.dto.LivroDTO;
import br.com.fiap.livraria.spring.model.dto.UpdatePrecoLivroDTO;

import java.util.List;

//Adicionar nas interfaces toda regra de negócio (métodos)
public interface LivrariaService {

    //Definição de contrato (todos os métodos que o negócio vai possuir)
    List<LivroDTO> buscarLivros(String titulo);
    LivroDTO buscarPorId(int id);
    LivroDTO criar(CreateUpdateLivroDTO createUpdateLivroDTO);
    LivroDTO atualizar(CreateUpdateLivroDTO stockCreateUpdateDTO, int id);
    LivroDTO atualizarPreco(UpdatePrecoLivroDTO updatePrecoLivroDTO, int id);
    void delete(int id);

}
