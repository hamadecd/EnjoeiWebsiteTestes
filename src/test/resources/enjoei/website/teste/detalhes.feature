#language: pt
#encoding: UTF-8

#r1: Deve exibir imagem, dados de pagamento, descrição do produto e outras informações
#r2: Deve exibir no final da pagina sugestões de produtos similares

Funcionalidade: Detalhes de um produto
  Como usuário, mesmo que não esteja logado
  Quero ver detalhes de um produto
  Para para ver mais informações do produto

  Cenario: Validar imagem do produto
    Dado que o usuario esteja na home page
    Quando clicar sobre um produto
    Entao a imagem do produto deve estar visível

  Cenario: Validar dados de pagamento do produto
    Dado que o usuario esteja na home page
    Quando clicar sobre um produto
    Entao as formas de pagamento devem estar visíveis