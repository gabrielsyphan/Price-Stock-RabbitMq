# price-stock
A simple project to management of stock with RabbitMq, using Java springboot as consumer and another as producer.

### Startup

* Run "docker-compose -f docker-compose.yml up -d" on project root after clonning
* Open both consumer and producer projects and run "mvn spring-boot:run"
* Access RabbitMq on the link below with user: "admin" and password: "admin"


### URL's
| Service | Url                                       |
|---------|-------------------------------------------|
| Producer - price | http://localhost:8080/price      |
| Producer - stock | http://localhost:8080/stock      |
| RabbitMq         | http://localhost:15672           |

### Contact
[![Telegram](https://img.shields.io/badge/-@gabrielsyphan-0088CC?style=flat&logo=Telegram&logoColor=white&link=https://t.me/gabrielsyphan/)](https://t.me/gabrielsyphan "Telegram") [![E-mail](https://img.shields.io/badge/-gabrielsyphan@raccoonbit.com-c14438?style=flat&logo=Gmail&logoColor=white&link=mailto:gabrielsyphan@raccoonbit.com)](mailto:gabrielsyphan@raccoonbit.com "E-mail")
