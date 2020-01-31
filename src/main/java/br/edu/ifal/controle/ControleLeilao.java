package br.edu.ifal.controle;

import br.edu.ifal.modelo.Cliente;
import br.edu.ifal.modelo.Lance;
import br.edu.ifal.modelo.Leilao;

public class ControleLeilao{

    public boolean validarLance(Lance novoLance, Leilao leilao){
        boolean validade = false;
        if(novoLance.getValor() >= leilao.getValorMinimo()){
          Cliente clienteDoLance = novoLance.getCliente();
          if(leilao.getLances().isEmpty()){
            validade = true;
          } else {
            if(!clienteDoLance.equals(getClienteDoUltimoLance(leilao))){
              double valorUltimoLance = leilao.getLances().get(leilao.getLances().size() - 1).getValor();
              if(novoLance.getValor() > valorUltimoLance){
                validade = true;
              }
            }
          }          
        }
        return validade;
    }

    private Cliente getClienteDoUltimoLance(Leilao leilao){
        Cliente cliente;
        Lance ultimoLance = leilao.getLances().get(leilao.getLances().size() - 1);
        cliente = ultimoLance.getCliente();
        return cliente;
    }

    public boolean punirCliente(Cliente cliente, Leilao leilao){
      int quantidadeDeLances = 0;
      boolean punicao = false;
      for (Lance lance : leilao.getLances()) {
        if(cliente.equals(lance.getCliente())){
          quantidadeDeLances++;
        }
      }
      if(quantidadeDeLances > 3 || quantidadeDeLances == 0)
        punicao = true;
        return punicao;
    }
}