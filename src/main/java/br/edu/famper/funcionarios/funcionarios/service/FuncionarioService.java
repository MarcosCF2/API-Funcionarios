package br.edu.famper.funcionarios.funcionarios.service;

import br.edu.famper.funcionarios.funcionarios.model.Funcionario;
import br.edu.famper.funcionarios.funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public ResponseEntity<List<Funcionario>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.findAll());
    }

    public ResponseEntity<Optional<Funcionario>> findById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.findById(id));
    }

    public ResponseEntity<Funcionario> save(Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioRepository.save(funcionario));
    }

    public ResponseEntity<Funcionario> update(Funcionario funcionario) {
        Funcionario save = funcionarioRepository.findById(funcionario.getCodigo())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        save.setNomeFuncionario(funcionario.getNomeFuncionario());
        save.setCargo(funcionario.getCargo());
        save.setDepartamento(funcionario.getDepartamento());
        save.setDataAdmissao(funcionario.getDataAdmissao());
        save.setTelefone(funcionario.getTelefone());
        save.setEmail(funcionario.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.save(save));
    }

    public void deleteById(long id) {funcionarioRepository.deleteById(id);}

}
