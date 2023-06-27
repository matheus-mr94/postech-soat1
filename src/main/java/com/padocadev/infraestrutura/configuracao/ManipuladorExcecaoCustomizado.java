package com.padocadev.infraestrutura.configuracao;

import com.padocadev.dominio.excecao.cliente.ClienteNaoExisteExcecao;
import com.padocadev.dominio.excecao.cliente.JaExisteClienteExcecao;
import com.padocadev.dominio.excecao.produto.JaExisteProdutoExcecao;
import com.padocadev.dominio.excecao.produto.ProdutoNaoExisteExcecao;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManipuladorExcecaoCustomizado {

    public record MensagemDeErroApi(String erro) {
    }

    @ExceptionHandler(ClienteNaoExisteExcecao.class)
    public ResponseEntity<Object> manipulaClienteNaoExisteExcecao(ClienteNaoExisteExcecao excecao) {

        MensagemDeErroApi mensagemDeErroApi = new MensagemDeErroApi(excecao.getMessage());

        return new ResponseEntity<>(mensagemDeErroApi, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JaExisteClienteExcecao.class)
    public ResponseEntity<Object> manipulaJaExisteClienteExcecao(JaExisteClienteExcecao excecao) {

        MensagemDeErroApi mensagemDeErroApi = new MensagemDeErroApi(excecao.getMessage());

        return new ResponseEntity<>(mensagemDeErroApi, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ProdutoNaoExisteExcecao.class)
    public ResponseEntity<Object> manipulaProdutoNaoExisteExcecao(ProdutoNaoExisteExcecao excecao) {

        MensagemDeErroApi mensagemDeErroApi = new MensagemDeErroApi(excecao.getMessage());

        return new ResponseEntity<>(mensagemDeErroApi, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JaExisteProdutoExcecao.class)
    public ResponseEntity<Object> manipulaJaExisteProdutoExcecao(JaExisteProdutoExcecao excecao) {

        MensagemDeErroApi mensagemDeErroApi = new MensagemDeErroApi(excecao.getMessage());

        return new ResponseEntity<>(mensagemDeErroApi, HttpStatus.CONFLICT);
    }
}
