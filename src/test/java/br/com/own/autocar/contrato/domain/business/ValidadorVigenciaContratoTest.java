package br.com.own.autocar.contrato.domain.business;

import br.com.own.autocar.contrato.domain.business.validador.ValidadorVigencia;
import br.com.own.autocar.contrato.domain.model.InformacaoComplementar;
import br.com.own.autocar.utility.date.DateUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ValidadorVigenciaContratoTest {

    private InformacaoComplementar informacaoComplementar;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void deveLancarExcecaoParaVigenciaInvalida(){
        dadoInformacoesComplementaresComVigenciaInvalida();
        deveLancarExcecao();
        quandoValidado();
    }

    private void quandoValidado() {
        new ValidadorVigencia().validar(InformacaoComplementar::isVigenciaValida, informacaoComplementar);
    }

    private void deveLancarExcecao() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("As informacoes de vigencia do contrato nao sao validas!");
    }

    private void dadoInformacoesComplementaresComVigenciaInvalida() {
        informacaoComplementar = new InformacaoComplementar();
        informacaoComplementar.setDataFim(DateUtil.getDataAtual());
        informacaoComplementar.setDataInicio(DateUtil.getDataAtual());
    }

}