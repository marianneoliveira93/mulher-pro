package br.com.tcc.MulherPro.service;

public interface IConverteDados {
   <T> T obterDados(String json, Class<T> classe);
}
