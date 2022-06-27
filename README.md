# agro-techfields

##
### Contexto:
Uma cooperativa de plantação de soja decidiu automatizar parte do seu processo de cultivo para trazer mais qualidade aos grãos. A empresa que você trabalha, Agro Techfields, aceitou o desafio e foi contratada para desenvolver tal automação.

Sua equipe vai desenvolver o Back-end, batizado de measure shelter, que vai manter informações da lavoura para futuramente aplicar uma inteligência e automatizar todo o processo de plantação. Após muito se discutir, foi apresentada a versão inicial da arquitetura do sistema, representada na imagem abaixo:

![Arquitetura](https://user-images.githubusercontent.com/83831990/174906057-63928511-2abd-4b69-a66a-d2cf5a339d36.png)


Entende-se por ilhas os dispositivos que coletam medidas da área atual. Espalhadas pela lavoura, as ilhas colhem medidas de temperatura, umidade do ar e do solo, dentre outras relevantes para o cultivo de soja. A cada 5 minutos, esses dados são enviados para o sistema measure shelter.

Esse sistema será uma API REST que receberá as medidas coletadas pelas ilhas e as armazenará em um banco de dados MongoDB. Haverá um Front-end responsável pela interface de manutenção das ilhas, através do consumo da aplicação measure shelter. A cada 20 dias, um satélite coleta imagens da plantação e as envia para a aplicação que, por sua vez, armazena o material no banco de dados.

Muitas vezes, os sensores de medições das ilhas ficam inoperantes devido às condições climáticas. Nesse caso, faz-se necessário alterar o status da ilha afetada para inoperante, garantindo assim que os dados colhidos sejam ignorados pelo sistema. Quando consertados os sensores da ilha danificada, o status voltar a ser operante. Todo o controle do status deverá ser controlado pelo Back-end.

##
Como a arquitetura apresentada é inicial, sua equipe tem a liberdade para eventuais melhorias e modificações na proposta arquitetural.
##
### Requisitos técnicos:
- Utilizar Java, Mongo e Docker;
- Gerenciar as dependências com Gradle ou Maven;
- Utilizar framework Spring ou Quarkus para criação do serviço REST.

##
### Funcionalidades:
- Implementar um C.R.U.D. para as ilhas;
- Implementar um C.R.U.D. para as medidas realizadas pelas ilhas;
- Alterar o status da ilha; 
### Extra:
- Implementar três endpoints referentes às imagens recebidas pelo Satélite:
- Inserir uma imagem
- Listar todos as imagens
- Baixar (download) uma imagem específica

##
Você tem nas mãos a oportunidade de impressionar a cooperativa e crescer na Agro Techfields. Lembre-se que missão dada é missão cumprida! #VQV 🧑🏻‍🌾🚜
