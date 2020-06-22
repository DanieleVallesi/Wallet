## Wallet
This is a back end API that manage wallets of different customers.<br/>
##### Create user request: 
POST: `` http://localhost:8080/wallet/create-user``<br/>
BODY: ``{"userUuid" : "cf8d3cdd-07b4-4499-aede-cb5dd98a3be2", "name" : "Mark", "balance" : 1000 }``<br/>
##### Change user balance request: 
POST: `` http://localhost:8080/wallet/change-user-balance``<br/>
BODY: `` {"userUuid" : "cf8d3cdd-07b4-4499-aede-cb5dd98a3be2", "transactionUuid" : "08de1695-52cd-4f9a-86d5-00c4835188", "ammount" : 100 }``<br/>
##### Get user balance request: 
GET: `` http://localhost:8080/wallet/get-user-balance?userUuid=cf8d3cdd-07b4-4499-aede-cb5dd98a3be2 ``<br/>
##### Get transaction history request
GET: `` http://localhost:8080/wallet/transaction-history?userUuid=cf8d3cdd-07b4-4499-aede-cb5dd98a3be2 ``<br/>

##### Access DB: 
URL :``http://localhost:8080/h2-console``<br/>
JDBC URL: ``jdbc:h2:file:~/wallet-microservice-db``<br/>
Username : ``sa``<br/>
Password : ``no password, leave it empty``<br/>

### General Info

The db will be created in `` C:\Users\UserName\wallet-microservice-db.mv.db ``

#### Considerations

*Creating a new user and changing money in one account require a post and an external uuid. In this way if mistakenly multiple requests are sent, only the 1st one will be accepted and the others will be rejected*

*There are not tests as of now*

