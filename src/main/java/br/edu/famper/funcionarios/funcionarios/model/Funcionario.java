package br.edu.famper.funcionarios.funcionarios.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "funcionario")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
    private Long codigo;

    @NotNull
    @Column(name = "nome_funcionario")
    private String nomeFuncionario;

    @NotNull
    @Column(name = "cargo", length = 50)
    private String cargo;

    @NotNull
    @Column(name = "departamento", length = 100)
    private String departamento;

    @NotNull
    @Column(name = "data_admissao")
    private Date dataAdmissao;

    @NotNull
    @Column(name = "email", length = 150)
    private String email;

    @NotNull
    @Column(name = "telefone", length = 20)
    private String telefone;

}
