#language: pt
#encoding: UTF-8

Funcionalidade: : Busca de itens
  Como usuário, mesmo que não esteja logado
  Quero realizar busca por itens
  Para encontrar o item que tenho interesse

  Cenário: Ao clicar no item de busca e não digitar um texto, deve exibir uma sugestão de categorias e buscas recentes
   Dado abrir o navegador no site da enjoei
    Quando clicar na busca sem texto digitado
    Então exibir sugestão de categorias e buscas recentes

  Cenário: : Deve ser possível buscar produtos
    Dado abrir o navegador no site da enjoei
    Quando clicar na busca por produto
    Então exibir a busca do produto

  Cenário: : Deve ser possível buscar lojas
    Dado abrir o navegador no site da enjoei
    Quando clicar na busca por loja
    Então exibir a busco da loja