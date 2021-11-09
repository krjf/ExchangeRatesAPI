==============================================
##== SpringBoot Sample Rest application ==
==============================================

@author Krishna V


##1. Given UseCases

###This simple sample application illustrates a couple of Sample given use cases in given Assessment documents


UseCase 1: Loading data into database

UseCase 2: Exposing data


##2. Details about Implementation of those above 2 Use cases

 ### Used the below Exchange Rates API end-point to fetch ExchangesRates for different currency codes
   http://api.exchangeratesapi.io/v1/latest?access_key=99cf91745131431371f3b14c97a58a94

   ###Below is the ExchangeRates Result json,we are getting when we invoke the above end-point
   http://api.exchangeratesapi.io/v1/latest?access_key=99cf91745131431371f3b14c97a58a94&format=1

 ### Even though Service Layer (interface ExchangeRatesService & ExchangeRatesServiceImpl ) is not required here ( since we don't have much Business logic),just implemented as a best practice.

### There is a Controller class ExchangeRatesController.java, which is having 2 methods for these 2 use cases

      Method 1: getExchangeRatesAndStoreInDB for fetching Exchanges Rates from end-point and store in DB(Used H2 in-memory DB)
      Method 2: displayExchangeRatesToUserFromDB for to expose or display this ExchangeRates data to user from DB based on User requested Currency code.

 ### Used RestTemplate to invoke third party Rest end-point ( Also we can use FeignClients)

### Used H2 in-memory db to store the data and used lombok for to avoid getters and setters



