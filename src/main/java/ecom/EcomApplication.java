package ecom;


import ecom.domain.model.Produto;
import ecom.domain.repositories.RepositorioPedido;
import ecom.domain.repositories.RepositorioProduto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class EcomApplication {

    private static final Logger log = LoggerFactory.getLogger(EcomApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(EcomApplication.class, args);

    }


    @Bean
    public CommandLineRunner inicializaDadoDemo(RepositorioPedido repositorioPedido, RepositorioProduto repositorioProduto) {
        return (args) -> {


            //Cria alguns produtos para as consultas
            repositorioProduto.save(new Produto("Água", 1.5));
            repositorioProduto.save(new Produto("Pastel", 4.5));
            repositorioProduto.save(new Produto("Parafuso", .3));


            log.info("Produtos found with findAll():");
            log.info("-------------------------------");
            for (Produto produto : repositorioProduto.findAll()) {
                log.info(produto.getNome());
            }

            log.info("");
        };
    }
}
