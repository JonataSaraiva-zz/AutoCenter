package br.com.own.autocar.contrato.domain.business.validador;

import br.com.own.autocar.contrato.domain.model.InformacaoComplementar;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.function.Predicate;

@Service
@RequestScope
public class ValidadorVigencia implements ValidadorInformacaoComplementar, Validador {

    private static final String MESSAGE_EXCECAO = "As informacoes de vigencia do contrato nao sao validas!";

    @Override
    public <T> void validar(InformacaoComplementar informacaoComplementar) {
        this.validar(InformacaoComplementar::isVigenciaValida, informacaoComplementar);
    }

    @Override
    public <T> void validar(Predicate<T> condition, T t) {
        if(condition.test(t)){
            throw new RuntimeException(MESSAGE_EXCECAO);
        }
    }
}
