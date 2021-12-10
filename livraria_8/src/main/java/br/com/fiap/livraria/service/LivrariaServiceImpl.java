package br.com.fiap.livraria.service;

import br.com.fiap.livraria.entity.Livro;
import br.com.fiap.livraria.repository.LivrariaRopository;
import br.com.fiap.livraria.spring.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.livraria.spring.model.dto.LivroDTO;
import br.com.fiap.livraria.spring.model.dto.UpdatePrecoLivroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivrariaServiceImpl implements LivrariaService {

    private final LivrariaRopository livroRepository;

    public LivrariaServiceImpl(LivrariaRopository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public List<LivroDTO> buscarLivros(String titulo) {
        List<Livro> livroList;
        if (titulo != null) {
            livroList = livroRepository.findAllByTituloLike("%" + titulo + "%");
        } else {
            livroList = livroRepository.findAll();
        }
        return livroList.stream()
                .map(livro -> new LivroDTO(livro))
                .collect(Collectors.toList());
    }

    @Override
    public LivroDTO buscarPorId(int id) {
        Livro livro = findLivroById(id);
        return new LivroDTO(livro);
    }

    private Livro findLivroById(long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return livro;
    }

    @Override
    public LivroDTO criar(CreateUpdateLivroDTO createUpdateLivroDTO) {
        Livro livro = new Livro(createUpdateLivroDTO);
        Livro savedLivro = livroRepository.save(livro);
        return new LivroDTO(savedLivro);
    }

    @Override
    public LivroDTO atualizar(CreateUpdateLivroDTO stockCreateUpdateDTO, int id) {
        Livro livro = findLivroById(id);

        livro.setTitulo(stockCreateUpdateDTO.getTitulo());
        livro.setDescricao(stockCreateUpdateDTO.getDescricao());
        livro.setDataDePublicacao(stockCreateUpdateDTO.getDataDePublicacao());
        livro.setISBN(stockCreateUpdateDTO.getISBN());
        livro.setPreco(stockCreateUpdateDTO.getPreco());

        Livro savedLivro = livroRepository.save(livro);
        return new LivroDTO(savedLivro);
    }

    @Override
    public LivroDTO atualizarPreco(UpdatePrecoLivroDTO updatePrecoLivroDTO, int id) {
        Livro livro = findLivroById(id);
        livro.setPreco(updatePrecoLivroDTO.getPreco());

        Livro savedLivro = livroRepository.save(livro);
        return new LivroDTO(savedLivro);
    }

    @Override
    public void delete(int id) {
        Livro livro = findLivroById(id);
        livroRepository.delete(livro);
    }
}
