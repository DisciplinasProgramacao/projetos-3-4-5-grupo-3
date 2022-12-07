# Projeto 4 - Gestão de Frota (parte 2)

## Nota: 14,5

## Comentários
	- Sem arquivo de dados de veículos para testar... 
	- Corrijam a inserção de veículos falada no Projeto3, ou serão muito penalizados no 5.
	- opção 11 do menu não está no menu
	- contribuições muito desiguais no Kanban e no histórico do projeto
	
## Correção

### Modelagem: 1,8/2   
	- Modularização de tanque e combustível: tanque contém/relacionado com combustível
	
### Requisitos dos veículos, de acordo com a modelagem: 5,7/9  
	- Restrição de combustível: 1,5/3 -- está lá, mas sem opção: fixo no código
	- Abastecimento e autonomia: 1,2/3 -- sem classe tanque. Olha a conta maluca na linha 83 de Veiculo.java
	- Custos fixos e variáveis: 3/3
	
### Requisitos da empresa no programa principal: 7/9 
	- Quilometragem média das rotas da empresa: 2/3 -- agora sabemos streams...  
	- Filtro para busca de rotas por data: 2/3  -- agora sabemos AEDs-II e streams. Busca n² não pode.
	- Um dos dois abaixo: 3/3
		- Os 3 veículos que mais fizeram rotas 
		- Lista de veículos ordenada decrescentemente por custos gerados 

