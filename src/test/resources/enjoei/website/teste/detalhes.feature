#language: pt
#encoding: UTF-8

#r1: Deve exibir imagem, dados de pagamento, descrição do produto e outras informações
#r2: Deve exibir no final da pagina sugestões de produtos similares

Funcionalidade: Detalhes de um produto
  Como usuário, mesmo que não esteja logado
  Quero ver detalhes de um produto
  Para para ver mais informações do produto

  Contexto:
    Dado que o usuario esteja na home page
    Quando clicar sobre um produto

  Cenario: Validar imagem do produto
    Entao a imagem do produto deve estar visível

  Cenario: Validar dados de pagamento do produto
    Entao as formas de pagamento devem estar visíveis

  Cenario: Validar descrição do produto
    Entao deve ser possível ler a descrição do produto

  Cenario: Validar produtos similares no final da pagina
    Entao pagina deve mostrar tambem produtos similares

  Cenario: Validar titulo da pagina
    Entao nome do produto deve aparecer no titulo da pagina