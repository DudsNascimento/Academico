package com.academico.domain.entity;

import java.util.UUID;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class Aluno extends BaseEntity {

    @Column()
	private UUID instituicaoId;
    @Column()
	private String nome;
    @Column()
	private String cpf;
    @Column()
	private String matricula;
    @Column()
	private Date dataNascimento;
    @Column()
	private Date dataMatricula;

	public UUID getInstituicaoId() {
        return this.instituicaoId;
    }
	public String getNome() {
        return this.nome;
    }
	public String getCpf() {
        return this.cpf;
    }
	public String getMatricula() {
        return this.matricula;
    }
	public Date getDataNascimento() {
        return this.dataNascimento;
    }
	public Date getDataMatricula() {
        return this.dataMatricula;
    }

	public void setInstituicaoId(UUID instituicaoId) {
        this.instituicaoId = instituicaoId;
    }
	public void setNome(String nome) {
        this.nome = nome;
    }
	public void setCpf(String cpf) {
        this.cpf = cpf;
    }
	public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
	public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
	public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
