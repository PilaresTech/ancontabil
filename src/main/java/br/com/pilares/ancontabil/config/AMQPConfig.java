package br.com.pilares.ancontabil.config;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class AMQPConfig {

	@Bean
	public RabbitAdmin createRabbitAdmin(ConnectionFactory connection) {
		return new RabbitAdmin(connection);
	}
	
	@Bean
	public ApplicationListener<ApplicationReadyEvent> initializerAdmin(RabbitAdmin rabbitAdmin){
		return event -> rabbitAdmin.initialize();
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter jacksonConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jacksonConverter);
		return rabbitTemplate;
	}

	@Bean
	public Queue queueSolicitacaoPagamento() {
		return QueueBuilder.nonDurable("SOLICITACAO.PAGAMENTO").build();
	}
	
	@Bean
	public FanoutExchange exchangeNotificacaoSolicitacao() {
		return ExchangeBuilder.fanoutExchange("NOTIFICACAO.SOLICITACAO").build();
	}
	
	@Bean
	public Binding bindNotificacaoSolicitacaoPagamento(FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queueSolicitacaoPagamento()).to(exchangeNotificacaoSolicitacao());
	}
	
}
