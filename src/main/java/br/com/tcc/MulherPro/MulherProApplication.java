package br.com.tcc.MulherPro;

//importações necessárias para aplicação
import br.com.tcc.MulherPro.model.DadosVagas;
import br.com.tcc.MulherPro.service.ApiVagas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


@SpringBootApplication
public class MulherProApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MulherProApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//cabeçalho da tabela
		System.out.printf("%-30s %-30s %-30s %-50s%n", "TÍTULO", "EMPRESA", "LOCALIDADE", "LINK");
		System.out.println("=".repeat(140));

		//método vai receber a url api e buscar por dados e retorna json
		var ApiVagas = new ApiVagas();
		var json = ApiVagas.obterDados("https://api.adzuna.com/v1/api/jobs/br/search/2?app_id=17023f35&app_key=1d0dc3753b626b859411de412e2d43cc");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		List<DadosVagas> dados = conversor.obterListaDados(json, DadosVagas.class);


		for (DadosVagas vaga : dados) {
			System.out.println("Descrição da vaga: ");
			System.out.printf("Título: %-10s%n", vaga.titulo());
			System.out.printf("Empresa: %-30s%n", vaga.empresa());
			System.out.printf("Localidade: %-30s%n", vaga.localidade());
			System.out.printf("Link: %-50s%n", vaga.link());
		}
	}


	}
