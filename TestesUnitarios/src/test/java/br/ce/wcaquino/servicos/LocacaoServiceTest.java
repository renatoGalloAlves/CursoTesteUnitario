package br.ce.wcaquino.servicos;


import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
@Rule
public ErrorCollector error = new ErrorCollector();

@Test
	public void testeLocacao() {
	
		LocacaoService service= new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme1", 2, 5.0);
		
		
		Locacao locacao= service.alugarFilme (usuario, filme);
	
		//         (valor esperado, Recebido, diferença por ser double);
		//Assert.assertEquals(5.0, locacao.getValor(), 0.01);
		
		//            (valor recebido, valor esperado);
		//assertThat(locacao.getValor(), is(equalTo(5.0)));
		//assertThat(locacao.getValor(), is(not(6.0)));
		//assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		//assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
		
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}
}

