package br.com.fiap.livraria.repository;

import br.com.fiap.livraria.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Essa classe precisa extender a JpaRepository e passar como parâmetro a CLASSE e o TIPO DO ID
//Por ser uma interface é implementado todos os métodos

public interface LivrariaRopository extends JpaRepository <Livro, Long>{

    //implementação de uma query que é gerada em tempo de execução pelo próprio Spring
    //Para que crie corretamente, é preciso seguir a mesma escrita dos métodos da classe JpaRepository
    //ex: findAllBy_OqueDesejaProcurar_Like... porém pode ser where entre outros. Depende do tipo de pesquisa que deseja
    List<Livro> findAllByTituloLike(String titulo);

    //Named Query
    //escrevendo a query usando JPQL
    //@Query("select l from Livro l where l.titulo like :titulo")
    //List<Livro> buscarLivrosPorTitulo(String titulo);

}
