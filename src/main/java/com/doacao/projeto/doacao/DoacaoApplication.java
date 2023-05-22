package com.doacao.projeto.doacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doacao.projeto.doacao.domain.Campanha;
import com.doacao.projeto.doacao.domain.Doacao;
import com.doacao.projeto.doacao.domain.Doador;
import com.doacao.projeto.doacao.domain.Fundacoes;
import com.doacao.projeto.doacao.domain.HistoricoDoacao;
import com.doacao.projeto.doacao.domain.Ong;
import com.doacao.projeto.doacao.repositories.CampanhaRepository;
import com.doacao.projeto.doacao.repositories.DoacaoRepository;
import com.doacao.projeto.doacao.repositories.DoadorRepository;
import com.doacao.projeto.doacao.repositories.FundacoesRepository;
import com.doacao.projeto.doacao.repositories.OngRepository;

@SpringBootApplication
public class DoacaoApplication implements CommandLineRunner {

	@Autowired
	private DoacaoRepository doacaoRepository;

	@Autowired
	private DoadorRepository doadorRepository;

	@Autowired
	private CampanhaRepository campanhaRepository;

	@Autowired
	private OngRepository ongRepository;
	
	@Autowired
	private FundacoesRepository fundacoesRepository;

	public static void main(String[] args) {
		SpringApplication.run(DoacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*Doacao doa = new Doacao(null, "Toninho", "Boleto", 9.0);
		doacaoRepository.saveAll(Arrays.asList(doa));
		
		Doador d = new Doador(null, "Toninho", "RG", "RG", "999999", "23/05/2023", "Ativo");
		doadorRepository.saveAll(Arrays.asList(d));
		
		d.getDoacoes().add(doa);
		doadorRepository.saveAll(Arrays.asList(d));
		
		Campanha c = new Campanha(null, "20-03-2023", "20-04-2023", "10.000", "30.000","doado com amor","toninho");
		Campanha c1 = new Campanha(null, "25-03-2023", "25-04-2023", "10.000", "35.000","doado com amor","leticia");
		Campanha c2 = new Campanha(null, "30-03-2023", "30-04-2023", "10.000", "35.000","doado com amor","flavia");
		campanhaRepository.saveAll(Arrays.asList(c, c1,c2));
		
		d.getCampanha().add(c);
		doadorRepository.saveAll(Arrays.asList(d));
		
		Ong o = new Ong(null, "smflmksfdskdfm", "smdgldsndgs", "sfnnkdnjfks", "kjnsjkjdns", "skkdnfksjdfns");
		ongRepository.saveAll(Arrays.asList(o));
		
		o.getCampanhaOng().add(c1);
		ongRepository.saveAll(Arrays.asList(o));
		
		
		Fundacoes f = new Fundacoes(null, "Fundação 1", "(81) 9 9999-9999", "Rua 7", "899.3434/0001-09");
		fundacoesRepository.saveAll(Arrays.asList(f));	
		
		f.getCampanhaFundacoes().add(c2);
		fundacoesRepository.saveAll(Arrays.asList(f));
		
		
		doacaoRepository.saveAll(Arrays.asList(doa));
		HistoricoDoacao h = new HistoricoDoacao(null, "20-04-2023", "20.00", "Toninho", doa);
		doa.setHitoricoDoacao(h);
		
		doacaoRepository.saveAll(Arrays.asList(doa));*/
		
	}

}
