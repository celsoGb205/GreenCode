package com.Site.GreenCode.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S_Generico {


        public static boolean validarEmail(String email) {
            // Expressão regular para validar um endereço de e-mail
            String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

            // Compila a expressão regular em um padrão
            Pattern pattern = Pattern.compile(regex);

            // Cria um objeto Matcher para comparar o email com o padrão
            Matcher matcher = pattern.matcher(email);

            // Retorna verdadeiro se o email corresponde ao padrão, falso caso contrário
            return matcher.matches();
        }

        public static String limparNumero(String num) {
            // Remove caracteres, apenas os dígitos serão mantidos
            return num.replaceAll("[^0-9]", "");
        }

        public static boolean textoEstaVazio(String texto) {
            return texto == null || texto.trim().equals("");
        }

    }


