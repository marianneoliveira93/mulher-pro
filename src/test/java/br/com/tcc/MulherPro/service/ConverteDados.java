package br.com.tcc.MulherPro.service;

import br.com.tcc.MulherPro.model.DadosVagas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ConverteDados implements IConverteDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DadosVagas> obterListaDados(String json, Class<DadosVagas> dadosVagasClass) {
        List<DadosVagas> listaVagas;
        try {
            JsonNode rootNode = null;
            try {
                rootNode = mapper.readTree(json);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            JsonNode jobResultsNode = rootNode.path("results");
            listaVagas = new ArrayList<>();
            for (JsonNode jobNode : jobResultsNode) {
                DadosVagas vaga = mapper.treeToValue(jobNode, DadosVagas.class);
                listaVagas.add(vaga);
            }
            return listaVagas;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}