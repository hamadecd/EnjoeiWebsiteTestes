#language: pt
#encoding: UTF-8

#r1: Deve exibir imagem, dados de pagamento, descrição do produto e outras informações
#r2: Deve exibir no final da pagina sugestões de produtos similares

@Detalhes
Funcionalidade: Detalhes de um produto
  Como usuário, mesmo que não esteja logado
  Quero ver detalhes de um produto
  Para ver mais informações do produto

  Contexto:
    Dado que o usuario esteja na pagina do produto

  @Smoke
  Cenario: Validar imagem do produto
    Entao a imagem do produto deve estar visível

  @Smoke
  Cenario: Validar dados de pagamento do produto
    Entao as formas de pagamento devem estar visíveis

  @Regression
  Cenario: Validar descrição do produto
    Entao deve ser possível ler a descrição do produto

  @Regression
  Cenario: Validar produtos similares no final da pagina
    Entao pagina deve mostrar tambem produtos similares

  @Regression
  Cenario: Validar titulo da pagina
    Entao nome do produto deve aparecer no titulo da pagina