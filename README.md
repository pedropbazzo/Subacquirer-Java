# Subacquirer-Java

SDK Subacquirer Java

## Utilizando o SDK

Após o cliente efetuar os passos de compra da loja, escolher o meio de pagamento Stelo e clicar em “Finalizar Compra”, a loja realizará a seguinte requisição com o SDK:

### Criando um pagamento

```java
// ...
Boolean bankSlip = true;

// Configure as credenciais da API
String clientId = "SEU CLIENT ID";
String clientSecret = "SEU CLIENT SECRET";

SteloAccount steloAccount = new SteloAccount(clientId, clientSecret);

// Crie uma instância de Subacquirer e defina as credenciais e o ambiente
Subacquirer subacquirer = new Subacquirer(steloAccount, Environment.SANDBOX);

// Crie a instância de Order, definindo o número do pedido e o código de segurança
Order order = new Order("100000005").setSecureCode("978455809540");

// Crie a instância de Payment, definindo os dados do pagamento
Payment payment = new Payment().setAmount(180.01)
                               .setFreight(44.99)
                               .setCurrency("BRL")
                               .addNewProduct("Coalesce: Functioning On Impatience T-Shirt", 180.01, 1, "001");

if (bankSlip) {
    payment.setPaymentType(PaymentType.BANK_SLIP);
} else {
    payment.setPaymentType(PaymentType.CREDIT)
           .setCard("TOKEN DO CARTÃO")
           .setInstallment(1);
}

// Crie a instância de Customer com os dados do cliente
Customer customer = new Customer().setIdentity("38292728805")
                                  .setName("Teste integração")
                                  .setEmail("teste@teste.com.br")
                                  .setBirthDate("1983-07-08")
                                  .setBillingAddress(new Address().setStreet("Rua Vitório Soriani")
                                                                  .setNumber("256")
                                                                  .setNeighborhood("JD Sabino")
                                                                  .setZipcode("14340000")
                                                                  .setCity("Brodowski")
                                                                  .setState("SP")
                                                                  .setCountry("BR"))
                                  .setShippingAddress(new Address().setStreet("Rua Vitório Soriani")
                                                                   .setNumber("256")
                                                                   .setNeighborhood("JD Sabino")
                                                                   .setZipcode("14340000")
                                                                   .setCity("Brodowski")
                                                                   .setState("SP")
                                                                   .setCountry("BR"))
                                  .addNewPhone("11", "24242424", Phone.Type.LANDLINE)
                                  .addNewPhone("11", "998989898", Phone.Type.CELL);

//
try {
    Transaction transaction = subacquirer.createTransaction(order, payment, customer);

    String orderId = transaction.getOrderData().getOrderId();
} catch (SteloException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
// ...
```
