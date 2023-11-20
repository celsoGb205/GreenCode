package com.Site.GreenCode.Service;


import com.Site.GreenCode.Model.M_Pessoa;
import com.Site.GreenCode.Repository.R_Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class S_Email {
    @Autowired
    private static JavaMailSender mailSender;
    private static R_Pessoa r_pessoa;

    public S_Email(R_Pessoa r_pessoa,JavaMailSender mailSender) {
        this.r_pessoa = r_pessoa;
        this.mailSender = mailSender;
    }

    public static String sendMail(String email){
        boolean podeEnviar = true;
        String mensagem = "";
        M_Pessoa pessoa = null;
        try {
            pessoa = r_pessoa.findByEmail(email);
            if(pessoa == null){
                podeEnviar = false;
                mensagem = "E-mail não cadastrado!";
            }
        }catch (Exception e){
            podeEnviar = false;
            mensagem = "Erro ao processar a solicitação!";
        }

        if(podeEnviar){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(pessoa.getEmail());
            message.setSubject("Recuperação da Senha GreenCode");
            message.setText("Sua senha é: "+pessoa.getSenha()+"\nMuito Obrigado por utilizar o Green-Code");
            try {
                mailSender.send(message);
                mensagem = "E-mail de Recuperação enviado!";
            }catch (Exception e){
                mensagem = "Falha no envido do e-mail de Recuperação!";
            }
        }
        return mensagem;
    }
}



