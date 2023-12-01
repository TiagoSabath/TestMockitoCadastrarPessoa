package example;

import org.example.ApiDosCorreios;
import org.example.CadastrarPessoa;
import org.example.DadosLocalizacao;
import org.example.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro(){
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("DF", "Brasilia", "Qno 19", "13", "Ceilandia");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("12434")).thenReturn(dadosLocalizacao);
        Pessoa p1 = cadastrarPessoa.cadastrarPessoa("Tiago", "12314", LocalDate.now(), "12434");

        assertEquals("Tiago", p1.getNome());
        assertEquals("12314", p1.getDocumento());
        assertEquals("DF", p1.getEndereco().getUf());
        assertEquals("Ceilandia", p1.getEndereco().getBairro());

    }
}
