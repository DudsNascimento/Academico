package com.academico.application.viewmodel;

import java.util.UUID;
import java.util.Date;

public class AlunoViewModel {

    private UUID id;
	private UUID instituicaoId;
	private String nome;
	private String cpf;
	private String matricula;
	private Date dataNascimento;
	private Date dataMatricula;

	public UUID getId() {
        return this.id;
    }
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

	public void setId(UUID id) {
        this.id = id;
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