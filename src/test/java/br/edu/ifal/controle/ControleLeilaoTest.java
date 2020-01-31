package br.edu.ifal.controle;

import static org.junit.Assert.assertEquals;

import java.beans.Transient;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifal.modelo.Cliente;
import br.edu.ifal.modelo.Lance;
import br.edu.ifal.modelo.Leilao;
import br.edu.ifal.modelo.Produto;

public class ControleLeilaoTest {

    Produto produto;
    double valorMinimo;
    Leilao leilao;
    Cliente cliente;
    Cliente cliente2;
    ControleLeilao controle;

    @Before
    public void inicializacao(){
        produto = new Produto("PS4", "video-game");
        valorMinimo = 2500;
        leilao = new Leilao(produto, valorMinimo);
        cliente = new Cliente(1, "Ana");
        cliente2 = new Cliente(2, "Zé");
        controle = new ControleLeilao();
    }


    @Test
    public void deveRetornarVerdadeiroParaUmLanceMaiorQueOValorMinimoDoProduto() {
        Lance novoLance = new Lance(cliente, 2501);
        boolean validadeRetornada = controle.validarLance(novoLance, leilao);
        boolean validadeEsperada = true;
        assertEquals(validadeEsperada, validadeRetornada);
    }
    @Test
    public void deveRetornarFalsoParaUmLanceMenorQueOValorMinimoDoProduto() {
        Lance novoLance = new Lance(cliente, 2000);
        boolean validadeRetornada = controle.validarLance(novoLance, leilao);
        boolean validadeEsperada = false;
        assertEquals(validadeEsperada, validadeRetornada);
    }
    @Test
    public void deveRetornarVerdadeiroParaUmLanceIgualAoValorMinimoDoProduto() {
        Lance novoLance = new Lance(cliente, 2500);
        boolean validadeRetornada = controle.validarLance(novoLance, leilao);
        boolean validadeEsperada = true;
        assertEquals(validadeEsperada, validadeRetornada);
    }

    @Test
    public void deveRetornarFalsoParaUmLanceDadoPeloMesmoClienteDoUltimoLance(){
        leilao.adicionarLance(new Lance(cliente, 2600));
        Lance novoLance = new Lance(cliente, 2700);
        boolean validadeRetornada = controle.validarLance(novoLance, leilao);
        boolean validadeEsperada = false;
        assertEquals(validadeEsperada, validadeRetornada);
    }

    @Test
    public void deveRetornarVerdadeiroParaUmLanceDadoPorUmClienteDiferenteDoClienteDoUltimoLance(){
        leilao.adicionarLance(new Lance(cliente, 2600));
        Lance novoLance = new Lance(cliente2, 2700);
        boolean validadeRetornada = controle.validarLance(novoLance, leilao);
        boolean validadeEsperada = true;
        assertEquals(validadeEsperada, validadeRetornada);
    }

    @Test
    public void deveRetornarVerdadeiroParaOPrimeiroLanceDoLeilaoMaiorQueOValorMinimo(){
        Lance novoLance = new Lance(cliente, 2700);
        boolean validadeRetornada = controle.validarLance(novoLance, leilao);
        boolean validadeEsperada = true;
        assertEquals(validadeEsperada, validadeRetornada);
    }
    
    @Test
    public void deveRetornarFalsoParaUmNovoLanceMenorQueOLanceAnterior(){
        leilao.adicionarLance(new Lance(cliente, 3000));
        Lance novoLance = new Lance(cliente2, 2900);
        boolean validadeRetornada = controle.validarLance(novoLance, leilao);
        boolean validadeEsperada = false;
        assertEquals(validadeEsperada, validadeRetornada);
    }
    @Test
    public void deveRetornarVerdadeiroParaUmLanceMaiorQueOLanceAnterior(){
        leilao.adicionarLance(new Lance(cliente, 4000));
        Lance novoLance = new Lance(cliente2, 4500);
        boolean validadeRetornada = controle.validarLance(novoLance, leilao);
        boolean validadeEsperada = true;
        assertEquals(validadeEsperada, validadeRetornada);
    }
    @Test 
    public void deveRetornarFalseParaUmNovoLanceIgualAoLanceAnterior(){
        leilao.adicionarLance(new Lance(cliente, 4000));
        Lance novoLance = new Lance(cliente2, 4000);
        boolean validadeRetornada = controle.validarLance(novoLance, leilao);
        boolean validadeEsperada = false;
        assertEquals(validadeEsperada, validadeRetornada);
    }
    


}