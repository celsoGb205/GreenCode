package com.Site.GreenCode.Service;

import com.Site.GreenCode.Model.M_Pessoa;
import com.Site.GreenCode.Model.M_Resposta;
import com.Site.GreenCode.Repository.R_Pessoa;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Pessoa {
    private static R_Pessoa r_pessoa;

    public S_Pessoa(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    public static M_Pessoa getPessoaLogin(String email, String senha) {
        if (!email.trim().equals("")) {
            return r_pessoa.findByEmailESenha(email, senha);
        }
        return null;
    }

    public static M_Resposta validaCadastro(String nome, String email, String telefone,
                                            String senha) {
        String mensagem = "";
        telefone = NumberCleaner.cleanNumber(telefone);
        boolean podeSalvar = true;

        if (nome == null || nome.trim().equals("")) {
            mensagem += "O nome precisa ser preenchido\n";
            podeSalvar = false;
        }
        if (email == null || email.trim().equals("")) {
            mensagem += "O E-mail precisa ser preenchido\n";
            podeSalvar = false;
        }
        if (telefone == null || telefone.trim().equals("")) {
            mensagem += "O Telefone precisa ser preenchido\n";
            podeSalvar = false;
        }
        if ((senha == null || senha.trim().equals(""))) {
            mensagem += "Senha precisa ser preenchida\n";
            podeSalvar = false;
        }

        if (podeSalvar) {
            M_Pessoa m_pessoa = new M_Pessoa();
            m_pessoa.setNome(nome);
            m_pessoa.setEmail(email);
            m_pessoa.setTelefone(Long.valueOf(telefone));
            m_pessoa.setSenha(senha);
            try {
                r_pessoa.save(m_pessoa);
                mensagem += "Cadastro efetuado com sucesso";
            } catch (DataIntegrityViolationException e) {
                if (e.getMessage().contains("email_unique")) {
                    mensagem += "O Email informado já foi cadastrado";
                } else {
                    mensagem += "Erro ao Cadastrar";
                }
                podeSalvar = false;
            }

        }
        M_Resposta m_resposta = new M_Resposta(podeSalvar, mensagem);
        return m_resposta;

    }

    public static M_Resposta updateUsuario(String senhaAtual, String novaSenha, String confSenha, Object pessoa){
        boolean podeEditar = false;
        String mensagem = "";

        M_Pessoa m_pessoa = (M_Pessoa) pessoa;

        if(senhaAtual.equals(m_pessoa.getSenha())){
            podeEditar = true;

            if(!novaSenha.equals(confSenha) && !S_Generico.textoEstaVazio(novaSenha)){
                podeEditar = false;
                mensagem += "A Nova senha e a confirmação de senha precisam ser iguais!";
            }

            if(podeEditar){
                if(!S_Generico.textoEstaVazio(novaSenha)) {
                    m_pessoa.setSenha(novaSenha);
                }
                try {
                    r_pessoa.save(m_pessoa);
                    mensagem += "Senha atualizada com sucesso";
                }catch (DataIntegrityViolationException e){
                    podeEditar = false;
                    mensagem += "Falha ao tentar atualizar a senha: "+ e.getMessage();
                }
            }
        }else{
            mensagem += "Senha inválida, a senha não pode ser editado!";
        }
        return new M_Resposta(podeEditar,mensagem);
    }

}