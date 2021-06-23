package com.br.sample.feature.datasource;

// Projeto baseado em: https://refactoring.guru/pt-br/design-patterns/decorator

/*
 * Estrurura do design pattern decorator
 *
 * 1) Defini-se uma interface Component que define um ou mais metodos/comportamentos.
 *
 * Essa interface será envolvida pela classe Decorator Base, que servira
 * de modelo para outros decorators que irão da mesma forma envolver o
 * componente e poderao adicionar acoes antes e depois de cada execucao
 * dos metodos da interface
 *
 * Essa mesma interface será usada para criar componentes concretos que implementarao
 * seus proprios comportamentos que poderao ser extendidos pelos decorators
 *
 * 2) define-se ImplComponent1, ImplComponent2, ImplComponentN : Component.
 * Quantos forem necessarios. Essas sao as implementacoes de Component que
 * serao passadas para o Decorator.
 *
 * Como os Decorators tem uma relacao tanto de extensao como de composicao, fica obvio
 * a possibilidade de envolver as chamadas dos metodos dos components e adicionar
 * comportamentos antes e depois de cada chamada
 *
 * 3) A Classe DecoratorBase eh um Component e ainda eh composto por um Component/Wrapper. Ela
 * delega ao ComponentWrapped todas as operacoes
 *
 * 4) A classes filhas de DecoratorBase definem os comportamentos adicionais ao sobreescreverem
 * os metodos da sua super classe e ainda receberem em seus construtores implementacoes
 * de componentes q
 *
 **/