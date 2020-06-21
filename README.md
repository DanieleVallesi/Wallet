## Wallet Microservice
This microservice manage wallets of different customers.<br/>
##### Create user request: 
POST: `` http://localhost:8080/wallet/create-user``<br/>
BODY: ``{"userUuid" : "08de1695-52cd-4f9a-86d5-00c48a5a998f", "name" : "Mark", "balance" : 1000 }``<br/>
##### Add/remove money request: 
POST: `` http://localhost:8080/wallet/change-money``<br/>
BODY: `` {"userUuid" : "08de1695-52cd-4f9a-86d5-00c48a5a998f", "transactionUuid" : "177c36a4-edf7-4cb9-94d5-e2e3cbae06a7", "ammount" : -400 }``<br/>
##### Get user balance request: 
GET: `` http://localhost:8080/wallet/get-user-balance?userUuid=08de1695-52cd-4f9a-86d5-00c48a5a998f ``<br/>
##### Get transaction history request
GET: `` http://localhost:8080/wallet/transaction-history?userUuid=08de1695-52cd-4f9a-86d5-00c48a5a998f ``<br/>

##### Access DB: 
URL :``http://localhost:8080/h2-console``<br/>
JDBC URL: ``jdbc:h2:file:~/wallet-microservice-db``<br/>
Username : ``sa``<br/>
Password : ``no password, leave it empty``<br/>

### General Info

The db will be created in `` C:\Users\UserName\wallet-microservice-db.mv.db ``

#### Considerations

*Creating a new user and changing money in one account require a post and an external uuid. In this way if mistakenly multiple requests are sent, only the 1st one will be accepted and the others will be rejected*


