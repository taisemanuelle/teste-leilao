package br.edu.ifal.controle;

import br.edu.ifal.modelo.Lance;
import br.edu.ifal.modelo.Leilao;

public class ControleLeilao{

    public boolean validarLance(Lance novoLance, Leilao leilao){
        boolean validade = false;
        if(novoLance.getValor() >= leilao.getValorMinimo()){
          validade = true;
        }
        return validade;
    }
}